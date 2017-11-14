package com.dheeraj.learning.prpcjava;

/**
 * Created by gopad on 10-10-2017.
 */
public class StringUtil {
    public static void main(String[] args) {
        String str = "coreAssembly-7.3.1-3919";
        String prpcVersion = str.substring(str.indexOf('-')+1,str.lastIndexOf('-'));
        System.out.println(prpcVersion);

    }


}
