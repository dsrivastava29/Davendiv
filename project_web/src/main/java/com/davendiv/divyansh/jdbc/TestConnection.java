package com.davendiv.divyansh.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.hibernate.cfg.Configuration;

public class TestConnection {

	public static boolean check() {

		System.out.println("create jdbc connection using properties file");

		Connection con = null;

		try {
			Configuration cf = new Configuration().configure();

			Properties prop = cf.getProperties();

			String driverClass = prop.getProperty("hibernate.connection.driver_class");
			String url = prop.getProperty("hibernate.connection.url");
			String username = prop.getProperty("hibernate.connection.username");
			String password = prop.getProperty("hibernate.connection.password");

			Class.forName(driverClass);
			url = "jdbc:mysql://localhost:3306/";
			con = DriverManager.getConnection(url, username, password);

			if (con != null) {
				ArrayList<String> list = new ArrayList<String>();
				String database = "davendiv";
				DatabaseMetaData meta = con.getMetaData();
				ResultSet rs = meta.getCatalogs();
				while (rs.next()) {
					String listofDatabases = rs.getString("TABLE_CAT");
					list.add(listofDatabases);
				}
				String[] tabs = new String[1];
				tabs[0] = "TABLE";
				if (list.contains(database)) {
					rs = meta.getTables(database, null, "%", tabs);
					if (rs.next())
						return true;
					else
						return false;

				} else
					return false;
			} else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		InputStream in = new FileInputStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}

}
