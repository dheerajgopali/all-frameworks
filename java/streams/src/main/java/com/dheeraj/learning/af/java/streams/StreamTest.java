package com.dheeraj.learning.af.java.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        StreamTest obj = new StreamTest();
        //obj.test1();
        //obj.test2();
        //obj.test3();
        //obj.test4();
        obj.test5();
    }

    /**
     * Average of squares of an int array
     */
    private void test5() {
        Arrays.stream(new int[]{1,2,3,4,5,6}) // or Stream.of(names)
                .map(x->x*x)
                .forEach(System.out::println);
    }

    /**
     * Stream for array, sort, filter and print
     */
    private void test4() {
        int[] arr = {10,20,3,5,8,25};
        Arrays.stream(arr) // or Stream.of(names)
                .filter(x->x%2==0)
                .sorted()
                .forEach(System.out::println);

    }

    /**
     * Stream.of, sorted and findFirst
     */
    private void test3() {
        Stream.of("abc","def","aac")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    private void test2() {
        System.out.println(IntStream
        .range(1,5)
        .sum());
    }

    private void test1() {
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(s->System.out.print(" "+s));
    }

}
