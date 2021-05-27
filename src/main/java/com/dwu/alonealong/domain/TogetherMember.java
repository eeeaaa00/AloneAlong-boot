package com.dwu.alonealong.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TogetherMember implements Serializable {

	private String togetherMemberId;
	private String togetherId;
	private String userId;
	private int isHost;
	private User user;
	
	public TogetherMember() { }
	
	public String getTogetherMemberId() {return togetherMemberId;}
	public void setTogetherMemberId(String togetherMemberId) {this.togetherMemberId = togetherMemberId;}
	
	public String getTogetherId() {return togetherId;}
	public void setTogetherId(String togetherId) {this.togetherId = togetherId;}
	
	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}
	
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
