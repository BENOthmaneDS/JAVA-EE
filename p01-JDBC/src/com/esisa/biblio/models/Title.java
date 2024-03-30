package com.esisa.biblio.models;

public class Title {
	private String isbn;
	private String title;
	private int yearPublished;
	private int publishedID;
	
	public Title() {
		
	}
	
	public Title(String isbn, String  title, int yearPublished, int publishedID) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		this.publishedID = publishedID;
	}

	
	public Title(String ...row) {
		super();
		this.isbn = row[0];
		this.title = row[1];
		try {
			this.yearPublished = Integer.parseInt(row[2]);
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		try {
			this.publishedID = Integer.parseInt(row[3]);
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public int getPublishedID() {
		return publishedID;
	}

	public void setPublishedID(int publishedID) {
		this.publishedID = publishedID;
	}
	
	
	
}
