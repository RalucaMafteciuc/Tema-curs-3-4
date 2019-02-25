package com.ralucamafteciuc.course3_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/bazadate?user=sqluser&password=sqluserpw");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectAllExample(String dbTable) throws Exception{
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from " + dbTable);
		String usersTable = "<table cellspacing=\"2\" cellpadding=\"10\" border=1>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Username</td>\r\n" + 
				"		<td>Adresa</td>\r\n" + 
				"	</tr>\r\n";
		
		while (resultSet.next()) {
			String user = resultSet.getString("username");
			String adresa = resultSet.getString("adresa");
			usersTable += "	<tr>\r\n" + 
					"		<td>" + user + "</td>\r\n" + 
					"		<td>" + adresa + "</td>\r\n" + 
					"	</tr>";		
		}
		
		usersTable += "</table>";
		
		System.out.println("users table");
		
		return usersTable;
	}
	
	public Boolean checkCredentials(String username, String password, String dbTable) throws SQLException {
		Boolean userExists;
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from " + dbTable + " where username='" + username + "' and password='" + password + "'");
		
		if (resultSet.first()) {
			userExists = true;
			System.out.println("checking user");
			System.out.println(userExists);
		}else userExists = false;
		
		return userExists;
	}
	
	public void insertExample(String username, String password, String adresa, String dbTable) throws SQLException {
		preparedStatement = connect.prepareStatement("insert into " + dbTable + " values (?, ?, ?)");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);		
		preparedStatement.setString(3, adresa);
		preparedStatement.executeUpdate();
	}
	
	public void deleteExample(String dbTable, String referinta) throws SQLException {
		preparedStatement = connect.prepareStatement("delete from " + dbTable + " where username= ? ;");
		preparedStatement.setString(1, referinta);
		preparedStatement.executeUpdate();
	}
	
	public void updateExample(String referinta, String adresa, String dbTable) throws SQLException {
		preparedStatement = connect.prepareStatement("update " + dbTable + " set adresa=? where username=?");
		preparedStatement.setString(1, adresa);
		preparedStatement.setString(2, referinta);
		preparedStatement.executeUpdate();
	}
}
