/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.javaapplicationtest;


/**
 *
 * @author Srithar.Raju
 */
public class NoToString {

    static String singleDigit[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String doubleSingleDigit[] = {"Ten", "Eleven", "Twoele", "Thertine", "Fourtine", "Fiftine", "Sixteen", "Seventeen", "Eightteen", "Nineteen"};
    static String doubleDigit[] = {"", "", "Tweny", "Therty", "fourty", "Fifty", "sixty", "seventy", "eightty", "Ninety"};
    static String moreDigit[] = {"Thousand", "Lakh", "crore", "Billion"};

    public static void main(String[] args) {
        printNo(1231890);
    }

    private static void printNo(int i) {

        int chekLen = i;
        int no = i;
        int len = 0;
        while (chekLen > 0) {
            len++;
            chekLen /= 10;
        }
//        System.out.println("len-->>"+len);
        switch (len) {
            case 0:
                break;
            case 1:
                System.out.print(" " + singleDigit[no]);
                break;
            case 2:
                if ((no / 10) == 1) {
                    System.out.print(" " + doubleSingleDigit[no % 10]);
                } else {
                    System.out.print(" " + doubleDigit[no / 10]);
                    printNo(no % 10);
                }
                break;
            case 3:
                printNo(no / 100);
                System.out.print(" Huntred");
                printNo(no % 100);
                break;
            default:
                if (len % 2 == 0) {
                    printNo((int) (no / Math.pow(10, len - 1)));
                    System.out.print(" " + moreDigit[((len - 1) / 2) - 1]);
                    printNo((int) (no % Math.pow(10, len - 1)));
                } else {
                    printNo((int) (no / Math.pow(10, len - 2)));
                    System.out.print(" " + moreDigit[((len - 2) / 2) - 1]);
                    printNo((int) (no % Math.pow(10, len - 2)));
                }
        }

    }
}
