package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import edu.cvtc.web.exception.PersonSearchException;
import edu.cvtc.web.model.Person;
import edu.cvtc.web.search.PersonSearch;
import edu.cvtc.web.search.impl.PersonSearchImpl;

/**
 * Servlet implementation class SearchByLastNameController
 */
@WebServlet("/SearchByLastName")
public class SearchByLastNameController extends HttpServlet {
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
            final String lastName = request.getParameter("lastName");
            
            if(!Strings.isNullOrEmpty(lastName)){
            final PersonSearch personSearch = new PersonSearchImpl();
            List<Person> people = personSearch.findPeopleByLastName(lastName);
            
            request.setAttribute("people", people);
            
            target = "person-search-results.jsp";
            } else {
                request.setAttribute("error", "You must enter a last name to search.");
                target = "error.jsp";
            }
            
        } catch (PersonSearchException e) {
            e.printStackTrace();
            request.setAttribute("error", "Sorry we were unable to find a person with that last name");
            target = "error.jsp";
        }
	    
	    request.getRequestDispatcher(target).forward(request, response);
	    
	}

}
