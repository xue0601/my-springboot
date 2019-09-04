package com.ylyw.slaver.controller;

import com.ylyw.slaver.entity.New;
import com.ylyw.slaver.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-14 17:02
 **/
@RequestMapping(value = "new")
@RestController
public class NewController {

    @Autowired
    private NewService newService;

    @PostMapping(value = "addNew")
    public String addNew(String id,String userId,String title,String message){

        New new1 = new New();
        new1.setId(id);
        new1.setTitle(title);
        new1.setMessageId(message);
        new1.setUserId(userId);
        new1.setCreateDate(new Date());
        newService.insertNew(new1);
        return "OK";
    }



}
