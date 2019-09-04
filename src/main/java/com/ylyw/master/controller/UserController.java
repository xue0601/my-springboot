package com.ylyw.master.controller;

import com.webSocket.ServerMessage;
import com.ylyw.master.entity.User;
import com.ylyw.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-14 14:26
 **/
@RequestMapping(value = "user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
    @GetMapping(value = "serviceToClient")
    public void templateTest() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
    }

    @PostMapping(value = "addUser")
    public String addUser(int id,String name,String phone){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        userService.addUser(user);
        return "OK";
    }

}
