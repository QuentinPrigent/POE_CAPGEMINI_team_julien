package com.capgemini.capskills.entities;

public class Grading extends BaseEntity {

	private List<Skills> skillsGoal;
	private ProjectLeader leader;
	private Collaborator collaborator;
	private boolean success;
	private LocalDate startAt;
	private LocalDate endAt;
	public ProjectLeader getLeader() {
		return leader;
	}
	public void setLeader(ProjectLeader leader) {
		this.leader = leader;
	}
	public Collaborator getCollaborator() {
		return collaborator;
	}
	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public LocalDate getStartAt() {
		return startAt;
	}
	public void setStartAt(LocalDate startAt) {
		this.startAt = startAt;
	}
	public LocalDate getEndAt() {
		return endAt;
	}
	public void setEndAt(LocalDate endAt) {
		this.endAt = endAt;
	}

	
	
}
