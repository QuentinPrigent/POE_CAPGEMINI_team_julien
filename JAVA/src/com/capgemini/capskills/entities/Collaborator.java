package com.capgemini.capskills.entities;

public class Collaborator extends User{

	/* project_status shows if the collaborator is allocated to a project or not */
	
	private Project project;
	private LocalDate StartAt;
	private LocalDate EndAt;
	private List<Skill> skills;

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public LocalDate getStartAt() {
		return StartAt;
	}
	public void setStartAt(LocalDate startAt) {
		StartAt = startAt;
	}
	public LocalDate getEndAt() {
		return EndAt;
	}
	public void setEndAt(LocalDate endAt) {
		EndAt = endAt;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
