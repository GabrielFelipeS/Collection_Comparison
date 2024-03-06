package com.br.collectioncomparison.patterns.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection conn;


	public static Connection getConnection() {
		if(conn == null) {
			try{
				Properties props = loadProperties();
				String url = props.getProperty("dbUrl");

				conn = DriverManager.getConnection(url, props);
			} catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return conn;
	}


	private static Properties loadProperties() {
		try (FileInputStream input = new FileInputStream("db.properties");){
			Properties props = new Properties();
			props.load(input);
			return props;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
