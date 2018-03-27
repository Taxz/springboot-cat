package com.study.edu;

import com.study.edu.annotation.FruitAnnotation;
import com.study.edu.entity.Fruit;
import com.study.edu.entity.SexNum;
import com.study.edu.entity.User;
import com.study.edu.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("aa", "a123456", SexNum.MAN));
		userMapper.insert(new User("bb", "b123456", SexNum.WOMAN));
		userMapper.insert(new User("cc", "b123456", SexNum.WOMAN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.size());
		}
	}


	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(6l);
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(6l).getNickName())));
	}



}
