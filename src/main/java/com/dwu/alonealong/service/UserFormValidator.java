package com.dwu.alonealong.service;

import java.sql.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.UserForm;
import com.dwu.alonealong.controller.UserSession;
import com.dwu.alonealong.domain.User;

@Component
public class UserFormValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		UserForm userForm = (UserForm) obj;
		User user = userForm.getUser();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.id", "ID_REQUIRED", "아이디가 필요합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.name", "NAME_REQUIRED", "이름을 입력해야합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.nickname", "NICKNAME_REQUIRED", "닉네임을 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "EMAIL_REQUIRED", "이메일을 입력해주세요");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.phone", "PHONE_REQUIRED", "전화번호를 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.birthday", "BIRTH_REQUIRED", "생년월일을 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.address", "ADDRESS_REQUIRED", "주소를 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.zip", "ZIP_REQUIRED", "우편번호를 입력해주세요.");

		
		if (user.getBusiness_num().length() != 0) {
			String bs = "^\\d{3}-\\d{2}-\\d{5}$";
			boolean regex = Pattern.matches(bs, user.getBusiness_num());
			if (!regex)
				errors.rejectValue("user.business_num", "BUSINESSNUM_CHECK", "사업자번호 형식은 000-00-00000입니다.");
		}
		
		
		if (user.getPhone().length() != 0) {
			String ps = "^01(?:0|1|[6-9])-(?:\\d{4})-\\d{4}$";
			boolean regex1 = Pattern.matches(ps, user.getPhone());
			if (!regex1)
				errors.rejectValue("user.phone", "PHONE_CHECK", "전화번호 형식은 000-0000-0000입니다.");
		}
		if (user.getEmail().length() != 0) {
			String es = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
			boolean regex2 = Pattern.matches(es, user.getEmail());
			if (!regex2)
				errors.rejectValue("user.email", "EMAIL_CHECK", "이메일 형식은 alonealong@alongalong.com입니다.(예시)");
		}

		if (user.getPw() == null || user.getPw().length() < 1 || !user.getPw().equals(userForm.getRepeatedPassword())) {
			errors.rejectValue("repeatedPassword", "PASSWORD_MISMATCH", "비밀번호를 다시 확인해주세요.");
		} else {
			if (user.getPw() != null && user.getPw().length() > 0) {
				if (!user.getPw().equals(userForm.getRepeatedPassword())) {
					errors.rejectValue("repeatedPassword", "PASSWORD_MISMATCH", "비밀번호를 다시 확인해주세요.");
				}
			}
		}
	}
}
