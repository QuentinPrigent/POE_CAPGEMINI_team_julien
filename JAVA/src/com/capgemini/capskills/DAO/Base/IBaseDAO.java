package com.capgemini.capskills.DAO.Base;

import java.util.List;

import com.capgemini.capskills.entities.Base.BaseEntity;

public interface IBaseDAO <T extends BaseEntity> {

	public T insert(T item);
	public void delete(T item);
	public void update(T item);
	public T select(T item);
	public List<T> select();

	public String getCreateTable();
}
