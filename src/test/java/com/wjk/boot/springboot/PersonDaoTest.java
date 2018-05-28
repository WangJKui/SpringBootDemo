package com.wjk.boot.springboot;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wjk.boot.springboot.dao.PersonDao;
import com.wjk.boot.springboot.vo.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {
	@Autowired
	private PersonDao personDao;


	@Test
	public void testInsert() {
		Person person = new Person();
		person.setId(3);
		person.setUsername("张三");
		person.setPassword("zhangsan");
		person.setBirthday(new Date());

		int result = this.personDao.insert(person);
		System.out.println(result);
	}

	@Test
	public void testGetById() {
		Person person = this.personDao.getById(1);
		System.out.println(person.getUsername());
	}

	@Test
	public void testUpdate() {
		Person person = new Person();
		person.setId(1);
		person.setPassword("zhangsan123");
		this.personDao.update(person);
	}

	@Test
	public void testDeleteById() {
		int result = this.personDao.deleteById(1);
		System.out.println(result);
	}
}
