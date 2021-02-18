package com.dheeraj.learning.af.ssl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.HttpVersion;


public class TestSSL {
    public static void main(String[] args) {
        KeyStore trustStore = null;
        try {
            RequestConfig.Builder requestConfig = RequestConfig.custom();
            requestConfig.setConnectionRequestTimeout(100 * 1000);
            requestConfig.setConnectTimeout(100 * 1000);
            requestConfig.setSocketTimeout(100 * 1000);

            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            CustomSSLSocketFactory sf = new CustomSSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager();
            /*HttpClient client = new DefaultHttpClient(ccm, params);*/

            HttpClient client = HttpClients.custom()
                    .setSSLSocketFactory(sf)
                    .setConnectionManager(ccm)
                    .setDefaultRequestConfig(requestConfig.build()).build();

            //URIBuilder builder = new URIBuilder("http://localhost:1080/prweb/");

            URIBuilder builder = new URIBuilder("https://sde-86-hyd.eng.rpega.com/prweb");
            //https://sde-86-hyd.eng.rpega.com/prweb/app/SQUIDDevelopment_/t5Fy1LWvTnjnXuogkWpDhQ*/!STANDARD

            HttpUriRequest request = new HttpGet(builder.build());

            HttpResponse httpResponse = client.execute(request);
            System.out.println(httpResponse);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
