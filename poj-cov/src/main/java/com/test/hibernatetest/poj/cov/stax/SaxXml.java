/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatetest.poj.cov.stax;

/**
 *
 * @author Karthikeyan.Subraman
 */
import com.test.hibernatetest.poj.cov.util.SessionUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import org.hibernate.Session;

public class SaxXml {

    public static final String ui = "INSERT INTO world.products( pname1, pname2, pname3, pname4, pname5, pname6, pname7, pname8, pname9, pname10, pname11, pname12, pname13, pname14, pname15, pname16, pname17) VALUES ";

    public static void main(String[] args) {
        long df = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(11);
        int count = 0;
        AtomicInteger aint = new AtomicInteger();
        List<Future> task = new ArrayList<Future>();
        String fiel = "Example.txt";
        try (FileInputStream fis = new FileInputStream(new File(fiel));
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));) {
            service.submit(new SessionJob()).get();
            List<String> sd = new ArrayList<>();
            Semaphore sema = new Semaphore(11);
            String line = null;

            while ((line = br.readLine()) != null) {
                sd.add(line);
                count++;
                if (count % 10000 == 0) {
                    long start = System.currentTimeMillis();
                    System.out.println("Acquiring Permit :for Count :" + count);
                    sema.acquire(1);
                    System.out.println("Acquired Permit : for count :" + count + " with waiting time :" + (System.currentTimeMillis() - start));
                    task.add(service.submit(new Job(sd, aint, sema)));
//                    new Job(sd, aint).run();
                    sd = new ArrayList<>();
                }

            }
            if (count > 0) {
                task.add(service.submit(new Job(sd, aint, sema)));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                service.shutdown();
//                service.awaitTermination(1, TimeUnit.SECONDS);
                System.out.println("task size :" + task.size());
                for (Future future : task) {
                    future.get();
                }
                long end = System.currentTimeMillis();
                System.out.println(end - df);
                System.out.println("line number :" + count);
                System.out.println("processed line :" + aint.get());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static class SessionJob implements Runnable {

        @Override
        public void run() {
            SessionUtil.getInstance().getSessionFactory();
            System.out.println("Intailezed Session :");

        }

    }

    static class Job implements Runnable {

        List<String> list;
        AtomicInteger aint;
        Semaphore sema;

        public Job(List<String> list, AtomicInteger aint, Semaphore sema) {
            this.list = list;
            this.aint = aint;
            this.sema = sema;
        }

        @Override
        public void run() {
            StringBuilder sd = new StringBuilder(ui);
            try {
                long df = System.currentTimeMillis();
                System.out.println("Processing List in Thread :" + Thread.currentThread().getName());
                Session se = SessionUtil.getInstance().getSessionFactory().openSession();

                for (int i = 0; i < list.size(); i++) {
                    String string = list.get(i);
                    String[] arr = string.split("\\|");
                    sd.append(Arrays.toString(arr).replaceAll(" +", " ").replace(", ", "','").replace("[ ", "('").replace("]", "'),").replace(" ", ""));
                    if (i % 500 == 0) {
                        String sdf = sd.substring(0, sd.length() - 1);
                        se.createSQLQuery(sdf).executeUpdate();
                        sd.setLength(0);
                        sd.append(ui);
                    }

                }
                if (sd.length() > ui.length()) {
                    String sdf = sd.substring(0, sd.length() - 1);
                    se.createSQLQuery(sdf).executeUpdate();
                }
                se.close();

                long end = System.currentTimeMillis();
                System.out.println("Completed " + Thread.currentThread().getName() + " in " + (end - df));
                aint.set(aint.get() + list.size());
                list.clear();
                list = null;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("sdf---" + sd);
            } finally {
                sema.release(1);
            }
        }
    }
}
