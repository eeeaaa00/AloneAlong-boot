package com.dwu.alonealong.service;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.FoodForm;


public class FoodFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// 주어진 클래스 clazz 에 대한 검증 지원 여부 반환 (true/false)
		return FoodForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// target 객체에 대한 검증 수행
		// 오류 발생 시 errors 객체에 오류 정보 저장
		FoodForm foodForm = (FoodForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "*필수사항입니다.");
		
		if(foodForm.getImgFile().isEmpty())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "img64", "required", "*첫 이미지는 필수입니다.");

	}

}
