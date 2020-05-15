package com.dheeraj.learning.datastructures.map;

import org.junit.Test;

public class TestCustomHashMapOwnSeparateChaining {
    CustomHashMapOwnSeparateChaining<String, String> map = new CustomHashMapOwnSeparateChaining<>();

    @Test
    public void testMap() {
        //TODO Fix assertions
        double[] array = new double[10];
        for(int i=0;i<10;i++) {
            double random = Math.random();
            array[i] = random;
            map.put("TestKey"+random,"TestValue"+random);
        }

        for(int i=0;i<10;i++) {
            double random = array[i];
            System.out.println("Key : TestKey"+random+", value : "+map.get("TestKey"+random));
        }
        map.put("TestKey"+array[0],"TestValueChanged");
        System.out.println("Key : TestKey"+array[0]+", value : "+map.get("TestKey"+array[0]));
        map.remove("TestKey"+array[5]);
        System.out.println("After add and removal");
        for(int i=0;i<10;i++) {
            double random = array[i];
            System.out.println("Key : TestKey"+random+", value : "+map.get("TestKey"+random));
        }
    }
}
