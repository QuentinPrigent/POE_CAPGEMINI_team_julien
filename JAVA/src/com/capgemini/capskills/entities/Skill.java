package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;

public class Skill extends BaseEntity {

	//Attributes
	private double skill_Id;
	private String name;


	//Spécific Constructor
	public Skill(double skill_Id, String name) {
		super();
		this.skill_Id = skill_Id;
		this.name = name;
	}

	//Default Constructor
	public Skill(){}


	//Getter and Setters
	public double getSkill_Id() {
		return skill_Id;
	}
	public void setSkill_Id(double skill_Id) {
		this.skill_Id = skill_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Skill [skill_Id=" + skill_Id + ", name=" + name + "]";
	}



}
