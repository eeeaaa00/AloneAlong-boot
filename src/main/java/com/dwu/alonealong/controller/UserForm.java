package com.dwu.alonealong.controller;

import java.io.Serializable;

import com.dwu.alonealong.domain.User;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 */
@SuppressWarnings("serial")
public class UserForm implements Serializable {

	private User user;

	private boolean newUser;

	private String repeatedPassword;

	public UserForm(User user) {
		this.user = user;
		this.newUser = false;
	}

	public UserForm() {
		this.newUser = true;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}
}
