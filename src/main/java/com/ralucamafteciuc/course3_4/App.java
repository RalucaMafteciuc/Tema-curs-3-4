package com.ralucamafteciuc.course3_4;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class App {
	
    public static void main( String[] args ) throws IOException
    {
    	//create web server service
    	HttpServer server = HttpServer.create(new InetSocketAddress(82), 0);
    	
    	//set handler to specified path
    	server.createContext("/", new IndexHandler());   
    	server.createContext("/register", new RegisterHandler());     	
    	server.createContext("/login", new LoginHandler());
    	server.createContext("/home", new HomeHandler());
    	server.createContext("/show-users", new ShowUsersHandler());    	
    	
    	//creates a default executor
    	server.setExecutor(null);
    	
    	//start the server
    	server.start();
    	
        System.out.println( "Server started on port 82" );
        
        /*
        DBConnection dbConnection = new DBConnection();
        try {
			dbConnection.selectExample("users");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    }   
}