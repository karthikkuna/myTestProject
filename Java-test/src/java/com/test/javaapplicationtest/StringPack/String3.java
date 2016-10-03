/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest.StringPack;

import java.util.Arrays;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class String3 {

    public static void main(String[] args) {
        int a[] = {6, 4, 56, 3};
        int max = 0;
        int max_2 = a[0];
        int[] pos = new int[2];
        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
            max = cur > max ? cur : cur < max ? max : cur;
            max_2 = (cur > max_2) && (cur < max) ? cur : (cur < max_2) ? max_2 : cur;
//            max_2 = cur < max ? cur > max_2?cur:max_2 < max?
            if (cur == max) {
                pos[0] = i;
            }
            if (cur == max_2) {
                pos[1] = i;
            }
        }
        System.out.println("pos---" + Arrays.toString(pos));
        System.out.println("max---" + max);
        System.out.println("min---" + max_2);
    }

}
