package com.dheeraj.learning.designpatterns.headfirst.decorator.customio;

import java.io.*;

public class TestMyInputStream {
    public static void main(String[] args) throws IOException {
        LowerCaseInputStream in =
                new LowerCaseInputStream(new FileInputStream("design-patterns/src/main/resources/test.txt"));
        int c;
        while((c=in.read())!= -1) {
            System.out.print((char)c);
        }
        in.close();
    }
}
