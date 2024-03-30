package com.esisa.java.jdbc;

public class MySqlDataSource extends DataSource{
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MySqlDataSource() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "mysql", "localhost", "root", "");
	}

	public MySqlDataSource(String source, String host, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, host, user, password);
	}
	
	public MySqlDataSource(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", user, password);
	}
	
	public MySqlDataSource(String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", user, "");
	}
	
	public MySqlDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, source, "localhost", "root", "");
	}
	
	
	
}
