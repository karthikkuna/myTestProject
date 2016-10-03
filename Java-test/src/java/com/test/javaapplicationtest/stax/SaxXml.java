/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest.stax;

/**
 *
 * @author Karthikeyan.Subraman
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaxXml {

    public static void main(String[] args) {
        long df = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(10);
        int count = 0;
        AtomicInteger aint = new AtomicInteger();
        List<Future> task = new ArrayList<>();
        try {
//            String fileName = "C:\\Users\\Karthikeyan.Subraman\\Documents\\NetBeansProjects\\JavaApplicationTest\\src\\javaapplicationtest\\stax\\staxXml.xml";
            String fileName = "D:\\Karthik\\Excel from sql\\ETL\\sales.csv_20160624_123717.csv";
//        List<Employee> empList = parseXML(fileName);
//        for (Employee emp : empList) {
//            System.out.println(emp.toString());
//        }
//            RandomAccessFile rf = new RandomAccessFile(new File(""), "r");
//            LineNumberReader lr = new LineNumberReader(new FileReader(fileName));
//            lr.setLineNumber(10);

//            System.out.println(lr.getLineNumber());
//            System.out.println(lr.readLine());
            String fiel = "Example.txt";
            FileInputStream fis = new FileInputStream(new File(fiel));

            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Example.txt")));
//            List<String> sd = new LinkedList<>();
            List<String> sd = new ArrayList<>();

            String line = null;

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                bw.write(line + "\n");
                sd.add(line);
                count++;
                if (count % 10000 == 0) {
                    task.add(service.submit(new Job(sd, aint)));
//                    new Job(sd, aint).run();
                    sd = new ArrayList<>();
//                    count = 0;
                }

            }
            if (count > 0) {
                service.submit(new Job(sd, aint));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                service.shutdown();
//                service.awaitTermination(1, TimeUnit.SECONDS);
                System.out.println("thread size :"+task.size());
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

    static class Job implements Runnable {

        List<String> list;
        AtomicInteger aint;

        public Job(List<String> list, AtomicInteger aint) {
            this.list = list;
            this.aint = aint;
        }

        @Override
        public void run() {
            try {
                long df = System.currentTimeMillis();
                System.out.println("Processing List in Thread :" + Thread.currentThread().getName());
                for (String string : list) {
                    String[] arr = string.split("\\|");
                }
                Thread.sleep(500);
                long end = System.currentTimeMillis();
                System.out.println("Completed " + Thread.currentThread().getName() + " in " + (end - df));
                aint.set(aint.get() + list.size());
                list.clear();
                list=null;
            } catch (Exception ex) {
                Logger.getLogger(SaxXml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
