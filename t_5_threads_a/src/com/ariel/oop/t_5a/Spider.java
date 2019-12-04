package com.ariel.oop.t_5a;

public class Spider implements Runnable {
    int mSleep;
    int mTimes;

    Spider(int sleep, int times) {
        mSleep = sleep;
        mTimes = times;
    }

    public void print() {
        for (int i = 0; i < mTimes; i++) {
            System.out.print("Spider - ");

            try {
                Thread.sleep(mSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        print();
    }
}
