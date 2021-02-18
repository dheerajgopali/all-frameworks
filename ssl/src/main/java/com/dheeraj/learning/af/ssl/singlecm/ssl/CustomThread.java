package com.dheeraj.learning.af.ssl.singlecm.ssl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public class CustomThread implements Runnable {

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