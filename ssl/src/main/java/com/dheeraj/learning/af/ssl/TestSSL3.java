package com.dheeraj.learning.af.ssl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class TestSSL3 {
    public static void main(String[] args) {
        RequestConfig.Builder requestConfig = RequestConfig.custom();
        requestConfig.setConnectionRequestTimeout(30 * 1000);
        requestConfig.setConnectTimeout(9 * 1000);
        requestConfig.setSocketTimeout(9 * 1000);

        CloseableHttpClient client = HttpClients.custom()
                .setSSLSocketFactory(buildSocketFactory())
                .setDefaultRequestConfig(requestConfig.build())
                .setMaxConnTotal(-1)
                .setMaxConnPerRoute(-1)
                .build();


        for (int i = 0; i < 10 ; i++) {
            new Thread(new CustomThread2(client)).start();
        }
    }

    private static LayeredConnectionSocketFactory buildSocketFactory() {

        SSLContextBuilder sslContextBuilder = SSLContextBuilder.create();
        try {
            sslContextBuilder.loadTrustMaterial(new TrustAllStrategy());
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            System.out.println(e);
        }

        SSLContext sslContext = null;
        try {
            sslContext = sslContextBuilder.build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            System.out.println(e);
        }

        return new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
    }


}
class CustomThread2 implements Runnable {

    CloseableHttpClient client;

    public CustomThread2(CloseableHttpClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        CloseableHttpResponse httpResponse = null;
        try {
                URIBuilder builder = new URIBuilder("https://sde-86-hyd.eng.rpega.com/prweb/");

                HttpUriRequest request = new HttpGet(builder.build());

                httpResponse = client.execute(request);
                //Thread.sleep(10000);
                System.out.println(httpResponse);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if(httpResponse!=null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
