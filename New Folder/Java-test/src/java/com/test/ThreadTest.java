package com.test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest< T extends Date> extends ThreadLocal<Date> {
	AtomicInteger inte = new AtomicInteger(1);

	@Override
	protected Date initialValue() {
		// TODO Auto-generated method stub
		return new Date();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		super.remove();
	}

	@Override
	public void set(Date value) {
		// TODO Auto-generated method stub
		super.set(value);
	}

	@Override
	public Date get() {
		// TODO Auto-generated method stub
		try{
			Date date=super.get();
			System.out.println("date in get :"+date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return super.get();
	}
}
