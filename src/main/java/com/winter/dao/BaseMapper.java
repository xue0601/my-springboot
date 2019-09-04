package com.winter.dao;


public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(Object record);

    int insertSelective(T entity);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
