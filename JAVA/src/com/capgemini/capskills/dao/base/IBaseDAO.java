package com.capgemini.capskills.dao.base;

import java.util.List;

import com.capgemini.capskills.entities.base.BaseEntity;

//IBaseDAO est une interface commune quelque soit le projet

public interface IBaseDAO {

	public BaseEntity insert(BaseEntity item);
	public void delete(BaseEntity item);
	public void update(BaseEntity item);
	public BaseEntity select(BaseEntity item);
	public List<BaseEntity> select();
	
}
