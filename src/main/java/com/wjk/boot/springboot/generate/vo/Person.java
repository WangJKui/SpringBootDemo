package com.wjk.boot.springboot.generate.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：人员信息的VO对象
 * @author Wjk
 * @date 2018/06/01
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *主键id
	 */
	private Integer id;
	/**
	 *用户名称
	 */
	private String username;
	/**
	 *账户密码
	 */
	private String password;
	/**
	 *生日
	 */
	private Date birthday;

	public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}