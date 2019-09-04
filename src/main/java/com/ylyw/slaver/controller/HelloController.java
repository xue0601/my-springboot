package com.ylyw.slaver.controller;

import com.winter.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-07-12 17:35
 **/
@RestController
public class HelloController {

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value = "hello")
    public String hello(){
        return "hello world";
    }


    @RequestMapping(value = "setValue")
    public boolean setValue(){
        redisTemplate.opsForValue().set(123456,"中文",500,TimeUnit.SECONDS);
        return true;
    }

    @RequestMapping(value = "setValue1")
    @Cacheable(value = "789",key = "999")
    public String setValue1(){

        return "中文";
    }



    @RequestMapping(value = "getValue")
    @Cacheable(cacheNames= "12345", key = "999999")
    public Classes getValue(){
        System.out.println("");
        return null;
    }

//    @RequestMapping(value = "setUser")
//    public boolean setUser(){
//        User user = new User();
//        Person persion = new Person();
//        user.setAge("18");
//        user.setName("李磊");
//        user.setUsername("15239013190");
//        user.setPassword("123456789");
//        user.setPhone("15239013190");
//        String user1 = JSON.toJSONString(user);
//        redisTemplate.opsForValue().set("user",user1,5000,TimeUnit.SECONDS);
//        return true;
//    }
//
//    @RequestMapping(value = "setMap")
//    @Cacheable(value = "aaa",key = "#person.id")
//    public Person setMap(){
//        User user = new User();
//        Person person = new Person();
//        user.setAge("1899999");
//        user.setName("李磊");
//        user.setUsername("15239013190");
//        user.setPassword("123456789");
//        user.setPhone("15239013190");
//        person.setId("99999");
//        person.setName("小名");
//        person.setSex("男");
//        return person;
////        redisTemplate.opsForValue().set("key",map,500,TimeUnit.SECONDS);
//    }
//
//    @RequestMapping(value = "query")
//    @Cacheable(value = "user",key = "#id")
//    public Map query(String id,String phone,String age,String name,String password){
//        Map map = new HashMap();
//        User user = new User();
//        user.setId(id);
//        user.setPhone(phone);
//        user.setAge(age);
//        user.setName(name);
//        user.setPassword(password);
//        System.out.println("=============我往缓存中存数据==============");
//        Person person = new Person();
//        person.setId(id);
//        person.setName(name);
//        person.setSex("nan");
//        map.put("user",user);
//        map.put("person",person);
//        return map;
//
//    }


    @RequestMapping(value = "getUsers")
    @CacheEvict(value = "user",key = "#userId")
    public void user(String userId){
        System.out.println("我是来删除缓存内容的");
    }


//    @RequestMapping(value = "getMap")
//    public Map getMap(){
//        Map map = (Map)redisTemplate.opsForValue().get("key");
//        User user = (User)map.get("user");
//        System.out.println(user.getName());
//        System.out.println(user.getAge());
//        return (Map)redisTemplate.opsForValue().get("key");
//    }
//
//
//    @RequestMapping(value = "getUser")
//    public Map getUser(){
//        Map map = new LinkedHashMap();
//        String user = redisTemplate.opsForValue().get("user").toString();
//        System.out.println(user);
//        //将json字符串转换为json对象
//        JSONObject obj = JSON.parseObject(user);
//        //将建json对象转换为Person对象
//        User user1 = JSONObject.toJavaObject(obj,User.class);
//        System.out.println("age==="+user1.getAge());
//        System.out.println("name==="+user1.getName());
//        System.out.println("username==="+user1.getUsername());
//        System.out.println("phone==="+user1.getPhone());
//        map.put("user",user);
//        return map;
//    }

}
