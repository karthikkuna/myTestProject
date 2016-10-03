/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest.thread;

import java.util.Date;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        try {
//            CyclicBarrier.
//            Semaphore df=new Semaphore(9);
//            Exchanger sd=new Exchanger();
//            Count
//            sd.
//            df.
//            new java.util.concurrent.ForkJoinPool().
//            java.lang.t
                    
            ExecutorService service = Executors.newFixedThreadPool(3);
            ThreadLocalImpl<Date> impl = new ThreadLocalImpl();
            Job job = new Job(impl);
            Future f1 = service.submit(job);
//            System.out.println("future 1 :"+f1.get());
            Thread.sleep(1000);
//            job = new Job(impl);
            f1=service.submit(job);
//             System.out.println("future 2 :"+f1.get());
            Thread.sleep(1000);
//            job = new Job(impl);
            f1=service.submit(job);
             System.out.println("future 3 :"+f1.get());
//          
           f1=service.submit(job);
             System.out.println("future 4 :"+f1.get());
//          
            System.out.println("END :");
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }  catch (ExecutionException ex) {
            Logger.getLogger(ThreadLocalTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static class Job implements Runnable {

        static AtomicInteger in = new AtomicInteger();
        final ThreadLocalImpl<Date> date;

        public Job(ThreadLocalImpl<Date> date) {
            this.date = date;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Thread Name:" + Thread.currentThread().getName() + " times :" + in.getAndIncrement() + " : date -" + date.get().getTime());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    static class ThreadLocalImpl<T extends Date> extends ThreadLocal<Date> {

        @Override
        protected Date initialValue() {
            try {
                System.out.println("calling initialValue");

                return new Date();
//To change body of generated methods, choose Tools | Templates.
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}
