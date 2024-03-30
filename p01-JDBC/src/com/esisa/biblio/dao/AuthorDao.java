package com.esisa.biblio.dao;

import java.util.List;

import com.esisa.biblio.models.Author;

public interface AuthorDao {
	public int insert(Author author);
	public void update(Author author);
	public Author delete(int id);
	public Author select(int id);
	public List<Author> selectAll();
	public List<Author> selectByKeyword(String keyword);
}
