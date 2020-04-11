package com.springboot.aop.entity;

import java.io.Serializable;

/**
 * (TStu)实体类
 *
 * @author makejava
 * @since 2020-04-10 09:21:10
 */
public class TStu implements Serializable {
    private static final long serialVersionUID = 425162481916342390L;
    
    private Integer userCode;
    
    private String userName;
    
    private Integer classId;


    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

}