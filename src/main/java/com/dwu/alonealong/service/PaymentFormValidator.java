package com.dwu.alonealong.service;

import java.sql.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dwu.alonealong.controller.PaymentForm;
import com.dwu.alonealong.controller.UserForm;
import com.dwu.alonealong.controller.UserSession;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.User;

@Component
public class PaymentFormValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return PaymentForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		PaymentForm paymentForm = (PaymentForm) obj;
		Payment payment = paymentForm.getPayment();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment.card_date", "DATE_REQUIRED", "유효기간을 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment.card_num", "NUM_REQUIRED", "카드 번호를 입력해주세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment.card_cvc", "CVC_REQUIRED", "카드 CVC를 입력해주세요.");

		if (payment.getCard_cvc().length() != 3) {
			errors.rejectValue("payment.card_cvc", "CVC_CHECK", "카드 CVC는 3글자입니다.");
		}

		if (payment.getCard_num().length() < 10) {
			errors.rejectValue("payment.card_num", "NUM_CHECK", "카드 번호는 10글자 이상입니다.");
		}

		String date = payment.getCard_date();
		String ds = "^\\d{2}/\\d{2}$";
		boolean regex = Pattern.matches(ds, date);
		if (!regex)
			errors.rejectValue("payment.card_date", "DATE_CHECK", "유효기간 형식은 MM/YY입니다.");

	}
}
