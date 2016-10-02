package com.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalTest<FUCK> implements Runnable {
	public FinalTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	int a;
	private static final ThreadLocal<SimpleDateFormat> dateFormat;
	static {
		dateFormat = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				System.out.println("Initializing SimpleDateFormat for - " + Thread.currentThread().getName());
				return new SimpleDateFormat("dd/MM/yyyy");
			}
			@Override
			public SimpleDateFormat get() {
				// TODO Auto-generated method stub
//				System.out.println("get SimpleDateFormat for - " + Thread.currentThread().getName());
				SimpleDateFormat df=super.get();
				System.out.println(Thread.currentThread().getName()+": df :"+df.hashCode());
				return df;
			}
		};
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FinalTest ft = new FinalTest();
		Thread t1 = new Thread(ft);
		Thread t2 = new Thread(ft);
		t1.start();
		t1.join();
		
		t2.start();
		get();
	}

	@SuppressWarnings("finally")
	private static <FUCK> FUCK get() {
		FUCK f;
		Class<FUCK> h=null;
		try {
			System.out.println("Inside try");
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("inside catch:");
			System.out.println("Fuck :" + Math.random());
			return h.cast("");
		} finally {
			System.out.println("inside finally");
			return h.cast("");
		}
		
		
		return h.cast("");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread run execution started for " + Thread.currentThread().getName());
		System.out.println("Date formatter pattern is  " + dateFormat.get().toPattern());
		System.out.println(" dateFormat.get()"+ dateFormat.get());
		System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
//		throw new ChuckNorrisException();
		WeakReference<String> wf=new WeakReference<String>("");
		SoftReference<String> ef=new SoftReference<String>("");
	}
}
