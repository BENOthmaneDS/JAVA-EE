package com.esisa.biblio.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.esisa.biblio.models.Author;

public class AddAuhtorForm extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Form form;
	private BiblioAction action;
	
	public AddAuhtorForm(BiblioAction action) {
		this.action = action;
		
		form = new Form("Nouvel auteur");
		form.addTextField("Identificateur", 10);
		form.addTextField("Nom de l'auteur", 30);
		form.addTextField("Année de naissance", 10);
		
		form.addButton("Valider", "Annuler");
		form.addActionListener(this);
		
		setContentPane(form);
		setTitle("Ajout d'un nouvel auteur");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
	}

	public Author getAuthor() {
		return new Author(form.getValues());
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Annuler")) {
			dispose();
		}
		else if(src.getText().equals("Valider")) {
			action.addAuthor(this);
		}
	}

}
