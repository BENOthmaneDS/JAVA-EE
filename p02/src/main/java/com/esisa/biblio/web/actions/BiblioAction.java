package com.esisa.biblio.web.actions;

import java.util.List;
import java.util.Vector;

import com.esisa.biblio.business.BiblioService;
import com.esisa.biblio.models.Author;
import com.esisa.biblio.models.Title;

/*
 *  Classe d'action 
 */
public class BiblioAction {
	private BiblioService service;
	
	private Author author;
	private Title title;
	private List<Author> authors;
	private List<Title> titles;
	
	public BiblioAction(BiblioService service) {
		this.service = service;
	}
	
/* Méthodes d'action */
	public String searchAuthor() {
   	 	author=new Author(101,"James Gosling", 1955);
   	 	return "AuthorView";
	}
	
	public String authorsList() {
//		authors= new Vector<Author>();
//		authors.add(new Author(1, "Patrick BET DAVID", 1971));  // Saisie des auteurs manuellement
//		authors.add(new Author(2, "Elon MUSK", 1981));
//		authors.add(new Author(3, "Jack MA", 1964));
		
		// Remplissage de la liste des auteurs depuis la base de donnée
		
		authors = service.authors();
		
		return "AuthorsListView";
	}
	
	public String titlesList() {
		titles = service.titles();
		
		return "TitlesListView";
	}
	
	/** Méthodes de récuperation des modèles de données **/
	public Author getAuthor() {
		return author;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public Title getTitle() {
		return title;
	}
	
	public List<Title> getTitles() {
		return titles;
	}
}
