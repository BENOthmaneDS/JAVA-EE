package com.esisa.biblio.dao;

import java.util.List;
import java.util.Vector;

import com.esisa.biblio.models.Author;
import com.esisa.java.jdbc.Database;

public class AuthorDaoJdbc implements AuthorDao{
	private Database db;
	private String tableName = "Authors";
	
	public AuthorDaoJdbc(Database db) {
		this.db = db;
	}

	public int insert(Author author) {
		return db.insert(tableName, author.getId(), author.getName(), author.getYearBorn());
	}

	public void update(Author author) {
		
	}

	public Author delete(int id) {
		return null;
	}

	public Author select(int id) {
		return null;
	}

	public List<Author> selectAll() {
		String[][] selectAll = db.select("Authors");
		List<Author> authors = new Vector<Author>();
		
		for (int i = 1; i < selectAll.length; i++) {
			authors.add(new Author(selectAll[i]));
		}
		return authors;
	}

	public List<Author> selectByKeyword(String keyword) {
		return null;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
