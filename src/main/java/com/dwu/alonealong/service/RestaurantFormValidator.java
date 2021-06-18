package com.dwu.alonealong.service;

import java.util.regex.Pattern;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.RestaurantForm;
import com.dwu.alonealong.domain.Restaurant;

public class RestaurantFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// 주어진 클래스 clazz 에 대한 검증 지원 여부 반환 (true/false)
		return Restaurant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// target 객체에 대한 검증 수행
		// 오류 발생 시 errors 객체에 오류 정보 저장
		RestaurantForm resForm = (RestaurantForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resName", "required", "*필수사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "required", "*필수사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resAddress", "required", "*필수사항입니다.");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resArea", "required", "*필수사항입니다.");
		
		if(resForm.getImgFile().isEmpty())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "img64", "required", "*첫 이미지는 필수입니다.");
		
		String phone = resForm.getResPhone();
		if(phone.length() == 0) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resPhone", "required", "*필수사항입니다.");
		}else {
			String ds = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
			boolean regex = Pattern.matches(ds, phone);
			if (!regex)
				errors.rejectValue("resPhone", "regex", "00(0)-000(0)-0000");
		}	
	}

}
