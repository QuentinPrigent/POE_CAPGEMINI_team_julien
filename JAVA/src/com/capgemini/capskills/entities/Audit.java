package com.capgemini.capskills.entities;

import java.time.LocalDate;

public class Audit {
	
	private LocalDate dateAudit;
	private LocalDate dateValidation;
	private String targetGrade;
	private String initialGrade;
	private String collaborateGrade;
	
	
	
	public LocalDate getDateAudit() {
		return dateAudit;
	}
	public void setDateAudit(LocalDate dateAudit) {
		this.dateAudit = dateAudit;
	}
	public LocalDate getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(LocalDate dateValidation) {
		this.dateValidation = dateValidation;
	}
	public String getTargetGrade() {
		return targetGrade;
	}
	public void setTargetGrade(String targetGrade) {
		this.targetGrade = targetGrade;
	}
	public String getInitialGrade() {
		return initialGrade;
	}
	public void setInitialGrade(String initialGrade) {
		this.initialGrade = initialGrade;
	}
	public String getCollaborateGrade() {
		return collaborateGrade;
	}
	public void setCollaborateGrade(String collaborateGrade) {
		this.collaborateGrade = collaborateGrade;
	}
	
	
	

}


