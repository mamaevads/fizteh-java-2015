package ru.fizteh.fivt.students.mamaevads.threads;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlockingQueue<T> {
    private final int capacity;
    private Lock lock;
    private Condition canTake;
    private Condition canPut;
    private Queue<T> elements;

    public BlockingQueue(int maxQueueSize) {
        capacity = maxQueueSize;
        elements = new LinkedList<>();
        lock = new ReentrantLock();
        canTake = lock.newCondition();
        canPut = lock.newCondition();
    }

    public final void offer(List<T> newElements) throws InterruptedException, TimeoutException {
        offer(newElements, 0);
    }
    public final List<T> take(int count) throws InterruptedException {
        return take(count, 0);
    }

    public final void offer(List<T> newElements, long timeout) throws InterruptedException, TimeoutException {
        lock.lock();
        try {
            long time = TimeUnit.MILLISECONDS.toNanos(timeout);
            boolean addable = true;
            while ((timeout == 0 || time > 0) && elements.size() + newElements.size() > capacity ) {
                if (timeout == 0) {
                    canPut.await();
                } else {
                    time = canPut.awaitNanos(time);
                    if (time < 0) {
                        addable = false;
                    }
                }
            }
            if (addable) {
                elements.addAll(newElements);
                if (newElements.size() > 0) {
                    canTake.signal();
                }
            } else {
                throw new TimeoutException("Smth went wrong");
            }
        } finally {
            lock.unlock();
        }
    }


    public final List<T> take(int count, long timeout) throws InterruptedException {
        lock.lock();
        try {
            boolean canPoll = true;
            long time = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (elements.size() < count && (timeout == 0 || time > 0)) {
                if (timeout == 0) {
                    canTake.await();
                } else {
                    time = canTake.awaitNanos(time);
                    if (time < 0) {
                        return null;
                    }
                }
            }
            List<T> trying = new ArrayList<>();
            for (int i = 0; i < count; ++i) {
                trying.add(elements.poll());
            }
            if (count > 0) {
                canPut.signal();
            }
            return trying;
        } finally {
            lock.unlock();
        }
    }


}