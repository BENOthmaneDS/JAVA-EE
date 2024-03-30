package com.esisa.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	private String driver;
	private String bridge;
	
	private String source;
	private String host;
	private String user;
	private String password;
	
	public DataSource() {
	}
	
	
	
	public DataSource(String driver, String bridge, String source, String host, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.source = source;
		this.host = host;
		this.user = user;
		this.password = password;
	}



	public Connection getConnection() {
		try {
			// 1. Chargement du Driver : 
			Class.forName(driver);
			
			// 2. Connexion :
			String url = bridge + "//" + host + "/" + source;
			Connection db = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion bien établie...");
			return db;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
		
	}



	public String getDriver() {
		return driver;
	}



	public void setDriver(String driver) {
		this.driver = driver;
	}



	public String getBridge() {
		return bridge;
	}



	public void setBridge(String bridge) {
		this.bridge = bridge;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getHost() {
		return host;
	}



	public void setHost(String host) {
		this.host = host;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
}
