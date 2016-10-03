package com.test.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class Genericsd<T extends ArrayList> {
	public static void main(String[] a) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(a));

	}

	private void gret() {
		// TODO Auto-generated method stub
		List<T> fuck = new ArrayList<>();
		List<? extends Number> fuck1 = new ArrayList<Long>();
		List<T> fuck2 = new ArrayList<>();
		List<T> fuck3 = new ArrayList<>();
		List<T> fuck4 = new ArrayList<>();
//		java.util.concurrent.locks.
				
		
	}
}
