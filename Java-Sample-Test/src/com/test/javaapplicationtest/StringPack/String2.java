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
public class String2 {

    public static void main(String[] args) {
        String in = "geksforgeks";
        printDuplicate_String(in);
    }

    static void printDuplicate_String(String in) {

        String strlength = "";
        int greatestCount = 0;
        for (int i = 0; i < in.length(); i++) {
            for (int j = i + 1; j <= in.length(); j++) {
                String sub = in.substring(i, j);
                int count = (in.length() - in.replace(sub, "").length()) / (sub.length());
                if (count > 1 && strlength.length() < sub.length()) {
                    strlength = sub;
                    greatestCount = count;
                }
            }
        }
        System.out.println("Vlaue :" + strlength + " with count :" + greatestCount);
    }

    static int countMatches(String val, String pat) {
        int count = 0;
        
        return count;
    }
}
