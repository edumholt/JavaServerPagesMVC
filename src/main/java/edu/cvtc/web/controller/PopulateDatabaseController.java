package edu.cvtc.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.PersonDao;
import edu.cvtc.web.dao.impl.PersonDaoImpl;

/**
 * Servlet implementation class PopulateDatabaseController
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String target = null;
	    
	    try {
	        
	        final String filePath = getServletContext().getRealPath("/assets/spreadsheets/JavaWebProgramming.xlsx");
	        
	        final PersonDao personSearchDao = new PersonDaoImpl();
            personSearchDao.populateDatabase(filePath);
            
            request.setAttribute("success", "The database was populated");
            target = "success.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "There was a problem populating the database");
        
            target = "error.jsp";
        }
	    request.getRequestDispatcher(target).forward(request, response);
	}

}
