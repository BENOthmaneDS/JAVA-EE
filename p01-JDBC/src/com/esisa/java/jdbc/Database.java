package com.esisa.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Database {
	private DataSource dataSource;
	private Connection db;
	
	public Database(DataSource ds) {
		dataSource = ds;
		db = ds.getConnection();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}
	
	public String[][] select(String tableName) {
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM " + tableName);
			rs.last();
			int rows = rs.getRow();     
			rs.beforeFirst();
			
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			
			String data[][] = new String[rows + 1][cols];
			
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			
			int row = 0;
			while(rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
			rs.close();
			
			return data;
		}catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public int insert(String tableName, Object... row) {
		try {
			//int rowsSize = row.length;
			//String query = "INSERT INTO " + tableName + " VALUES(";
			
//			if(rowsSize == 1) {
//				query += row + ")";
//			}
//			else if (rowsSize > 1) {
//				int index = 0;
//				
//				for (Object value : row) {
//					if(index == rowsSize) {
//						query += value + ")";
//					} 
//					else if(index < rowsSize) {
//						query += value + ",";
//						index++;
//					}
//				}
//			}
			
			String query = "INSERT INTO " + tableName + " VALUES('" + row[0] + "'";
			
			for (int i = 1; i < row.length; i++) {
				query += ", '" + row[i] + "'";
			}
			query += ")";
			Statement sql = db.createStatement();
			return sql.executeUpdate(query);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return -1;
		}
	}
	
}
