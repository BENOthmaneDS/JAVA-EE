package com.esisa.biblio.presentation;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.esisa.biblio.models.Author;

public class AuthorsListView extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private String titles[] = {"Id", "Nom", "Année"};
	
	public AuthorsListView() {
		setTitle("Liste d'autheurs");
		tableModel = new DefaultTableModel(titles, 0);
		JTable table = new JTable(tableModel);
		getContentPane().add("Center", new JScrollPane(table));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
	}

	public AuthorsListView(List<Author> authors) {
		this();
		setAuthors(authors);
	}
	
	public void setAuthors(List<Author> authors) {
		tableModel.setRowCount(0);
		for (Author a : authors) {
			tableModel.addRow(new Object[] {a.getId(), a.getName(), a.getYearBorn()});
		}
	}
	
}
