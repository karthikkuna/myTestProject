/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.javaapplicationtest.StringPack;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class StringReverse {

    public static void main(String[] args) {
        String io = "house no : 123@ cbe";
        char[] ch = io.toCharArray();
        char[] finalCh = io.toCharArray();
        for (int i = 0, j = ch.length - 1; i < ch.length; i++, j--) {
//            if (Character.isLetter(finalCh[j]) && Character.isLetter(ch[i]) || (Character.isDigit(finalCh[j]) && Character.isDigit(ch[i]))) {
            if (isSpl(finalCh[j],ch[i]) ) {
                finalCh[j] = ch[i];
            }
        }
        System.out.println(String.valueOf(finalCh));
    }
    static boolean isSpl(char a,char b){
        return Character.isLetterOrDigit(b) && Character.isLetterOrDigit(a);
    }
}
