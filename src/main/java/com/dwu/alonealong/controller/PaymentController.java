package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.service.AloneAlongFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */

@Controller
@RequestMapping({ "/myCredit"})
public class PaymentController {
	
	
	@Value("myPayForm")
	private String resultForm;
	
	private static final String[] bank = { "농협", "국민", "신한", "우리", "기업", "SC제일", "카카오뱅크", "새마을금고"};

	@Autowired
	private AloneAlongFacade alonealong;

	@Autowired
	public void setAlongAlone(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}

	@ModelAttribute("bank")
	public String[] getBank() {
		return bank;
	}

	/*
	 * @Autowired private AccountFormValidator validator; public void
	 * setValidator(AccountFormValidator validator) { this.validator = validator; }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return resultForm;
	}

	@ModelAttribute("paymentForm")
	public PaymentForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		String id = userSession.getUser().getId();
		
		Payment pay = alonealong.getCard(id);
	
		if(pay != null) { // edit an existing Card
			return new PaymentForm(pay);
		} else {
			return new PaymentForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("paymentForm") PaymentForm payForm, BindingResult result) throws Exception {

		try {
			if (payForm.isNewPayment()) {
				alonealong.createCard(payForm.getPayment());
			} else {
				alonealong.updateCard(payForm.getPayment());
			}
		} catch (DataIntegrityViolationException ex) {
			return resultForm;
		}
		
		return resultForm;
	}
}
