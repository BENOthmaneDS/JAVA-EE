package com.esisa.biblio.presentation;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.esisa.biblio.models.Title;

public class TitlesListView extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private String titles[] = {"ISBN", "Title", "Year_Published", "Publisher_ID"};

	public TitlesListView() {
		setTitle("List Of Titles");
		tableModel = new DefaultTableModel(titles, 0);
		JTable table = new JTable(tableModel);
		getContentPane().add("Center", new JScrollPane(table));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
	}
	
	public TitlesListView(List<Title> titles) {
		this();
		setTitles(titles);
	}
	
	public void setTitles(List<Title> titles) {
		tableModel.setRowCount(0);
		for (Title t : titles) {
			tableModel.addRow(new Object[] {t.getIsbn(), t.getTitle(), t.getYearPublished(), t.getPublishedID()});
		}
	}

}
