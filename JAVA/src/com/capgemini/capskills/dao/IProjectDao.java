package com.capgemini.capskills.dao;

import java.util.List;

import com.capgemini.capskills.entities.base.BaseEntity;

public interface  IProjectDao {
	public BaseEntity insert(BaseEntity item);
	public void delete(BaseEntity item);
	public void update(BaseEntity item);
	public BaseEntity select(BaseEntity item);
	public List<BaseEntity> select();
	
}
