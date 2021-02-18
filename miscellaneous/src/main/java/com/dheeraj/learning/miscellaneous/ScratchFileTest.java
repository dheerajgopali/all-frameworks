package com.dheeraj.learning.miscellaneous;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class ScratchFileTest {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("ftp://los:909/prweb");
        System.out.println(uri.getAuthority());
        System.out.println(uri);
        /*String baseURLAftertrimming = "http://lu-85-hyd.eng.pega.com/prweb/PRServlet/sso";
        String[] urlComponents = baseURLAftertrimming.split("/");
        String authAlias = urlComponents[urlComponents.length-1];
        String baseURLWithoutAuthAlias = authAlias != null ?
                baseURLAftertrimming.substring(0, baseURLAftertrimming.indexOf(authAlias)) : baseURLAftertrimming;

        System.out.println("Without alias :" + baseURLWithoutAuthAlias);
        System.out.println("With Alias : " + baseURLAftertrimming);*/
        /*String[] urlComponents = url.split("/prweb");
        System.out.println(Arrays.toString(urlComponents));
        String servlet = urlComponents[1];
        System.out.println(servlet);
        String[] servletComponents = servlet.split("/");
        System.out.println(Arrays.toString(servletComponents));*/
    }
}
