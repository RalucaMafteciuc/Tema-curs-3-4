package com.ralucamafteciuc.course3_4;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class ShowUsersHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
        DBConnection dbConnection = new DBConnection();
        try {
			String response = dbConnection.selectAllExample("users");
			Globals.MakeRequest(t, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}