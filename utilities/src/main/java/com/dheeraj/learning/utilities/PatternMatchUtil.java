package com.dheeraj.learning.utilities;

public class PatternMatchUtil {
    public static void main(String[] args) {
        String regExpr = "[._\\-A-Za-z0-9]*";
        String regExprTwo = "[^A-Za-z0-9\\-]";
        //System.out.println("Result : "+match("ABC-SASF#@#@",regExpr));
        String SQUIDDevelopment = "SQUIDDevelop*(*ment&*(*";
        String test = SQUIDDevelopment.replaceAll(regExprTwo , "");
        System.out.println(test);
    }

    public static boolean match(String testString, String regularExpression) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regularExpression);
        java.util.regex.Matcher m = p.matcher(testString);

        return m.matches();
    }
}
