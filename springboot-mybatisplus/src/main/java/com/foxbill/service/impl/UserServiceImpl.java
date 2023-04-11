package com.foxbill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
