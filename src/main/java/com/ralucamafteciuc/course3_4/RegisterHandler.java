package com.ralucamafteciuc.course3_4;

import java.io.IOException;
import java.sql.SQLException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class RegisterHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		String username = Globals.getUriValue(t, "username");
		String password = Globals.getUriValue(t, "password");  
		String adresa = Globals.getUriValue(t, "adresa"); 		
		DBConnection dbConnection = new DBConnection();
		
		if(username != null && password != null && adresa != null) {
			try {
				dbConnection.insertExample(username, password, adresa, "users");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String response = "<html>\r\n" + 
	        		"\r\n" + 
	        		"<body>\r\n" + 
	        		"    <h1>Register user</h1>\r\n" + 
	        		"    <h2>Utilizator inregistrat cu success</h2>"+
	        		"    <p>-SAU-</p>\r\n" + 
	        		"    <input onclick=\"window.location.href = '/login'\" type=\"button\" name=\"login\" value=\"Du-te la login\"/>\r\n" + 
	        		"    <input onclick=\"window.location.href = '/show-users'\" type=\"button\" name=\"show-users\" value=\"Vezi toti utilizatorii\"/>\r\n" + 	        		
	        		"	 <br>\r\n" + 	        		
	        		"</body>\r\n" + 
	        		"\r\n" + 
	        		"</html>";
			
			Globals.MakeRequest(t, response);
		}else {
			String response = "<html>\r\n" + 
	        		"\r\n" + 
	        		"<body>\r\n" + 
	        		"    <h1>Register user</h1>\r\n" + 
	        		"    <br>\r\n" + 
	        		"    <br>\r\n" + 
	        		"       <a href=\"/\"><input type=\"button\" name=\"Button\" value=\"Du-te la register\"/></a>"+
	        		"    <p>-SAU-</p>\r\n" + 
	        		"    <span>\r\n" + 
	        		"        <input onclick=\"window.location.href = 'localhost:8001/login';\" type=\"button\" name=\"login\" value=\"Du-te la login\"/></span>\r\n" + 
	        		"</body>\r\n" + 
	        		"\r\n" + 
	        		"</html>";
			
			Globals.MakeRequest(t, response);
		}
	}
}
