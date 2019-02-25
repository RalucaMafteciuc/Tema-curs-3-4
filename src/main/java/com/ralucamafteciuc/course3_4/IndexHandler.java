package com.ralucamafteciuc.course3_4;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class IndexHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		
		//set the response as a string containing HTML code
		String response = "<html>\r\n" + 
				"  <head>\r\n" + 
				"    <title>Index</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
        		"    <h1>Register user</h1>\r\n" + 	
        		"    <br>\r\n" + 
        		"    <br>\r\n" + 				
				"    <form action=\"register\" method=\"GET\">\r\n" + 
				"      <input type=\"text\" name=\"username\" placeholder=\"Username\" required />\r\n" + 
				"      <input type=\"password\" name=\"password\" placeholder=\"Password\" required />\r\n" +	
				"      <input type=\"text\" name=\"adresa\" placeholder=\"Adresa\" required />\r\n" +					
				"      <input type=\"submit\" value=\"Inregistreaza un utilizator nou\" onclick=\"window.location.replace('localhost:8001/login')\" />\r\n" + 				
				"    </form>\r\n" + 
        		"    <p>-SAU-</p>\r\n" + 
        		"    <span>\r\n" + 
        		"        <a href=\"/login\"><input type=\"button\" name=\"Button\" value=\"Du-te la login\"/></a></span>\r\n" + 				
				"  </body>\r\n" + 
				"</html>";
		
		Globals.MakeRequest(t, response);
	}
}