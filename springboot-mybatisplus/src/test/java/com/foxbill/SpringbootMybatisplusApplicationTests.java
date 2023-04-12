package com.foxbill;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import com.foxbill.util.MPLambdaWrapperUtil;
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

	@Test
	public void testLambda01(){
		String username = "高";
		Integer ageBegin = 10;
		Integer ageEnd = 24;
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
					.ge(ageBegin!=null,User::getAge,ageBegin)
					.le(ageEnd!=null,User::getAge,ageEnd);

		System.out.println(MPLambdaWrapperUtil.getColumn(User::getName));
		System.out.println(MPLambdaWrapperUtil.getColumn(User::getAge));

		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(System.out::println);
	}

}
