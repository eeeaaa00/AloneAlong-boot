package com.dwu.alonealong.domain;

public class TogetherMember {

	private String togetherMemberId;
	private User[] userLisrt;
	
	public TogetherMember() {
		
	}
	public String getTogetherMemberId() {
		return togetherMemberId;
	}
	public void setTogetherMemberId(String togetherMemberId) {
		this.togetherMemberId = togetherMemberId;
	}
	public User[] getUserLisrt() {
		return userLisrt;
	}
	public void setUserLisrt(User[] userLisrt) {
		this.userLisrt = userLisrt;
	}
	
	public void addUser(String userId) { //��� �߰� �޼ҵ�
		
	}
	
	public void removeUser(String userId) { //��� ���� �޼ҵ�
		
	}
	
}
