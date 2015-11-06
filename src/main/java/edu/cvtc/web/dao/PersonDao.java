package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exception.PersonDatabaseException;
import edu.cvtc.web.model.Person;

/**
 * @author edumholt
 *
 */
public interface PersonDao {

	void populateDatabase(String filePath) throws Exception;
	
	List<Person> retrievePeopleFromDatabase() throws PersonDatabaseException;

	Integer insertPerson(Person person) throws PersonDatabaseException;
	
}
