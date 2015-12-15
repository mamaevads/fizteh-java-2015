package ru.fizteh.fivt.students.mamaevads.threads;

public class NumerableThread {

    public static void main(String[] args) {
        new NumerableThread(Integer.valueOf(args[0]));
    }

    private Integer parent;
    private final int num;

    public class Counter extends Thread {
        private int number;

        public Counter(int myNumber) {
            number = myNumber;
        }

        @Override
        public final void run() {
            while (true) {
                synchronized (parent) {
                    if (parent.equals(number - 1)) {
                        System.out.println("Thread-" + number);
                        parent++;
                        if (parent.equals(num)) {
                            parent = 0;
                        }
                    }
                }

            }
        }
    }

    public NumerableThread(int numThreads) {
        parent = 0;
        num = numThreads;
        for (int i = 0; i < num; ++i) {
            Thread mrCount = new Counter(i + 1);
            mrCount.start();
        }
    }
}




