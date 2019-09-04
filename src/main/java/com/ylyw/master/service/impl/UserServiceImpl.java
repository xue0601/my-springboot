package com.ylyw.master.service.impl;

import com.ylyw.master.dao.UserMapper;
import com.ylyw.master.entity.User;
import com.ylyw.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-14 16:53
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }
}
