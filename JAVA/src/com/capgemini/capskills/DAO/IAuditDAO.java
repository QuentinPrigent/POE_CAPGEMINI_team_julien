package com.capgemini.capskills.DAO;

import java.util.List;

import com.capgemini.capskills.entities.Base.BaseEntity;

public interface IAuditDAO {

	public BaseEntity insert(BaseEntity item);
	public void delete(BaseEntity item);
	public void update(BaseEntity item);
	public BaseEntity select(BaseEntity item);
	public List<BaseEntity> select();

}
