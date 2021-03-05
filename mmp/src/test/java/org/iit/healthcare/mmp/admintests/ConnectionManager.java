package org.iit.healthcare.mmp.admintests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectionManager {

	@Test(dataProvider = "DP")
	public void login(String uname, String pword) {
		System.out.println("username::" + uname);
		System.out.println("password::" + pword);
	}

	@DataProvider(name = "DP")
	public String[][] feedDataProvider() throws ClassNotFoundException, SQLException {
		String data[][] = fetchDatafromDB("testdb", "login");
		return data;
	}

	public String[][] fetchDatafromDB(String dbName, String tableName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		/*
		 * url a database url of the form jdbc:subprotocol:subnameuser the database user
		 * on whose behalf the connection is being madepassword the user's password
		 */
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		String username = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		int value = stmt.executeUpdate("INSERT INTO `testdb`.`" + tableName + "` VALUES ('java','java123#');");
		System.out.println("The rows are upated " + value);

		ResultSet rs = stmt.executeQuery("Select * from testdb.login");
		rs.last();

		int rows = rs.getRow();
		System.out.println("Number of rows " + rows);

		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println("Number of cols: " + cols);

		String data[][] = new String[rows][cols];

		int i = 0;
		rs.beforeFirst();
		while (rs.next()) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = rs.getString(j + 1);
				System.out.println(data[i][j]);
			}
			i++;
		}
		return data;
	}

}
