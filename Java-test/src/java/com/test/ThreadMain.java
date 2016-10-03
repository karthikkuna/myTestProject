package com.test;

import java.util.Date;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			final ThreadTest<Date> thread = new ThreadTest<>();
//
//			Thread t = new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					System.out.println(thread.get());
//					System.out.println(thread.get());
//					System.out.println(thread.get());
//
//					System.out.println(thread.get());
//				}
//			});
//			System.out.println(thread.get());
//			System.out.println(thread.get());
//			System.out.println(thread.get());
//
//			System.out.println(thread.get());
                          int historyStartFreq=4;
        int frequencyDivision=4;
        System.out.println((historyStartFreq - 1) * frequencyDivision + 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
