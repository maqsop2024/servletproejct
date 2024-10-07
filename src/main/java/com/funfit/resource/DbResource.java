package com.funfit.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DbResource {

	public static Connection getDbConnection() {
		ResourceBundle rd = ResourceBundle.getBundle("config");
		// driver name for mysql
		String loadDriver = rd.getString("driver");

		// url of the database
		String dbURL = rd.getString("url");

		// username to connect db
		String dbUSERNAME = rd.getString("userName");

		// password to connect db
		String dbPASSWORD = rd.getString("password");
		try {

			// load the driver
			Class.forName(loadDriver);

			// get the connection
			Connection con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);

			return con;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}