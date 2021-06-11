package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"together"})
public class ViewTogetherController {

	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setPetStore(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}

	@RequestMapping("/together/{togetherId}")
	public String viewTogether(
			@PathVariable("togetherId") String togId, 
			ModelMap model) throws Exception {
		Together together = this.aloneAlong.getTogetherByTogId(togId);
		model.put("together", together);
		return "togetherInfo";
	}
}
