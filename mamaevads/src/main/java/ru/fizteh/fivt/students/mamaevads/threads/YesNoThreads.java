package ru.fizteh.fivt.students.mamaevads.threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class YesNoThreads implements Runnable {

    public static void main(String[] args) {
        new YesNoThreads(Integer.valueOf(args[0])).run();
    }

    private static final int ONEFROM = 10;

    private Integer yesCounter;
    private Semaphore yourTurn;
    private Boolean roundEnd;
    private int readyCount;
    private int numThreads;
    private Answerer[] students;


    public YesNoThreads(int newThreadCount) {
        numThreads = newThreadCount;
        yesCounter = 0;
        roundEnd = false;
        yourTurn = new Semaphore(numThreads);
        try {
            yourTurn.acquire(numThreads);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        students = new Answerer[numThreads];
        for (int i = 0; i < numThreads; ++i) {
            students[i] = new Answerer();
            try {
                students[i].canAnswer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    @Override
    public final void run() {
        boolean allReady = false;
        for (int i = 0; i < numThreads; ++i) {
            students[i].start();
        }
        while (!allReady) {
            System.out.println("Are you ready?");
            letThemGo();
            try {
                yourTurn.acquire(numThreads);
                synchronized (yesCounter) {
                    if (readyCount == numThreads) {
                        allReady = true;
                        roundEnd = true;
                        letThemGo();
                    }
                    yesCounter = 0;
                    readyCount = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void letThemGo() {
        for (int i = 0; i < numThreads; ++i) {
            students[i].canAnswer.release();
        }
    }

    public class Answerer extends Thread {
        private Random probable = new Random();
        private Semaphore canAnswer = new Semaphore(1);

        @Override
        public final void run() {
            while (true) {
                try {
                    canAnswer.acquire();
                    synchronized (roundEnd) {
                        if (roundEnd) {
                            return;
                        }
                    }
                    boolean yesAnsw = true;
                    if (probable.nextInt(ONEFROM) == 0) {
                        yesAnsw = false;
                    }
                    if (!yesAnsw) {
                        System.out.println(getName() + ": No");
                    } else {
                        System.out.println(getName() + ": Yes");
                    }
                    synchronized (yesCounter) {
                        yesCounter++;
                        if (yesAnsw) {
                            readyCount++;
                        }
                    }
                    yourTurn.release();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}