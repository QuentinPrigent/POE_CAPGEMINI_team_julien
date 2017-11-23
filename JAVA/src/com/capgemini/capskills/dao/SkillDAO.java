package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.capskills.dao.base.BaseDAO;
import com.capgemini.capskills.entities.Skill;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public class SkillDAO extends BaseDAO<Skill> implements ISkillDAO {

	@Override
	public void delete(K item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(K item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Skill select(K item) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
        skill_id            int (11) Auto_increment  NOT NULL ,
        skill_name     Varchar (255) ,
        PRIMARY KEY (skill_id ) ,


	 */
	@Override
	public String getCreateTable() {
		String result = DatabaseManager.CREATE_TABLE[0] + this.tableName
				+ DatabaseManager.CREATE_TABLE[1]
				+ "skill_id				INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL ,"
				+ "skill_name  		VARCHAR (255),"
				+ DatabaseManager.CREATE_TABLE[2];
		return result;
	}

	//CREATE TABLE Skill
	//skill_id int(11) AUTO_INCREMENT NOT NULL,
	//skill_name VARCHAR (255),


	@Override
	protected void setPreparedStatement(PreparedStatement st, Skill item) {
		try {
			st.setString(1, null);
			st.setString(2, item.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Skill retreiveDatas(ResultSet rs) {
		Skill result = new Skill();

		try {
			result.setSkill_Id(rs.getDouble(1));
			result.setName(rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Add the name of the related class
	 * Add the number of attributes needed for the table
	 * int the database
	 */

	public SkillDAO() {
		this.tableName = "Skill";
		this.questionMarks = "?,?";
		this.id= Skill_Id;
	}
}
