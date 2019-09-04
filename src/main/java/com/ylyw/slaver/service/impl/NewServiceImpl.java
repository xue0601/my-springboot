package com.ylyw.slaver.service.impl;

import com.ylyw.slaver.dao.NewMapper;
import com.ylyw.slaver.entity.New;
import com.ylyw.slaver.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-14 17:05
 **/
@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewMapper newMapper;

    @Override
    public void insertNew(New new1) {
        newMapper.insertSelective(new1);
    }
}
