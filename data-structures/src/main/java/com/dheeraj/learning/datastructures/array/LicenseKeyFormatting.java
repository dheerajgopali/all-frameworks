package com.dheeraj.learning.datastructures.array;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting lf = new LicenseKeyFormatting();
        System.out.println("Output: "+lf.licenseKeyFormatting("-- -a", 3));
    }

    public String licenseKeyFormatting(String s, int k) {
            StringBuilder sb = new StringBuilder();
            int curKeySize = 0;
            for(int i=s.length()-1;i>=0;i--) {
                char ch = s.charAt(i);
                if(ch!='-') {
                    sb.append(Character.toUpperCase(ch));
                    curKeySize++;
                    if(curKeySize == k) {
                        sb.append("-");
                        curKeySize=0;
                    }
                }
            }
            if(!sb.toString().equals("") && sb.charAt(sb.length()-1) == '-') {
                sb.deleteCharAt(sb.length()-1);
            }
            return sb.reverse().toString();
    }
}
