package com.viniciusmo.androidtextspeech.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class WebClient {

	public static String getContent(String urlSite) {
		StringBuilder result = new StringBuilder();
		URL url;
		URLConnection urlConn;
		try {
			url = new URL(urlSite);
			urlConn = url.openConnection();
			urlConn.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			Reader reader = new InputStreamReader(urlConn.getInputStream(),
					"utf-8");
			BufferedReader br = new BufferedReader(reader);
			int byteRead;
			while ((byteRead = br.read()) != -1)
				result.append((char) byteRead);
		} catch (IOException e) {
			throw new WebClientException();
		}
		return result.toString();
	}

	public static InputStream getInputStream(String urlSite) {
		URL url;
		InputStream inputStream = null;
		try {
			url = new URL(urlSite);
			URLConnection urlConn;
			urlConn = url.openConnection();
			urlConn.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			inputStream = urlConn.getInputStream();
		} catch (IOException e) {
			throw new WebClientException();
		}
		return inputStream;
	}

}
