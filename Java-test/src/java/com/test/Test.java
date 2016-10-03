package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Guruprasad
 *
 */
public class Test {
	static List<char[]> list = new ArrayList<>();
	static int cursor = 0;

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		try {
			String sd = "abaabasrs";
			char[] arry = sd.toCharArray();
			int cutSize = arry.length;
			int indexChecked = arry.length;
			char cutStartElement = sd.charAt(0);
			for (int i = 0; i < arry.length / 2; i++) {
				char currentElm = arry[i];
				char cutElm = arry[--cutSize];
				System.out.println("------------i :" + i);
				System.out.println("cutSize :" + cutSize);
				System.out.println("current :" + currentElm);
				System.out.println("cutElm :" + cutElm);

				if (currentElm != cutElm) {
					indexChecked = cutSize;
					arry = findCutSring(sd, indexChecked, cutStartElement).toCharArray();
					cutSize = arry.length;
					System.out.println("not equal cutSize :" + cutSize);
					i = -1;
					continue;
				}
				if (arry.length / 2 == i + 1) {
					System.out.println("============");
					list.add(arry);
					indexChecked = arry.length;
					System.out.println("indexChecked :" + indexChecked);
					arry = sd.substring(indexChecked).toCharArray();
					// if(arry.length==0){

					// }
					cutSize = arry.length;
					i = -1;
					break;
				}
			}
			System.out.println("*******");
			for (char[] c : list) {
				System.out.println("cuts :" + Arrays.toString(c));
			}
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String findCutSring(String sd, int indexChecked, char cutStartElement) {
		System.out.println("indexChecked :" + indexChecked);
		String val = sd.substring(0, indexChecked);
		val = val.substring(0, val.lastIndexOf(cutStartElement) + 1);
		System.out.println("val :" + val);
		return val;
	}

}
