/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.javaapplicationtest;

import java.util.Objects;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class Test {

    public static void main(String[] args) {
//          outerloop:
//        for (;;) {
//          
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    if (i * j > 6) {
//                        System.out.println("Breaking");
//                        break outerloop;
//                    }
//                    System.out.println(i + " " + j);
//                }
//            }
//            System.out.println("Done");
//        }
        
        int df=40;
        System.out.println(""+(df >> 1));
    }

   int a,b,g,v;
   String fg,hj;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.a;
        hash = 71 * hash + Objects.hashCode(this.fg);
        hash = 71 * hash + Objects.hashCode(this.hj);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Test other = (Test) obj;
        if (this.a != other.a) {
            return false;
        }
        if (!Objects.equals(this.fg, other.fg)) {
            return false;
        }
        if (!Objects.equals(this.hj, other.hj)) {
            return false;
        }
        return true;
    }


   
   
    
}
