package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends BaseEntity {

	/**
	 * Class Attributes
	 */
	
	private static final DateTimeFormatter dateFormatter
		= DateTimeFormatter.ofPattern("yyy-MM-dd");
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private LocalDate creationDate;
	
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
	
//	public String getCreationDateAsString() {
//		return this.creationDate.format(User.dateFormatter);
//	}
	
	public String getLogin() {
		return this.firstname + "." + this.lastname;
	}

	@Override
	public String toString() {
		return "User [lastname=" + lastname + ", firstname=" + firstname
				+ ", email=" + email + ", password=" + password + ", getId()="
				+ getId() + "]";
	}
	
}
