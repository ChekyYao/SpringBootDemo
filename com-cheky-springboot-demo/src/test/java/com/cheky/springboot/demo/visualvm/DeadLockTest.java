package com.cheky.springboot.demo.visualvm;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Dead Lock
 *
 * @author ChekyYao
 * @date 2020-12-11
 */
public class DeadLockTest {
    public static void main(String[] args) throws IOException {
        var lock1 = new ReentrantLock();
        var lock2 = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.lock();
                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName() + "Start");
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName() + "End");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.lock();
                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName() + "Start");
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName() + "End");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread2").start();

        System.in.read();
    }
}
