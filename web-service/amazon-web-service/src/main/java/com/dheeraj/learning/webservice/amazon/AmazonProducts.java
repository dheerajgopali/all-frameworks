package com.dheeraj.learning.webservice.amazon;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Copied for old PC. Doesnt seem to work full fledged. Need to work on the output.
 */
public class AmazonProducts {
    private static final String AWS_SECRET_KEY =
        "jpJSSFIyEBBLng0lZvTmRi1qMwDqG9zn5bqMCwX1";
    private static final String ENDPOINT = "webservices.amazon.com";
    private static final String AWS_ACCESS_KEY_ID = "AKIAJON2B2U6UJFXRYKA";
    private static final String ASSOCIATE_TAG = "developmentte-21";

    public static void main(String[] args) {

        SignedRequestsHelper helper;
        try {
            helper =
                    SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID,
                                                     AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", AWS_ACCESS_KEY_ID);
        params.put("AssociateTag", ASSOCIATE_TAG);
        params.put("SearchIndex", "Electronics");
        params.put("Keywords", "Mobile");

        requestUrl = helper.sign(params);

        try {
            sendGet(requestUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sendGet(String url) throws Exception {
        String USER_AGENT = "Mozilla/5.0";

        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ENDPOINT, 80));
        HttpURLConnection con = (HttpURLConnection)obj.openConnection(proxy);
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

    
        BufferedReader in =
            new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        System.out.println(response);
    }
}
