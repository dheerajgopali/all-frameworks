package com.dheeraj.learning.recursive;

import org.junit.Test;

/**
 * Created by gopad on 24-03-2017.
 */
public class Executor {
    @Test
    public void testFactorial(){
        System.out.println(Factorial.getFactorialOf(10));
    }

    @Test
    public void testPalindrome(){
        System.out.println(Palindrome.isPalindrome("acbba"));
    }
}
