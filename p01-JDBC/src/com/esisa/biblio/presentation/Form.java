package com.esisa.biblio.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Form extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel content;
	private JPanel buttons;
	private int labelWidth;
	private Vector<JTextField> fields;

	public Form(String title) {
		this(title,140);
	}
	
	public Form(String title, int labelWidth) {
		this.labelWidth = labelWidth;
		setLayout(new BorderLayout());
		
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		Border border = new EtchedBorder();
		content.setBorder(new TitledBorder(border, " " + title + " : "));
		add("Center", content);
		
		buttons = new JPanel();
		add("South", buttons);
		fields = new Vector<JTextField>();
	}
	
	public void addTextField(String label, int size) {
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) {
			label = label + " : ";
		}
		JLabel l1 = new JLabel(label);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
		p1.add(l1);
		
		JTextField t1 = new JTextField(size);
		p1.add(t1);
		fields.add(t1);
		
		content.add(p1);
	}
	
	public void addButton(String...labels) {
		
//		for (String label : labels) {
//			addButton(label);
//		}
		JButton buttonValider = new JButton("Valider");
		JButton buttonAnnuler = new JButton("Annuler");
		
		buttons.add(buttonValider);
		buttons.add(buttonAnnuler);
	}
	
	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < buttons.getComponentCount(); i++) {
			((JButton)buttons.getComponent(i)).addActionListener(listener);
		}
		
		
	}
	
	public void setValue(int index, Object value) {
		fields.get(index).setText(""+ value);
	}
	
	public void setValues(Object...values) {
		for (int i = 0; i < values.length; i++) {
			setValue(i, values[i]);
		}
	}
	
	public String getValue(int index) {
		return fields.get(index).getText();
	}
	
	public String[] getValues() {
		String t[] = new String[fields.size()];
		for (int i = 0; i < t.length; i++) {
			t[i] = fields.get(i).getText();
		}
		return t;
	}
	
}
