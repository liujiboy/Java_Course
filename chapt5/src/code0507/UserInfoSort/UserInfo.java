/**
 * 
 */
package code0507.UserInfoSort;

import java.text.SimpleDateFormat;

/**
 * UserInfo.java Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class UserInfo implements java.io.Serializable {

	private Integer userId;
	private String username;
	private java.util.Date birthDate;
	private Integer age;

	private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

	public UserInfo() {
	}

	public UserInfo(Integer userId, String username, java.util.Date birthDate, Integer age) {
		this.userId = userId;
		this.username = username;
		this.birthDate = birthDate;
		this.age = age;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUsername(String value) {
		this.username = value;
	}

	public String getUsername() {
		return this.username;
	}

	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}

	public java.util.Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDatestr(String value) throws Exception {
		setBirthDate(formater.parse(value));
	}

	public String getBirthDatestr() {
		return formater.format(getBirthDate());
	}

	public void setAge(Integer value) {
		this.age = value;
	}

	public Integer getAge() {
		return this.age;
	}

	public String toString() {
		return new StringBuffer().append(getUserId()).append("; " + getUsername()).append("; " + getBirthDatestr())
				.append("; " + getAge()).toString();
	}
}