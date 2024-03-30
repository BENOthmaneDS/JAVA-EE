package com.esisa.biblio.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;


import com.esisa.biblio.models.Title;

public class AddTitleForm extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Form form;
	private BiblioAction action;

	public AddTitleForm(BiblioAction action) {
		this.action = action;
		
		form = new Form("New Title");
		form.addTextField("ISBN", 30);
		form.addTextField("Title Name", 50);
		form.addTextField("Year Published", 10);
		form.addTextField("Publisher ID", 10);
		
		form.addButton("Submit", "Cancel");
		form.addActionListener(this);
		
		setContentPane(form);
		setTitle("Filling New Titles Form");
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
			action.addTitle(this);
		}
	}

}
