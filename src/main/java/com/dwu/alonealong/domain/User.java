package com.dwu.alonealong.domain;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.springframework.format.annotation.DateTimeFormat;
	@SuppressWarnings("serial")
	public class User implements Serializable {
		private String user_id;
		private String pw;
		private String name;
		private String nickname;
		private String email;
		private String sex;
		@DateTimeFormat(pattern="yyyy/MM/dd")
		private Date birthday;
		private String address;
		private String state;
		private String zip;
		private String phone;
		private String business_num;
		
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		public String getM() {
			return m;
		}
		public void setM(String m) {
			this.m = m;
		}
		public String getD() {
			return d;
		}
		public void setD(String d) {
			this.d = d;
		}
		private String y;
		private String m;
		private String d;
		
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
		public Date getBirthday() throws ParseException {
			String birth = this.y +"/"+this.m+"/"+ this.d;
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			birthday = format.parse(birth);
			return birthday;
		}
		public void setBirthday(Date birthday) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String str = format.format(birthday);
			StringTokenizer itr = new StringTokenizer(str,"/");
			y = itr.nextToken();
			m = itr.nextToken();
			d = itr.nextToken();
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
		public String getBusiness_num() {
			return business_num;
		}
		public void setBusiness_num(String business_num) {
			this.business_num = business_num;
		}
		
		/* JavaBeans Properties */
	}
