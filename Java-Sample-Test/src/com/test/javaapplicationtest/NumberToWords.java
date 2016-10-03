package com.test.javaapplicationtest;

import java.util.Scanner;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class NumberToWords {

    static String[] ones = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
        " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen", " twenty"};
    static String[] tens = {"", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};

    static String[] hundereds = {"", " hundered", " thousand", " lakh", " crore", "million", "trillion"};
    static String[] thousand = {"thousand"};
    static String[] lakh = {"lakh"};
    static String and = " and";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int length = String.valueOf(number).length();
            if (number == 0) {
                System.out.println("Zero");
                return;
            }
            printWords(number, length, length);
            System.out.println("");
        }
    }

    static int findN0(int length) {
        length = length == 2 ? length - 2 : --length;
        int val = Integer.valueOf("1" + new String(new char[length]).replace("\0", "0"));
        return val;
    }

    static void printWords(int number, int lastLength, int length) {

        if (length > 3) {
            if ((length + 1) % 2 == 0) {
                length--;
            }
        }
        int dividor = findN0(length);
        int dividorLength = String.valueOf(dividor).length();
        if ((dividorLength + 1) % 2 == 0) {
            --dividorLength;
        }
        dividorLength = dividorLength / 2;

        int first = number / dividor;
        int lastNo = number % dividor;
        if (first > 20) {
            after_20(first, hundereds[dividorLength]);
        } else if (number < 20) {
            System.out.print(ones[first]);
        } else {
            boolean isAnd = lastLength > 3 && length == 3 && lastNo > 0;
            System.out.print(ones[first] + " " + hundereds[dividorLength] + (isAnd ? and : ""));
        }
        if (lastNo > 0) {
            printWords(lastNo, lastLength, String.valueOf(lastNo).length());
        }
    }

    static void after_20(int number, String place_10) {

        int index = number / 10;
        int lastNo = number % 10;
        System.out.print(tens[index] + " " + ones[lastNo] + place_10);
    }
}
