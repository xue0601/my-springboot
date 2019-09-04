package com.ylyw.master.entity;

public class Class {
    /** id */
    private Integer id;

    /** 班级名称 */
    private String className;

    /** 班级编号 */
    private String classNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }
}