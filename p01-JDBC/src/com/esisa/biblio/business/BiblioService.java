package com.esisa.biblio.business;

import java.util.List;

import com.esisa.biblio.models.Author;
import com.esisa.biblio.models.Title;

/*
 * Business Interface
 */
public interface BiblioService {
	public List<Author> authors();
	public int add(Author author);
	public List<Title> titles();
	public int addTitle(Title title);
	public Title searchTitleByKeyword(String title);
}
