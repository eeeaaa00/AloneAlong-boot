package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"togetherList"})
public class ViewTogetherListController {
	
	private AloneAlongFacade alonealong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}
	
	//같이먹기 리스트
	@RequestMapping("/together")
	public String listTogether(
			ModelMap model
			) throws Exception {
		List<Together> togetherList = this.alonealong.getTogetherList();
//		PagedListHolder<Together> togetherList = new PagedListHolder<Together>(this.alonealong.getTogetherList());
//		togetherList.setPageSize(4);
		model.put("togetherList", togetherList);
		return "togetherList";
	}
	
	//같이먹기 리스트 카테고리
//	@RequestMapping("/together")
//	public String listTogetherByCategory(ModelMap model) throws Exception {
//		PagedListHolder<Together> togetherList = new PagedListHolder<Together>(this.alonealong.getTogetherList());
//		togetherList.setPageSize(4);
//		model.put("togetherList", togetherList);
//		return "together/togetherList";
//	}
}
