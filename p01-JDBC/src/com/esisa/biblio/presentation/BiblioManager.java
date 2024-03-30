package com.esisa.biblio.presentation;
import java.util.List;

import com.esisa.biblio.business.BiblioService;
import com.esisa.biblio.business.BiblioServiceDefault;
import com.esisa.biblio.dao.AuthorDao;
import com.esisa.biblio.dao.AuthorDaoJdbc;
import com.esisa.biblio.dao.TitleDaoJdbc;
import com.esisa.biblio.dao.TitleDao;
import com.esisa.biblio.models.Author;
import com.esisa.biblio.models.Title;
import com.esisa.java.jdbc.DataSource;
import com.esisa.java.jdbc.Database;
import com.esisa.java.jdbc.MySqlDataSource;

public class BiblioManager {
	private BiblioService service;
	private BiblioAction action;

	public BiblioManager() {
		wiring();
		exp09();
		//exp03();
	}
	
	void wiring() {
		DataSource ds = new MySqlDataSource("Biblio");
		Database db = new Database(ds);
		AuthorDao authorDao = new AuthorDaoJdbc(db);
		TitleDao titleDao = new TitleDaoJdbc(db);
		service = new BiblioServiceDefault(authorDao, titleDao);
		action = new BiblioAction(service);
		
	}
	
	void exp01() {
		List<Author> authors = service.authors();
		for (Author author : authors) {
			System.out.println(author);
		}
	}
	
	void exp02() {
		action.authorsList();
	}
	
	void exp03() {
		int result = service.add(new Author(16100,"Robert KIOSAKI", 1955));
		if(result > 0) {
			System.out.println("Ajout d'auteur bien effectué");
		}
		else {
			System.out.println("Erreur d'insertion d'auteur");
		}
	}
	
	void exp04() {
		action.addAuthorForm();
	}
	
	void exp05() {
		List<Title> titles = service.titles();
		for (Title title : titles) {
			System.out.println(title);
		}
	}
	
	void exp06() {
		action.titlesList();
	}
	
	void exp07() {
		int result = service.addTitle(new Title("9-9977767-0-X","Robert KIOSAKI", 1990, 191));
		if(result > 0) {
			System.out.println("Title added");
		}
		else {
			System.out.println("Error while insert");
		}
	}
	
	void exp08() {
		action.addTitleForm();
	}
	
	void exp09() {
		action.searchTitleByKeyword("millionaire");
	}

	public static void main(String[] args) {
		new BiblioManager();
	}
}
