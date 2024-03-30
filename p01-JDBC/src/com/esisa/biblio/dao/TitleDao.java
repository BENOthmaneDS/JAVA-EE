package com.esisa.biblio.dao;

import java.util.List;
import com.esisa.biblio.models.Title;


public interface TitleDao {
	public List<Title> listTitles();
	public Title searchByKeyword(String keyword);
	public int addTitle(Title title);
}
