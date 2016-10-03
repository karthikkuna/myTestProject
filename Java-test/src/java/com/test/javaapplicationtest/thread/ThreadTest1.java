/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        try {
            //        Thread
            Thread t = new Thread(new Job());
            t.start();
            t.join(1000);
            System.out.println("Main Thread--");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " completed");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTest1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
