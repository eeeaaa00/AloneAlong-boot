package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TogetherMember implements Serializable {

	private String togetherMemberId;
	private String userId;
	private String togetherId;
	private int isHost;
	private User user;
	
	public TogetherMember(String togetherMemberId, String userId, String togetherId,  int isHost) {
		super();
		this.togetherMemberId = togetherMemberId;
		this.userId = userId;
		this.togetherId = togetherId;
		this.isHost = isHost;
	}
	
	public String getTogetherMemberId() {return togetherMemberId;}
	public void setTogetherMemberId(String togetherMemberId) {this.togetherMemberId = togetherMemberId;}
	
	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}
	
	public String getTogetherId() {return togetherId;}
	public void setTogetherId(String togetherId) {this.togetherId = togetherId;}
	
	public int getIsHost() {return isHost;}
	public void setIsHost(int isHost) {this.isHost = isHost;}

	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	
	@Override
	public String toString() {
		return "TogetherMember [togetherMemberId=" + togetherMemberId + ", togetherId=" + togetherId + ", userId="
				+ userId + ", user=" + user + "]";
	}
	
	
}
