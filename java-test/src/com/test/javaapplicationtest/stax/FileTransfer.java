/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtest.stax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karthikeyan.Subraman
 */
public class FileTransfer {

    public static void main(String[] args) {
//         fis = null;
        long start = System.currentTimeMillis();
        String fileName = "D:\\Karthik\\Excel from sql\\ETL\\sales.csv_20160624_123717.csv";
        try (FileInputStream fis = new FileInputStream(new File(fileName));
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Example.txt")))) {

            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                bw.write(line + "\n");
                count++;
                if (count == 200000) {
                    break;
                }

            }
            System.out.println(System.currentTimeMillis() - start);
        } catch (Exception ex) {
            Logger.getLogger(FileTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

}
