package com.ylyw.slaver.entity;

import java.io.Serializable;

/**
 * @program: my-springboot
 * @description: 人
 * @author: Xue0601
 * @create: 2018-07-13 11:57
 **/
public class Person implements Serializable {

    private String id;

    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
