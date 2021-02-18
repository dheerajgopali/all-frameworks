package com.dheeraj.learning.af.ssl.singlecm.ssl;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


/**
 * @author Pathbreakers
 * @version $ 12/23/20
 */
public class HttpClient {
    public static final int DEFAULT_CONNECTION = 20;
    private int currentGatewayMaxConnectionDSSValue = DEFAULT_CONNECTION;
    private PoolingHttpClientConnectionManager connectionManager;
    private final RequestConfig requestConfig;

    public HttpClient() {
        requestConfig = buildRequestConfig();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        HttpClient client = new HttpClient();
        client.execute();
    }

    public void execute() throws NoSuchAlgorithmException  {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(currentGatewayMaxConnectionDSSValue);
        connectionManager.setDefaultMaxPerRoute(currentGatewayMaxConnectionDSSValue);
        connectionManager.setSocketConfig(HttpHost.create("test"), SocketConfig.DEFAULT);
        connectionManager.setConnectionConfig(HttpHost.create("test"), ConnectionConfig.DEFAULT);

        CloseableHttpClient httpClient1 = buildHttpClient();
        CloseableHttpClient httpClient2 = buildHttpClient();
        String host1 = "https://sde-86-cam.eng.rpega.com/prweb/";
        String host2 = "https://sde-86-hyd.eng.rpega.com/prweb/";

        for (int i = 0; i < 10 ; i++) {
            new Thread(new CustomThread(httpClient1, connectionManager, host1, 500)).start();
        }
        httpClient1.getConnectionManager().getSchemeRegistry();
    }

    protected CloseableHttpClient buildHttpClient() throws NoSuchAlgorithmException {
        return  HttpClients.custom()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContext.getDefault().getSocketFactory(), new DefaultHostnameVerifier()))
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setConnectionManagerShared(true)
                .setConnectionTimeToLive(2,TimeUnit.SECONDS)
                .build();
    }

    private RequestConfig buildRequestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(10 * 1000)
                .setConnectTimeout(10 * 1000)
                .setSocketTimeout(10 * 1000)
                .build();
    }

    void extracode() {
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10 ; i++) {
            new Thread(new CustomThread(httpClient1, connectionManager, host1, 500)).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3 ; i++) {
            new Thread(new CustomThread(httpClient2, connectionManager, host2, 1000)).start();
        }
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                logConnectionManagerStats();
            }
            connectionManager.closeIdleConnections(1, TimeUnit.SECONDS);
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                logConnectionManagerStats();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

    }
}


