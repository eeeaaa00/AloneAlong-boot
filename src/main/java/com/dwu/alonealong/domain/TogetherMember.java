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
	
	public void addUser(String userId) { //멤버 추가 메소드
		
	}
	
	public void removeUser(String userId) { //멤버 삭제 메소드
		
	}
	
}
