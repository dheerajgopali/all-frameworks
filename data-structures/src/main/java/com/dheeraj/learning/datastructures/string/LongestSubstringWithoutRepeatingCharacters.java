package com.dheeraj.learning.datastructures.string;

import com.dheeraj.learning.datastructures.timer.TimeDecoratorAbstract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters implements TimeDecoratorAbstract {
    public static void main(String[] args) {
        String str = "abcabcghjkbagbdef";
        System.out.println(findLongestSubstringWithoutRepeatingCharactersBruteForce(str));
        System.out.println(findWithMap(str));
        System.out.println(findWithIntArray(str));

        /*TimeDecoratorAbstract timeDecoratorAbstract = new TimeDecorator(new LongestSubstringWithoutRepeatingCharacters());
        System.out.println(timeDecoratorAbstract.execute());*/
    }

    @Override
    public String execute() {
        String str = "abcdd";
        return findLongestSubstringWithoutRepeatingCharacters(str);
    }

    /**
     * Find by bruteforce
     *
     * @param str
     * @return
     */
    public static String findLongestSubstringWithoutRepeatingCharactersBruteForce(String str) {
        int n = str.length();
        String res = "";
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                if (set.contains(ch)) {
                    break;
                }
                set.add(ch);
                if (maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    res = str.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    /**
     * Little optimized
     *
     * @param str
     * @return
     */
    public String findLongestSubstringWithoutRepeatingCharacters(String str) {
        Set<Character> set = new HashSet<>();
        int n = str.length();
        String res = "";
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                } else {
                    int k = i;
                    while (str.charAt(k) != str.charAt(j)) {
                        set.remove(str.charAt(k++));
                    }
                    i = k + 1;
                }
                if (maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    res = str.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    /**
     * More optimized
     *
     * @param str
     * @return
     */
    public static String findLongestSubstringWithoutRepeatingCharactersMoreOptimized(String str) {
        Set<Character> set = new HashSet<>();
        int n = str.length();
        String res = "";
        int maxLength = 0;
        for (int i = 0, j = 0; j < n; j++) {
            char ch = str.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                int k = i;
                while (str.charAt(k) != str.charAt(j)) {
                    set.remove(str.charAt(k++));
                }
                i = k + 1;
            }
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
                res = str.substring(i, j + 1);
            }
        }

        return res;
    }

    /**
     * More optimized
     *
     * The below condition is required as the map contains chars not in current window.
     * //Eg: abccb
     * When i=0, j=2, map => a-0, b-1, c-2
     * When i=0, j=3, max of i, map.get(c)+1 i.e 3.
     * When i=3, j=3, map => a-0, b-1, c-3 map also gets updated with c-3
     * When i=3, j=4, though map contains b, but it is not in the current window.
     *  So shouldn't consider it. So we check if b is in the current window.
     *  If not in current window, just keep the i value as it is. i.e 3.
     *  If we directly assign map.get(ch)+1 to i, i would become 1+1 i.e 2 which is incorrect.
     *
     * @param str
     * @return
     */
    public static String findWithMap(String str) {
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int n = str.length();
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0, j = 0; j < n; ) {
            char ch = str.charAt(j);
            if (charToIndexMap.containsKey(ch)) {
                i = Math.max(i, charToIndexMap.get(ch) + 1);

            }
            charToIndexMap.put(ch, j++);
            if (maxLength < j - i) {
                maxLength = j - i;
                startIndex = i;
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }

    /**
     * More optimized
     *
     * @param str
     * @return
     */
    public static String findWithIntArray(String str) {
        int[] chInd = new int[128];

        int n = str.length();
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0, j = 0; j < n; j++) {
            char ch = str.charAt(j);
            i = Math.max(i, chInd[ch] + 1);
            chInd[ch] = j;
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
                startIndex = i;
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }
}
