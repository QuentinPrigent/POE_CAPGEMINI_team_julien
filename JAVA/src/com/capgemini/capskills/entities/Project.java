package com.capgemini.capskills.entities;

import java.util.Date;


import com.capgemini.capskills.entities.base.BaseEntity;

public class Project extends BaseEntity {
	private String projectName;
	private Date beginDate;
	private Date endDate;
    private String comment;
	private double userId;
	public Project(String projectName, Date beginDate, Date endDate, String comment, double userId) {
		super();
		this.projectName = projectName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.comment = comment;
		this.userId = userId;
	}
	
	public Project(double id,String projectName, Date beginDate, Date endDate, String comment, double userId) {
		super();
		this.setId(id);
		this.projectName = projectName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.comment = comment;
		this.userId = userId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getUserId() {
		return userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", comment=" + comment + ", userId=" + userId + "]";
	}
	
}
