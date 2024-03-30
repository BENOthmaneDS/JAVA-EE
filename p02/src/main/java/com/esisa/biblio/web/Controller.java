package com.esisa.biblio.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.esisa.biblio.business.BiblioService;
import com.esisa.biblio.business.BiblioServiceDefault;
import com.esisa.biblio.dao.AuthorDao;
import com.esisa.biblio.dao.AuthorDaoJdbc;
import com.esisa.biblio.dao.TitleDao;
import com.esisa.biblio.dao.TitleDaoJdbc;
import com.esisa.biblio.models.Author;
import com.esisa.biblio.web.actions.BiblioAction;
import com.esisa.java.jdbc.DataSource;
import com.esisa.java.jdbc.Database;
import com.esisa.java.jdbc.MySqlDataSource;
 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BiblioAction action;
	private String prefix = "/views/";
	private String suffix = ".jsp";
    @Override
    public void init() throws ServletException {
    	wiring();
    }

    void wiring() {
		DataSource ds = new MySqlDataSource("Biblio");
		Database db = new Database(ds);
		
		AuthorDao authorDao = new AuthorDaoJdbc(db);
		TitleDao titleDao = new TitleDaoJdbc(db);
		
		BiblioService service = new BiblioServiceDefault(authorDao, titleDao);
		action = new BiblioAction(service);
		
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//donner la main a la jsp
		
		System.out.println(">> doGet() : " + request.getRequestURI());
		
		String view = "ErrorView";
		Object model = "Service non disponible";
		
		if(request.getRequestURI().endsWith("/get-author")) {
			view = action.searchAuthor();  // Méthode d'action
			model = action.getAuthor();  // Méthode de récuperation du modèle obtenu dans l'action
		}
		else if(request.getRequestURI().endsWith("/authors-list")) {
			view = action.authorsList();
			model = action.getAuthors();
		}
		else if(request.getRequestURI().endsWith("/titles-list")) {
			view = action.titlesList();
			model = action.getTitles();
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher(prefix + view + suffix).forward(request, response);//jsp  = java server page
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}

}
