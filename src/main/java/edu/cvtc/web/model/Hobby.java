package edu.cvtc.web.model;

/**
 * @author edumholt
 * 
 */
public class Hobby {

	private String name;
	private String description;

	public Hobby(final String name, final String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
