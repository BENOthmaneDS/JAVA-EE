package com.esisa.java.jdbc;

public class Examples {

	public Examples() {
		exp01();
	}
	
	void print(String data[][], int n) {
		if(n >= data.length) n = data.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	void exp01() {
		DataSource ds = new MySqlDataSource("biblio");
		//System.out.println(ds.getConnection());
		Database db = new Database(ds);
		String data[][] = db.select("Authors");
		print(data, 10);
	}
	
	
	public static void main(String[] args) {
		new Examples();
	}
}
