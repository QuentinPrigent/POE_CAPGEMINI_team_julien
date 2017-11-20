package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.capskills.dao.base.BaseDao;
import com.capgemini.capskills.entities.Project;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.exception.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public class ProjectDao extends BaseDao implements IProjectDao{

	@Override
	public BaseEntity insert(BaseEntity item) {
		// TODO Auto-generated method stub
		Project itemProject = (Project)item;
		try {
			PreparedStatement st =DatabaseManager.conn().prepareStatement("Insert Into Project Values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS );
				st.setString(1, null);
				st.setString(2, itemProject.getProjectName());
				st.setDate(3, new java.sql.Date(itemProject.getBeginDate().getTime()));
				st.setDate(4, new java.sql.Date(itemProject.getEndDate().getTime()));
				st.setString(5, itemProject.getComment());
				st.setDouble(6, itemProject.getUserId());
				st.executeUpdate();
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next())
				{
							itemProject.setId(rs.getDouble(1));
							System.out.println("donnée insérée");
							System.out.println(itemProject.toString());
				}
	}catch (SQLException | DatabaseNotReadyException e) {
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
		List<BaseEntity> projects= new ArrayList<BaseEntity>();
		try {
			//preparation de la requête
 			PreparedStatement st =DatabaseManager.conn().prepareStatement("SELECT * FROM project",Statement.RETURN_GENERATED_KEYS );
			//execute la requête
			ResultSet rs = st.executeQuery();
			
			Project p;
			while(rs.next())
			{
				p=new Project(rs.getDouble(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),(double)rs.getDouble(6));
				projects.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseNotReadyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return projects;
	}

}
