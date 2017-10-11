package info.liuxing.mybatis.chapter1.model;

import java.io.Serializable;

/**
 * User
 *
 * @author liuxing (SE)
 * @summary User
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017-10-11 17:24
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3433278885351543491L;

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    /**
     * 获取 主键ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
