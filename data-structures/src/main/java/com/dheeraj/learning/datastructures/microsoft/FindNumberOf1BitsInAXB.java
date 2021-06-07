package com.dheeraj.learning.datastructures.microsoft;

import org.junit.Assert;

/**
 * Questions asked in Microsoft
 * 	1. Given two numbers A, B, find the numbers of 1 bits in A*B in its binary form.
 * 		a. Eg. A=3, B=7, A*B=21, Binary form = 10101. So number of 1's is 3.
 * 	2. Implement cd command in code.
 * 		a. Given method generatePath(String currentDirectory, String command)
 * 		b. Output has to be the appropriate string. Not related to system directory. Only manipulations on currentDirectory string.
 * 		c. Examples
 * 			i. Eg generatePath("/dev/task", "cd java") --> "/dev/task/java"
 * 			ii. Eg generatePath("/dev/task", "cd /") --> "/"
 * 			iii. Eg generatePath("/dev/task", "cd ..") --> "/dev"
 * 			iv. Eg generatePath("/dev/task", "cd ../..") --> "/"
 *           v. Eg generatePath("/dev/task", "cd ../java") --> "/dev/java"
 */
public class FindNumberOf1BitsInAXB {
    public static void main(String[] argS) {
        FindNumberOf1BitsInAXB obj = new FindNumberOf1BitsInAXB();
        System.out.println(obj.getBits(10,20));

        //The below code is testing thoroughly
        for(int i=11,j=15;i<1000000000&&i>0&&j>0;i=i*11,j=j*4) {
            int res = obj.getBits(i,j);
            String str = Long.toBinaryString((long)i*j);
            int resStr = obj.get1s(str);
            Assert.assertEquals("My code res: "+res+", Actual res: "+resStr+"i:"+i+", j:"+j, res, resStr);
        }
    }

    public int getBits(int A, int B) {
        long res = (long)A*B;
        int count=0;
        while(res!=0) {
            if(res%2==1)
                count++;
            res = res/2;
        }
        return count;
    }

    private int get1s(String str) {
        int count=0;
        for(char ch : str.toCharArray()) {
            if(ch=='1')
                count++;
        }

        return count;
    }

}
