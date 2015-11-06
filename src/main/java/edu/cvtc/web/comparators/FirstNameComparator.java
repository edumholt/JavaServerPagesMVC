package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Person;

/**
 * @author edumholt
 *
 */
public class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(final Person firstPerson, final Person secondPerson) {
		return firstPerson.getFirstName().compareTo(secondPerson.getFirstName()); 
	}

}
