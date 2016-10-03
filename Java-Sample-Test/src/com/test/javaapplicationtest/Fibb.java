/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.javaapplicationtest;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class Fibb {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
//        return fib(n - 1) + fib(n - 2);
            System.out.println("n--" + n);
            int val = fib(n - 1) + fib(n - 2);
            System.out.println("val--" + val);
            return val;
        }
    }

    private static int fact(int n) {
        if (n <= 1) {
            return n;
        } else {

            return n * fact(n - 1);
        }
    }

    private static int fibSeries(int n) {
        if (n <= 1) {
            return n;
        } else {
//              System.out.println(name+": name n :" + n);
            int val = fibSeries(n - 1) + fibSeries(n - 2);
//            System.out.println(name+": name  val---" + val);
            return val;
        }
    }

    private static boolean isOdd(int n) {
        if (n <= 0) {
            return false;
        } else {
//              System.out.println(name+": name n :" + n);

//            System.out.println(name+": name  val---" + val);
            return (byte)( n + 1) % 2 == 0;
        }
    }

    private static boolean isEven(int n) {
        if (n <= 0) {
            return false;
        } else {
//              System.out.println(name+": name n :" + n);

//            System.out.println(name+": name  val---" + val);
            return (byte) n % 2 == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(isOdd(1));
        System.out.println(isEven(12));
//        System.out.println(fact(5));
//        System.out.println(fib(6));
//        for (int i = 0; i < 10; i++) {

//        System.out.println(fibSeries(7));
//        }
    }

}
