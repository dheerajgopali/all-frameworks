package com.dheeraj.learning.java.patternmatching;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Execute {
    public static void main(String[] args) {
        //Scenario 1
        /**
         * Read a file and get the specified pattern matching data from the file.
         */
        /*ArrayList<String> list = readFile("java\\pattern-matching\\src\\main\\resources\\Log.txt", "startStop");
        System.out.println(list);*/

        ArrayList<String> list2 = readFileUsingApache("java\\pattern-matching\\src\\main\\resources\\Log.txt", "startStop");
        System.out.println(list2);

    }

    public static ArrayList<String> readFile(String filePath, String pattern) {
        FileInputStream fis = null;
        Scanner sc = null;
        try {
            File file = new File(filePath);
            System.out.println(file.getAbsolutePath());
            fis = new FileInputStream(file);
            sc = new Scanner(fis, "UTF-8");

            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {

            try{
                if(fis != null)
                    fis.close();
                if(sc != null)
                    sc.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList<String> readFileUsingApache(String filePath, String pattern) {
        LineIterator li = null;

        //*Pattern matching
        //1st way
        Pattern p = Pattern.compile(pattern);//".s");//. represents single character


        /*//2nd way
        boolean b2=Pattern.compile(".s").matcher("as").matches();

        //3rd way
        boolean b3 = Pattern.matches(".s", "as");

        System.out.println(b+" "+b2+" "+b3);*/

        try{
            li = FileUtils.lineIterator(new File(filePath), "UTF-8");
            while(li.hasNext()){
                String line = li.nextLine();
                Matcher m = p.matcher(line);
                boolean b = m.matches();
                System.out.println(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(li);
        }
        return null;
    }
}
