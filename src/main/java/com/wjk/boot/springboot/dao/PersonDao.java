package com.wjk.boot.springboot.dao;

import com.wjk.boot.springboot.vo.Person;

public interface PersonDao {
	public int insert(Person person);

	public int deleteById(Integer id);

	public int update(Person person);

	public Person getById(Integer id);
}
