package com.esisa.biblio.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.esisa.biblio.models.Title;

public class SearchTitleForm extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Form form;
	private BiblioAction action;
	
	public SearchTitleForm(BiblioAction action) {
		this.action = action;
		
		form = new Form("Search Title");
		form.addTextField("Title Name", 30);
		
		form.addButton("Submit", "Cancel");
		form.addActionListener(this);
		
		setContentPane(form);
		setTitle("Search Title By The Title Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
	}
	
	public Title getTitlesList() {
		return new Title(form.getValues());
	}
	

	
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Annuler")) {
			dispose();
		}
		else if(src.getText().equals("Valider")) {
			action.searchTitleByKeyword(this.getTitle());
		}
	}

}
