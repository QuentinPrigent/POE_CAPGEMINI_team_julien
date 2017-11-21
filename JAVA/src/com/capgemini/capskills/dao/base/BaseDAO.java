package com.capgemini.capskills.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.capgemini.capskills.entities.SkillType;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public abstract class BaseDAO<K extends BaseEntity> implements IBaseDAO<K> {

	protected String questionMarks;

	protected String tableName;

	public String getTableName() {
		return tableName;
	}

	@Override
	public K insert(K item) {

		try {
			PreparedStatement st = DatabaseManager.conn().prepareStatement(
					"INSERT INTO " + this.tableName + " VALUES ("
							+ this.questionMarks + ")",// Check element
					// number of
					// items
					PreparedStatement.RETURN_GENERATED_KEYS);

			setPreparedStatement(st, item);

			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				item.setId(rs.getDouble(1));
			}

		} catch (DatabaseNotReadyException | SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	
	//Ne marche pas...
	
	@Override
	public void delete(K item) {
		try {
			PreparedStatement st = DatabaseManager.conn().prepareStatement(
					"DELETE FROM " + this.tableName + " WHERE user_id = " + item.getId());
			
			st.executeUpdate();
			
		} catch (DatabaseNotReadyException | SQLException e) {
			e.printStackTrace();
		}
	}	

//	UPDATE Customers
//	SET ContactName='Juan'
//	WHERE Country='Mexico';

	@Override
	public void update(K item) {
		
		try {
			PreparedStatement st = DatabaseManager.conn().prepareStatement(
				"UPDATE " + this.tableName + " SET " + this.questionMarks +" WHERE user_id = " + item.getId());
			setPreparedStatement(st, item);
			st.executeUpdate();
		} catch(DatabaseNotReadyException | SQLException e) {
			e.printStackTrace();
		}
	}
			
	

	
	@Override
	public List<K> select() {
		List<K> result = new ArrayList<K>();
		Connection conn;

		try {
			conn = DatabaseManager.conn();

			try (PreparedStatement st = conn.prepareStatement("SELECT * FROM "
					+ DatabaseManager.DATABASE_NAME + "." + this.tableName)) {
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					result.add(retrieveDatas(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (DatabaseNotReadyException e) {
			e.printStackTrace();
		}

		return result;
	}
	


	protected abstract K retrieveDatas(ResultSet rs);

	protected abstract void setPreparedStatement(PreparedStatement st, K item);
}
