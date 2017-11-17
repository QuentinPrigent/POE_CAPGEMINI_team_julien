package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class User extends BaseEntity {

	/**
	 * Class Attributes
	 */
	
	protected static final DateTimeFormatter dateFormatter
		= DateTimeFormatter.ofPattern("yyy-MM-dd");
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String password;
	protected LocalDate creationDate;
	
	/**
	 * The class constructor
	 */
	
	public User(){
		
	}
	
	/**
	 * The second class constructor
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 */
	
	public User(String firstname, String lastname, String email, String password){
		this.firstname = firstname;
		this.lastname= lastname;
		this.email = email;
		this.password = password;
		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public String getCreationDateAsString() {
		return this.creationDate.format(User.dateFormatter);
	}
	
}
