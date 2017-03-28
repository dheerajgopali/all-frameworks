package com.dheeraj.learning.datastructures.array;

import com.dg.af.utilities.ArrayUtil;
import com.dg.af.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/20/2015.
 */
public class RotateArray90D {
    public static void main(String[] args) {
        RotateArray90D obj = new RotateArray90D();
        ArrayList<ArrayList<Integer>> matrix = ArrayUtil.buildArrayList("1,2,3,4,5,6,7,8",4,2);
        ArrayUtil.displayArray(matrix);
        obj.rotate(matrix);
        System.out.println();
        ArrayUtil.displayArray(matrix);
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int half = n / 2;

        for (int layer = 0; layer < half; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int j = last - offset;
                int top = a.get(first).get(i); // save top

                // left -> top
                a.get(first).set(i, a.get(j).get(first));

                // bottom -> left
                a.get(j).set(first, a.get(last).get(j));

                // right -> bottom
                a.get(last).set(j, a.get(i).get(last));

                // top -> right
                a.get(i).set(last, top); // right <- saved top
            }
        }
    }
}