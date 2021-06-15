package com.dwu.alonealong.domain;
import java.io.Serializable;
import java.sql.Date;
	@SuppressWarnings("serial")
	public class User implements Serializable {
		private String user_id;
		private String pw;
		private String name;
		private String nickname;
		private String email;
		private String sex;
		private Date birthday;
		private String address;
		private String state;
		private int zip;
		private String phone;
		private String buisnessNum;
		
		public String getId() {
			return user_id;
		}
		public void setId(String id) {
			this.user_id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getZip() {
			return zip;
		}
		public void setZip(int zip) {
			this.zip = zip;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getBuisnessNum() {
			return buisnessNum;
		}
		public void setBuisnessNum(String buisnessNum) {
			this.buisnessNum = buisnessNum;
		}
		/* JavaBeans Properties */
	}
