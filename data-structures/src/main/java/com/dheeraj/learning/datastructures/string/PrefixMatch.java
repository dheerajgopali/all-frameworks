package com.dheeraj.learning.datastructures.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gopad on 24-05-2017.
 */
/*public class PrefixMatch {

    public void main(String[] args) {

        final String[] prefixMatches = prefixMatch(new String[] { "Abc", "Abcd", "Qwerty", "Pre1", "Pre2", "Pre3", "Xyz", "Zzz" }, "pre");

        for (int i = 0; i < prefixMatches.length; i++)
            System.out.println(prefixMatches[i]);
    }

    public static String[] prefixMatch(final String[] array, final String prefix) {

        final Comparator<String> COMPARATOR = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.substring(0, prefix.length()).compareToIgnoreCase(o2);
            }
        };

        final int randomIndex = Arrays.binarySearch(array, prefix, COMPARATOR);

        int rangeStarts = randomIndex, rangeEnds = randomIndex;

        while (rangeStarts > -1 && array[rangeStarts].toLowerCase().startsWith(prefix.toLowerCase()))
            rangeStarts--;

        while (rangeEnds < array.length && array[rangeEnds].toLowerCase().startsWith(prefix.toLowerCase()))
            rangeEnds++;

        return Arrays.copyOfRange(array, rangeStarts + 1, rangeEnds);
    }
}*/

class PrefixMatch{
    public static void main(String[] args) {
        String[] str = new String[]{"APPLE","BALANCE","BANANA","BELL","GLOBAL"};
        String prefix = "APPLE";
        String[] arr = prefixSearch(str, prefix);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static String[] prefixSearch(String[] str, String prefix){
        int index = binarySearch(str,prefix);

        int temp = index;
        while (temp > -1 && COMPARATOR.compare(str[temp],prefix)==0)
            temp--;
        int startIndex = temp;

        temp =index;
        while (temp < str.length && COMPARATOR.compare(str[temp],prefix)==0)
            temp++;
        int endIndex = temp;

        return Arrays.copyOfRange(str,startIndex+1,endIndex);
    }

    public static int binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int temp = COMPARATOR.compare(a[mid],x);
            if (temp < 0) {
                low = mid + 1;
            } else if (temp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static final Comparator<String> COMPARATOR = new Comparator<String>() {
        public int compare(String o1, String o2) {
            return o1.substring(0, o2.length()).compareToIgnoreCase(o2);
        }
    };
}