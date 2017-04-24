package com.dheeraj.learning.junit;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by gopad on 24-03-2017.
 */
public class CalculationServiceTest {

    @Test
    public void testAddition(){
        CalculationService cs = new CalculationService();
        int result = cs.addition(10,15);
        assertEquals(result, 25);
    }
}
