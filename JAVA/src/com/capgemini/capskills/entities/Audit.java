package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.Base.BaseEntity;

public class Audit extends BaseEntity {
	

	private int targetGrade;
	private int initialGrade;
	private int collaborateGrade;
	private int userId;
	private int skillId;
	private int projectId;
	
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTargetGrade() {
		return targetGrade;
	}
	public void setTargetGrade(int targetGrade) {
		this.targetGrade = targetGrade;
	}
	public int getInitialGrade() {
		return initialGrade;
	}
	public void setInitialGrade(int initialGrade) {
		this.initialGrade = initialGrade;
	}
	public int getCollaborateGrade() {
		return collaborateGrade;
	}
	public void setCollaborateGrade(int collaborateGrade) {
		this.collaborateGrade = collaborateGrade;
	}
	

}


