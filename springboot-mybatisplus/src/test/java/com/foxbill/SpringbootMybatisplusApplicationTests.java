package com.foxbill;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	void testService(){
		List<User> list = userService.list();
		list.forEach(System.out::println);
	}

}
