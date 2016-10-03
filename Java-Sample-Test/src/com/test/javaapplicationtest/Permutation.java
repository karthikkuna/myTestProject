/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.javaapplicationtest;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class Permutation {

    static void combinationUtil(int arr[], int n, int r, int index,
            int data[], int i) {
        // Current combination is ready to be printed, print it

        if (index == r) {
            System.out.println("data--" + Arrays.toString(data));
//            for (int j = 0; j < r; j++) {
//                System.out.print(data[j] + " ");
//            }
            System.out.println("");
//            new LinkedList().add(index, index)i)
//            new Node(
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n) {
            return;
        }
        System.out.println("index :" + index);
        System.out.println("i :" + i);
        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int r = 3;
        int n = arr.length;
//        Arrays.asList(args)
        printCombination(arr, n, r);
//        for (int i = 1; i <= arr.length; i++) {
//              printCombination(arr, n, i); 
//        }
//        printCombinationFor(arr, n, r);

    }

    static void printCombinationFor(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    static void combinationUtil(int arr[], int data[], int start,
            int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
//            for (int j=0; j<r; j++)
//                System.out.print(data[j]+" ");
//            System.out.println("");
            System.out.println("data--" + Arrays.toString(data));
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

}
