package com.ralucamafteciuc.course3_4;

import java.io.IOException;
import java.sql.SQLException;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class HomeHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		String username = Globals.getUriValue(t, "username");
		String password = Globals.getUriValue(t, "password"); 
		
		DBConnection dbConnection = new DBConnection();
		try {
			if(dbConnection.checkCredentials(username, password, "users")) {
				//set the response as a string containing HTML code
		        String response = "<html>\r\n" + 
		        		"\r\n" + 
		        		"<body>\r\n" + 
		        		"    <h1>Buna user : " + Globals.getUriValue(t, "username")+"</h1>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    Ce faci?"+
		        		"</body>\r\n" + 
		        		"\r\n" + 
		        		"</html>";
		        //set headers and status code
				Globals.MakeRequest(t, response);				
			}else {
				Headers responseHeaders = t.getResponseHeaders();
				responseHeaders.set("Location", "/index");
				t.sendResponseHeaders(302, 0);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		/*
		if(Globals.users.containsKey(Globals.getUriValue(t, "username"))) {
			 if(Globals.users.get(Globals.getUriValue(t, "username")).equals(Globals.getUriValue(t, "password"))) {		
				
				//set the response as a string containing HTML code
		        String response = "<html>\r\n" + 
		        		"\r\n" + 
		        		"<body>\r\n" + 
		        		"    <h1>Buna user : " + Globals.getUriValue(t, "username")+"</h1>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    Ce faci?"+
		        		"</body>\r\n" + 
		        		"\r\n" + 
		        		"</html>";
		        //set headers and status code
				Globals.MakeRequest(t, response);
			}else {
				Headers responseHeaders = t.getResponseHeaders();
				responseHeaders.set("Location", "/index");
				t.sendResponseHeaders(302, 0);
			}
		}else {
			Headers responseHeaders = t.getResponseHeaders();
			responseHeaders.set("Location", "/index");
			t.sendResponseHeaders(302,0);			
		}
		*/
	}
}