package com.dheeraj.learning.af.ssl.singlecm.ssl;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;

public class Logger {

    PoolingHttpClientConnectionManager connectionManager;

    void Logger(PoolingHttpClientConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
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
