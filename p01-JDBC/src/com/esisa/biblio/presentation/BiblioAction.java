package com.esisa.biblio.presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.esisa.biblio.business.BiblioService;
import com.esisa.biblio.models.Author;
import com.esisa.biblio.models.Title;

/*
 * Class D'Action
 */
public class BiblioAction {
	private BiblioService service;
	
	public BiblioAction(BiblioService service) {
		super();
		this.service = service;
	}
	
	
	public void authorsList() {
		List<Author> authors = service.authors();
		AuthorsListView view = new AuthorsListView(authors);
		view.setVisible(true);
	}
	
	public void titlesList() {
		List<Title> titles = service.titles();
		TitlesListView view = new TitlesListView(titles);
		view.setVisible(true);
	}
	
	public void addAuthorForm() {
		AddAuhtorForm form = new AddAuhtorForm(this);
		form.setVisible(true);
	}
	
	public void addAuthor(AddAuhtorForm form) {
		int result = service.add(form.getAuthor());
		if(result > 0) {
			JOptionPane.showMessageDialog(null, "Auteur bien enregistré");
			form.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Erreur d'insertion", "Ajout d'auteur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void addTitleForm() {
		AddTitleForm formTitle = new AddTitleForm(this);
		formTitle.setVisible(true);
	}
	
	public void addTitle(AddTitleForm form) {
		int result = service.addTitle(form.getTitlesList());
		if(result > 0) {
			JOptionPane.showMessageDialog(null, "Title saved");
			form.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error while insert", "Add Title", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void searchTitleByKeyword(String keyword) {
		Title title = service.searchTitleByKeyword(keyword);
		List<Title> titles = new Vector<Title>();
		titles.add(title);
		
		TitlesListView view = new TitlesListView(titles);
		view.setVisible(true);
	}
	
}
