package com.dheeraj.learning.java.patternmatching;

import java.util.regex.Pattern;

/**
 * . - Match any single character
 * .* - Match any character 0 or more times
 * .+ - Match any character 1 or more times
 * .? - Match any character exactly one time.
 * [abc] - Match single character with a or b or c
 * [^abc] - Not Match single character with a or b or c
 * [abc]* - Match given characters 0 or more times.
 * [a-z] - Match single character in the given range
 * [a-xA-Z] - Match single character in the given ranges.
 * [abc]{5} - Match 5 consecutive characters with a or b or c.
 * \\d - Matches a digit.
 * \\D - Matches a character.
 */
public class Simple {
    public static void main(String[] args) {
        System.out.println(Pattern.matches(".?hee.*","dheeraj"));
        System.out.println(Pattern.matches("\\d*","123"));
        System.out.println(Pattern.matches("\\D*","dheeraj"));
        System.out.println(Pattern.matches("[^abc]{7}","dheeraj"));
        System.out.println(Pattern.matches("[a-z]{7}","dheeraj"));
        System.out.println(Pattern.matches("\\d","1"));
        System.out.println(Pattern.matches("\\D","123"));

    }
}
