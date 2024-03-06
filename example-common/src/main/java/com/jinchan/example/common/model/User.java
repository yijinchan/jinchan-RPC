package com.jinchan.example.common.model;

import java.io.Serializable;

/**
 * 用户
 */
public class User implements Serializable{
    /**
     * 用户名
     */
    private String name;

    /**
     * 获取用户名
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * 设置用户名
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
}
