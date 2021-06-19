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
import com.dwu.alonealong.service.UserFormValidator;

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
	private String successCreateName;

	private static final String[] SEX = { "여성", "남성" };

	@Autowired
	private AloneAlongFacade alonealong;

	@Autowired
	public void setAlongAlone(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}

	@ModelAttribute("sex")
	public String[] getSex() {
		return SEX;
	}


	@Autowired
	private UserFormValidator validator;

	public void setValidator(UserFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		if (userSession != null) { // edit an existing account
			return new UserForm(alonealong.getUserByUserId(userSession.getUser().getId()));
		} else {
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

		validator.validate(userForm, result);

		if (result.hasErrors())
			return formViewName;
		try {
			if (userForm.isNewUser()) {
				alonealong.createUser(userForm.getUser());
				System.out.print("성공");
			} else {
				alonealong.updateUser(userForm.getUser());
			}
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("user.id", "이미 존재하는 ID입니다. 다른 ID를 설정해주세요.");
			return formViewName;
		}

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		if (userSession != null) {
			if (alonealong.getUserByUserId(userSession.getUser().getId()).getBusiness_num() != null) {
				String businum = alonealong.getUserByUserId(userSession.getUser().getId()).getBusiness_num();
				session.setAttribute("businum", businum);
			} else {
				session.removeAttribute("businum");
			}		
			return "redirect:/";
		} else {
			return successCreateName;
		}
	}
}
