package com.esisa.biblio.business;

import java.util.List;

import com.esisa.biblio.dao.AuthorDao;
import com.esisa.biblio.dao.TitleDao;
import com.esisa.biblio.models.Author;
import com.esisa.biblio.models.Title;

/*
 * Business Class
 */
public class BiblioServiceDefault implements BiblioService{
	private AuthorDao authorDao;
	private TitleDao titleDao;
	
	public BiblioServiceDefault(AuthorDao authorDao, TitleDao titleDao) {
		super();
		this.authorDao = authorDao;
		this.titleDao = titleDao;
		}

	public List<Author> authors() {
		return authorDao.selectAll();
	}
	
	public List<Title> titles(){
		return titleDao.listTitles();
	}

	public int add(Author author) {
		return authorDao.insert(author);
	}
	
	public int addTitle(Title title) {
		return titleDao.addTitle(title);
	}

	
	public Title searchTitleByKeyword(String title) {
		return titleDao.searchByKeyword(title);
	}

}
