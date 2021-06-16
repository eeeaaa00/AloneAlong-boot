package com.dwu.alonealong.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.UserForm;
import com.dwu.alonealong.domain.User;

@Component
public class UserFormValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		UserForm userForm = (UserForm)obj; 
		User user = userForm.getUser();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.id", "아이디가 필요합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.pw", "비밀번호가 필요합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.name", "이름을 입력해야합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.nickname", "닉네임을 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "이메일을 입력해주세요");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.phone", "전화번호를 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.birthday", "생년월일을 지정해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.address", "주소를 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.zip", "우편번호를 입력해주세요.");
		
		if (userForm.isNewUser()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.id", "User ID is required.");
			if (user.getPw() == null || user.getPw().length() < 1 ||
					!user.getPw().equals(userForm.getRepeatedPassword())) {
				errors.rejectValue("repeatedPassword",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (user.getPw() != null && user.getPw().length() > 0) {
			if (!user.getPw().equals(userForm.getRepeatedPassword())) {
				System.out.print(user.getPw()+"~~~~~~~~~~");
				System.out.print(userForm.getRepeatedPassword()+"!!!!!!!!!!!!");
				errors.rejectValue("repeatedPassword",
						 "안됩니다");}
		}
	}
}

