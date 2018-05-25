package com.wjk.boot.springboot.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wjk.boot.springboot.dao.PersonDao;
import com.wjk.boot.springboot.vo.Person;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Person person) {
		String sql = "insert into person(id,username,password,birthday) values(?,?,?,?)";
		return this.jdbcTemplate.update(
				sql,
				person.getId(),
				person.getUsername(),
				person.getPassword(),
				person.getBirthday()
				);
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "delete from person where id = ?";
		return this.jdbcTemplate.update(sql,id);
	}

	@Override
	public int update(Person person) {
		String sql = "update person set password = ? where id = ?";
		return this.jdbcTemplate.update(
				sql, 
				person.getPassword(),
				person.getId()
				);
	}

	@Override
	public Person getById(Integer id) {
		String sql = "select * from person where id = ?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setPassword(rs.getString("password"));
				person.setBirthday(rs.getDate("birthday"));
				return person;
			}

		},id);
	}

}
