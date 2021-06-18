package com.dwu.alonealong.service;

import java.sql.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.ProductOrderForm;
import com.dwu.alonealong.controller.UserForm;
import com.dwu.alonealong.controller.UserSession;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.User;

@Component
public class ProductOrderFormValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		ProductOrderForm productOrderForm = (ProductOrderForm) obj;
		ProductOrder productOrder = productOrderForm.getOrder();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shipName", "NAME_REQUIRED", "배송자 성함을 입력해주세요.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shipPhone2", "SHIPPHONE2_REQUIRED", "전화번호를 모두 입력해주세요.");
		if(productOrder.getShipPhone2().length() != 0) {
			String ds = "\\d{3,4}";
			boolean regex1 = Pattern.matches(ds, productOrder.getShipPhone2());
			if (!regex1) {
				errors.rejectValue("order.shipPhone2", "regex1", "올바른 전화번호를 입력하세요.");
			}
			else {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shipPhone3", "SHIPPHONE3_REQUIRED", "전화번호를 모두 입력해주세요.");
				if(productOrder.getShipPhone3().length() != 0) {
					boolean regex2 = Pattern.matches(ds, productOrder.getShipPhone3());
					if (!regex2) {
						errors.rejectValue("order.shipPhone3", "regex2", "올바른 전화번호를 입력하세요.");
					}
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shipZip", "SHIPZIP_REQUIRED", "우편번호를 입력해주세요.");
		if(productOrder.getShipZip().length() != 0) {
			String ds = "\\d{5}";
			boolean regex3 = Pattern.matches(ds, productOrder.getShipZip());
			if (!regex3) {
				errors.rejectValue("order.shipZip", "regex3", "우편번호 숫자 5자리를 입력해주세요.");
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shipAddress", "SHIPADDRESS_REQUIRED", "배송받을 주소를 입력해주세요.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardNum", "CARDNUM_REQUIRED", "카드번호를 입력해주세요.");
		if(productOrder.getCardNum().length() != 0) {
			String ds = "\\d{10,20}";
			boolean regex4 = Pattern.matches(ds, productOrder.getCardNum());
			if (!regex4) {
				errors.rejectValue("order.cardNum", "regex4", "올바른 카드번호를 입력하세요.");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardMonth", "CARDMONTH_REQUIRED", "카드 날짜를 입력해주세요.");
		if(productOrder.getCardMonth().length() != 0) {
			String ds = "\\d{2}";
			boolean regex5 = Pattern.matches(ds, productOrder.getCardMonth());
			if (!regex5) {
				errors.rejectValue("order.cardMonth", "regex5", "올바른 카드 날짜를 입력하세요.");
			}
			else {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardYear", "CARDYEAR_REQUIRED", "카드 날짜를 입력해주세요.");
				if(productOrder.getCardYear().length() != 0) {
					boolean regex6 = Pattern.matches(ds, productOrder.getCardYear());
					if (!regex6) {
						errors.rejectValue("order.cardYear", "regex6", "올바른 카드 날짜를 입력하세요.");
					}
				}
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardCVC", "CARDCVC_REQUIRED", "CVC번호를 입력해주세요.");
		if(productOrder.getCardCVC().length() != 0) {
			String ds = "\\d{3}";
			boolean regex7 = Pattern.matches(ds, productOrder.getCardCVC());
			if (!regex7) {
				errors.rejectValue("order.cardCVC", "regex7", "세자리 숫자의 CVC번호를 입력하세요.");
			}
		}
		
	}
}
