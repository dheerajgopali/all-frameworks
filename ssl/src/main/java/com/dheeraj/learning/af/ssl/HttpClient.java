package com.dheeraj.learning.af.ssl;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultClientConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


/**
 * @author Pathbreakers
 * @version $ 12/23/20
 */
public class HttpClient {
    private static final int MAX_CONNECTION = 50;
    private static final int MIN_CONNECTION = 10;
    public static final int DEFAULT_CONNECTION = 20;
    public static final String GATEWAY_MAX_CONNECTION_DASS_RULESET = "Pega-Engine";
    public static final String GATEWAY_MAX_CONNECTION_DASS_NAME = "gateway/maxconnecion";
    private int currentGatewayMaxConnectionDSSValue = DEFAULT_CONNECTION;

    private ConcurrentHashMap<String, CloseableHttpClient> httpClientMappingsCache = new ConcurrentHashMap<>();
    private PoolingHttpClientConnectionManager connectionManager;
    private final RequestConfig requestConfig;

    public HttpClient() {
        requestConfig = buildRequestConfig();
        recreateConnectionManager();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        HttpClient client = new HttpClient();
        client.execute();
    }

    public void execute() throws NoSuchAlgorithmException  {
        CloseableHttpClient httpClient1 = buildHttpClient();
        CloseableHttpClient httpClient2 = buildHttpClient();
        String host1 = "http://localhost:9080/prweb";
        //String host2 = "https://sde-86-hyd.eng.rpega.com/prweb/";

        for (int i = 0; i < 10 ; i++) {
            new Thread(new CustomThread(httpClient1, connectionManager, host1, 500)).start();
        }
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
        /*for (int i = 0; i < 3 ; i++) {
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
        }*/
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

    private void recreateConnectionManager() {
        if(connectionManager!=null) {
            //oLog.info("Shutting down gateway http client connection manager.");
            connectionManager.shutdown();
        }

        //oLog.info("Creating a new gateway http client connection manager.");
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(currentGatewayMaxConnectionDSSValue);
        connectionManager.setDefaultMaxPerRoute(currentGatewayMaxConnectionDSSValue);
    }

    public void logConnectionManagerStats() {
        System.out.println(createHttpInfo(connectionManager));
    }

    private static String createHttpInfo(PoolingHttpClientConnectionManager connectionManager) {
        StringBuilder sb = new StringBuilder();

        PoolStats totalStats = connectionManager.getTotalStats();
        sb.append(createPoolStatsInfo("Total Stats", totalStats));
        connectionManager.getRoutes().forEach(route -> sb.append(createPoolStatsInfo(route.getTargetHost().toURI(), connectionManager.getStats(route))));

        return sb.toString();
    }

    private static String createPoolStatsInfo(String title, PoolStats poolStats) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(":").append(poolStats).append("\n");
        return sb.toString();
    }
}

class CustomThread implements Runnable {

    CloseableHttpClient client;
    PoolingHttpClientConnectionManager connectionManager;
    String host;
    int timeout;

    public CustomThread(CloseableHttpClient client, PoolingHttpClientConnectionManager connectionManager, String host, int timeout) {
        this.client = client;
        this.connectionManager = connectionManager;
        this.host = host;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        CloseableHttpResponse httpResponse = null;
        HttpUriRequest request = null;
        try {
            URIBuilder builder = new URIBuilder(host);

            request = new HttpGet(builder.build());

            httpResponse = client.execute(request);
            //((HttpGet)request).releaseConnection();
            logConnectionManagerStats();
            EntityUtils.consume(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            logConnectionManagerStats();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }/* catch (InterruptedException e) {
            e.printStackTrace();
        }*/ finally {
            try {
                System.out.println("Closing response");
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void logConnectionManagerStats() {
        System.out.println(createHttpInfo2(connectionManager));
    }

    private static String createHttpInfo2(PoolingHttpClientConnectionManager connectionManager) {
        StringBuilder sb = new StringBuilder();

        PoolStats totalStats = connectionManager.getTotalStats();
        sb.append(createPoolStatsInfo2("Total Stats", totalStats));

        Set<HttpRoute> routes = connectionManager.getRoutes();

        if (routes != null) {
            for (HttpRoute route : routes) {
                sb.append(createRouteInfo(connectionManager, route));
            }
        }

        return sb.toString();
    }

    private static String createRouteInfo(PoolingHttpClientConnectionManager connectionManager, HttpRoute route) {
        PoolStats routeStats = connectionManager.getStats(route);
        return createPoolStatsInfo2(route.getTargetHost().toURI(), routeStats);
    }

    private static String createPoolStatsInfo(String title, PoolStats poolStats) {
        StringBuilder sb = new StringBuilder();

        sb.append(title + ":").append("\n");
        sb.append("-------------------------").append("\n");

        if (poolStats != null) {
            sb.append("Available: ").append(poolStats.getAvailable()).append("\n");
            sb.append("Leased: ").append(poolStats.getLeased()).append("\n");
            sb.append("Max: ").append(poolStats.getMax()).append("\n");
            sb.append("Pending: ").append(poolStats.getPending()).append("\n");
        }

        sb.append("=========================").append("\n");

        return sb.toString();
    }

    private static String createPoolStatsInfo2(String title, PoolStats poolStats) {
        StringBuilder sb = new StringBuilder();

        sb.append(title + ": ");

        if (poolStats != null) {
            sb.append("Available: ").append(poolStats.getAvailable());
            sb.append(", Leased: ").append(poolStats.getLeased());
            sb.append(", Max: ").append(poolStats.getMax());
            sb.append(", Pending: ").append(poolStats.getPending());
        }
        sb.append("\n");
        return sb.toString();
    }
}
