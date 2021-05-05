package com.dwu.alonealong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"productList"})
public class ViewProductListController {
	private AloneAlongFacade aloneAlong;

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	@RequestMapping("/shop")
	public String handleRequest(@RequestParam(value="page", defaultValue="1") String page, 
			@RequestParam(value="pcId",  defaultValue="fruit") String pcId, 
			@RequestParam(value="sortType",  defaultValue="latest") String sortType,
			ModelMap model) throws Exception {
		PagedListHolder<Product> productList = new PagedListHolder<Product>(this.aloneAlong.getProductList(pcId, sortType));
		productList.setPageSize(15);
		productList.setPage(Integer.parseInt(page));
		model.put("productList", productList);
		return "productList";
	}

}