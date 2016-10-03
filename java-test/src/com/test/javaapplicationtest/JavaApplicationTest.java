/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest;

import java.util.List;

/**
 *
 * @author Karthikeyan.Subraman
 * @param <D>
 */
public class JavaApplicationTest<D extends String> {

    private <T extends D> D get() {
        T s = null;
//        s.
        return s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplicationTest t = new JavaApplicationTest();

//        char[] cf = {'a', 'b', 'c','d'};
//        for (int i = 0; i < cf.length; i++) {
//            char c = cf[i];
//            for (int j = 0; j < cf.length; j++) {
//                char cd = cf[j];
//                getCombination(cf, i, j);
//                
//            }
//        }
        
        System.out.println("89$,".replaceAll("[^\\d.]", ""));

//        System.out.println(String.valueOf(cf));
    }

    private static void getCombination(char[] ae, int i, int j) {
        String sd="";
        System.out.println("i :"+i+" j:"+j);
        for (int k = i; k <=j ; k++) {
            sd+=sd.concat(String.valueOf(ae[k]));
        }
        System.out.println(sd);
    }
}
