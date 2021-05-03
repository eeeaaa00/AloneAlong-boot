package com.dwu.alonealong.domain;
import java.io.Serializable;
	@SuppressWarnings("serial")
	public class User implements Serializable {
		private String password;
		private String name;
		private String email;
		private String sex;
		private String birthday;
		private String address;
		private String state;
		private String zip;
		private String phone;
		private String buisnessNum;
		/* Private Fields */
		private String userId;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
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
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
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
