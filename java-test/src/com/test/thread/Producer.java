package com.test.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
        	System.out.println("Starting Producer");
            queue.put("1");
            System.out.println("put Producer");
//            Thread.sleep(1000);
            System.out.println("after sleep");
            queue.put("2");
            System.out.println("put Producer");
//            Thread.sleep(1000);
            System.out.println("after sleep");
            queue.put("3");
            System.out.println("put Producer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}