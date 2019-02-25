package com.ralucamafteciuc.course3_4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class Globals {
	public static HashMap<String, String> users = new HashMap<String, String>();
	
	public static String getUriValue(HttpExchange t, String name) {
		String q = t.getRequestURI().getQuery();
		for(String set:q.split("&")) {
			if(set.split("=")[0].equals(name)) {
				return set.split("=")[1];
			}
		}
		return null;
	}
	
	public static void MakeRequest(HttpExchange t, String response) throws IOException {
		t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        //send response
        os.write(response.getBytes());
        //close request
        os.close();
	}	
}