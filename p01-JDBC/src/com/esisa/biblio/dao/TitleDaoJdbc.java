package com.esisa.biblio.dao;

import java.util.List;
import java.util.Vector;


import com.esisa.biblio.models.Title;
import com.esisa.java.jdbc.Database;

public class TitleDaoJdbc implements TitleDao {
	private Database db;
	private String tableName = "Titles";

	public TitleDaoJdbc(Database db) {
		this.db = db;
	}

	public List<Title> listTitles() {
		String[][] selectAll = db.select("Titles");
		List<Title> titles = new Vector<Title>();
		
		for (int i = 1; i < selectAll.length; i++) {
			titles.add(new Title(selectAll[i]));
		}
		return titles;
	}
	
	public Title searchByKeyword(String keyword) {
		List<Title> titles = this.listTitles();
		for (Title title : titles) {
			if(title.getTitle().toLowerCase().trim().contains(keyword.toLowerCase().trim())) {
				return title;
			}
		}
		
		return null;
	}

	public int addTitle(Title title) {
		return db.insert(tableName, title.getIsbn(), title.getTitle(), title.getYearPublished(), title.getPublishedID());
	}

}
