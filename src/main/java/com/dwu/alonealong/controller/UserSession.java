package com.dwu.alonealong.controller;

import java.io.Serializable;
import com.dwu.alonealong.domain.User;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private User user;

	public UserSession(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
