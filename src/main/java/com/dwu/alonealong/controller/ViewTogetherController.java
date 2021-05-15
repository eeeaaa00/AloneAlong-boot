package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class ViewTogetherController {

	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setPetStore(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}

	@RequestMapping("/togetherInfo/{id}")
	public String viewTogether(/*@RequestParam("togId") String togId,
			ModelMap model*/) throws Exception {
//		Together together = this.aloneAlong.getTogetehr(togId);
//		model.put("together", together);
		return "togetherInfo";
	}
}
