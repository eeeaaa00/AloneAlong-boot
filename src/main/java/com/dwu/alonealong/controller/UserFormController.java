package com.dwu.alonealong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.dwu.alonealong.service.AloneAlongFacade;


/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */

@Controller
@RequestMapping({ "/signUp", "/mypage" })
public class UserFormController {

	@Value("myEditForm")
	private String formViewName;
	
	@Value("login")
	private String successViewName;
	private static final String[] SEX = {"여", "남"};
	

	@Autowired
	private AloneAlongFacade alonealong;

	@Autowired
	public void setPetStore(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	@ModelAttribute("sex")
	public String[] getLanguages() {
		return SEX;
	}
	/*
	 * @Autowired private AccountFormValidator validator; public void
	 * setValidator(AccountFormValidator validator) { this.validator = validator; }
	 */
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		if (userSession != null) { // edit an existing account 
			return new UserForm(
			alonealong.getUserByUserId(userSession.getUser().getId()));
		} else {
			/// create a new account
			return new UserForm();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result) throws Exception {

		// validator.validate(accountForm, result);

		if (result.hasErrors()) {
			System.out.print("");
			return formViewName;
		}
		try {
			if (userForm.isNewUser()) {
				alonealong.createUser(userForm.getUser());
			} else {
				alonealong.updateUser(userForm.getUser());
			}
		} catch (DataIntegrityViolationException ex) {
			//result.rejectValue("user.name", "USER_ID_ALREADY_EXISTS",
			//		"User ID already exists: choose a different ID.");
			return formViewName;
		}
		
		System.out.print(alonealong.getUserByUserId(
				userForm.getUser().getId()));

		UserSession userSession = new UserSession(alonealong.getUserByUserId(
				userForm.getUser().getId()));
		
		
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
}
