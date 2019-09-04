package com.ylyw.slaver.dao;

import com.ylyw.slaver.entity.New;

public interface NewMapper {
    int deleteByPrimaryKey(String id);

    int insert(New record);

    int insertSelective(New record);

    New selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKey(New record);
}