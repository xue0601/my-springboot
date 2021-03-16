package com.winter.model;

import java.io.Serializable;

public class Classes implements Serializable {
    private static final long serialVersionUID = 8749671529001605667L;
    private Integer id;

    private String className;

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