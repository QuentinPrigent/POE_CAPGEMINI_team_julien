package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.capskills.dao.base.BaseDAO;
import com.capgemini.capskills.entities.User;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.manager.DatabaseManager;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;

public class UserDAO extends BaseDAO implements IUserDAO{

	@Override
	public BaseEntity insert(BaseEntity item) {
		User itemUser = (User)item;
		try {
				PreparedStatement st = DatabaseManager.conn().prepareStatement("INSERT INTO User VALUES (?,?,?,?,?,?,?,?)");
				st.setString(1, "null");
				st.setString(2, itemUser.getFirstname());
				st.setString(3, itemUser.getLastname());
				st.setString(4, itemUser.getEmail());
				st.setString(5, itemUser.getPassword());
				st.setString(6, itemUser.getCreationDateAsString());
				st.setString(7, "null");
		} catch (DatabaseNotReadyException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(BaseEntity item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BaseEntity item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseEntity select(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseEntity> select() {
		// TODO Auto-generated method stub
		return null;
	}
	
}