package com.cg.TestManagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String userPassword;
	@OneToOne
	private OnlineTest userTest;
	private Boolean isAdmin;
	private Boolean isDeleted;

	public User() {
		super();
	}

	public User(Long userId, String userName, String userPassword, OnlineTest userTest, Boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.isDeleted = false;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public OnlineTest getUserTest() {
		return userTest;
	}

	public void setUserTest(OnlineTest userTest) {
		this.userTest = userTest;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userTest="
				+ userTest + ", isAdmin=" + isAdmin + "]";
	}

	@Override
	public int hashCode() {
		return this.userId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			return this.hashCode() == obj.hashCode();
		}
		return false;
	}

}
