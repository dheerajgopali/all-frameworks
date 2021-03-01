package com.dheeraj.learning.datastructures.patterns.slidingwindow;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class FindSubStringWithAtmostKCharacters {
    public static void main(String[] args) {
        FindSubStringWithAtmostKCharacters obj = new FindSubStringWithAtmostKCharacters();
        System.out.println(obj.lengthOfLongestSubstringKDistinctFromLeetCodeOptimized("abcbdbdbbdcdabd", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int sl = s.length();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int wL = 0;
        int wR = 0; //TODO -1 or 0??
        int max = 0;

        for (wR = 0; wR < sl; wR++) {
            charCountMap.compute(s.charAt(wR), (key, v) -> (v == null) ? 1 : v + 1);

            if (charCountMap.size() <= k) {
                max = Math.max(max, wR - wL + 1);
            }

            while (charCountMap.size() > k) {
                charCountMap.compute(s.charAt(wL++), (key, value) -> value - 1);
                charCountMap.values().removeIf(f -> f == 0);
            }
        }

        return max;
    }

    public int lengthOfLongestSubstringKDistinctFromLeetCode(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++);

            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringKDistinctFromLeetCodeOptimized(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new LinkedHashMap<>();

        int maxLength = 1;

        while (right < n) {
            Character character = s.charAt(right);
            if (rightmostPosition.containsKey(character)) {
                rightmostPosition.remove(character);
            }
            rightmostPosition.put(character, right++);

            if (rightmostPosition.size() > k) {
                Map.Entry<Character, Integer> leftmost = rightmostPosition.entrySet().iterator().next();
                rightmostPosition.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
