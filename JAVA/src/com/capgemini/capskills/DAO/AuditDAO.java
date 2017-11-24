package com.capgemini.capskills.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.capskills.DAO.Base.BaseDAO;
import com.capgemini.capskills.entities.Audit;
import com.capgemini.capskills.entities.SkillType;
import com.capgemini.capskills.entities.Base.BaseEntity;
import com.capgemini.capskills.Exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.DatabaseManager;

public class AuditDAO extends BaseDAO implements IAuditDAO {
	

	
	@Override
	public BaseEntity insert(BaseEntity item) {
		// TODO Auto-generated method stub
		Audit itemAudit = (Audit)item;
		
		
		try {
			PreparedStatement st =DatabaseManager.conn().prepareStatement("Insert Into audit Values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS );
            
            st.setString(1, null); //ici STId est  autoincrémenter(voir ensemble      	
			st.setInt(2, itemAudit.getUserId());
			st.setInt(3, itemAudit.getSkillId());
			st.setInt(4, itemAudit.getProjectId());
			st.setInt(5, itemAudit.getTargetGrade());
			st.setInt(6, itemAudit.getInitialGrade());
			st.setInt(7, itemAudit.getCollaborateGrade());
			
              
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();
               if (rs.next())
                {
                            itemAudit.setId(rs.getDouble(1));
                            System.out.println("donnée insérée");
                            System.out.println(itemAudit.toString());
                }
            } catch (SQLException | DatabaseNotReadyException e) {
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
	public Audit select(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BaseEntity> select() {
        List<BaseEntity> audit= new ArrayList<BaseEntity>();
	
        try {
			//preparation de la requÃªte SELECT
 			PreparedStatement st =DatabaseManager.conn().prepareStatement("SELECT * FROM audit",Statement.RETURN_GENERATED_KEYS );
			//execute la requÃªte
			ResultSet rs = st.executeQuery();
			
			Audit st1;
			while(rs.next())
			{
				st1=new Audit(rs.getDouble(1),rs.getString(2));
				audit.add(st1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseNotReadyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return audit;
	}
	
	
	
	
	
	
	@Override
	/**
	 	id        int (11) Auto_increment  NOT NULL ,
	    targetgrade  Varchar (255) ,
	    initialgrade Varchar (255) ,
	    collaborategrade     Varchar (255) ,
	   
	 
	    PRIMARY KEY (id )
	 */
	
	}

	@Override
	protected void setPreparedStatement(PreparedStatement st, Audit item) {
		try {
			st.setString(1, null);
			st.setInt(2, item.getUserId());
			st.setInt(3, item.getSkillId());
			st.setInt(4, item.getProjectId());
			st.setInt(5, item.getTargetGrade());
			st.setInt(6, item.getInitialGrade());
			st.setInt(7, item.getCollaborateGrade());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Audit retreiveDatas(ResultSet rs) {
		Audit result = new Audit();

		try {
			result.setUserId(rs.getInt(1));
			result.setSkillId(rs.getInt(2));
			result.setProjectId(rs.getInt(3));
			result.setTargetGrade(rs.getInt(4));
			result.setInitialGrade(rs.getInt(5));
			result.setCollaborateGrade(rs.getInt(6));
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public AuditDAO() {
		this.tableName = "audit";
		this.questionMarks = "?,?,?,?,?";
	}

	@Override
	public String getCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setPreparedStatement(PreparedStatement st, BaseEntity item) {
		// TODO Auto-generated method stub
		
	}
}
