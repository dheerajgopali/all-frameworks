package com.dheeraj.learning.datastructures.bits;

/**
 * Created by dgopali on 9/14/2015.
 */
public class BitwiseOps {
    public static void main(String args[]) {
       performShiftOperation();
    }

    public static void performShiftOperation() {
        System.out.println(0 & 1<<3);

    }

    public static void displayComplementNumber() {
        byte one = 1;               // 0000 0001
        byte complementOne = ~1;    // 1111 1110 (Just reverse the
        byte negativeOne = -1;

        //Just divide integer by two
        System.out.println("Value : "+Byte.toString(one)+", Binary format : "+String.format("%8s", Integer.toBinaryString(one)).replace(' ','0'));
        //Change 0 to 1 and 1 to zero. Just inversion. If you wanna know magnitude of the obtained number, you have to do 2's complement to obtain actual value
        //Here  1   =   0000 0000 0000 0000 0000 0000 0000 0001
        //      ~1  =   1111 1111 1111 1111 1111 1111 1111 1110
        //  2's comp of ~1 =    Step 1. Invert bits. it becomes 0000 0000 0000 0000 0000 0000 0000 0001.
        //                      Step 2. Add one i.e. 0000 0000 0000 0000 0000 0000 0000 0010 (decimal is 2)
        //                      Step 3. Since MSB in ~1 is 1 the result is negative.  (-ve)
        //                      So 2's complement of ~1 is -2. So ~1 = -2
        System.out.println("Value : "+Byte.toString(complementOne)+", Binary format : "+String.format("%8s", Integer.toBinaryString(complementOne)).replace(' ', '0'));

        //As shown above just get the 2's complement of -1 to get the binary format.
        // 2's comp of -1 = Step 1. binary format of 1 is   0000 0000 0000 0000 0000 0000 0000 0001 (binary format for 1)
        //                  Step 2. invert bits             1111 1111 1111 1111 1111 1111 1111 1110 (1 after inversion, also called NOT one)
        //                  Step 3. add one                 1111 1111 1111 1111 1111 1111 1111 1111 (this is binary format for -1)
        System.out.println("Value : "+Byte.toString(negativeOne)+", Binary format : "+String.format("%8s", Integer.toBinaryString(negativeOne)).replace(' ', '0'));
    }
}
