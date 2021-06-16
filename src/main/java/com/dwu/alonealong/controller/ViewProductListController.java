package com.dwu.alonealong.controller;

import java.util.List;

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
	String[] productCategory = {"소량 과일", "소량 채소", "소량 육류", "소량 식재료", "밀키트"};

	@Autowired
	public void setAloneAlong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
		
	@RequestMapping("/shop")
	public String handleRequest(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="pcId",  defaultValue="1") int pcId, 
			@RequestParam(value="sortType",  defaultValue="new") String sortType, //new, past, sales, lowPrice
			ModelMap model) throws Exception {
		List<Product> productList = this.aloneAlong.getProductList(pcId, sortType);
		PagedListHolder<Product> productPagedList = new PagedListHolder<Product>(productList);
		productPagedList.setPageSize(15);
		productPagedList.setPage(page - 1);
		
		String sortTypeName = "최신순";
		switch(sortType) {
			case "past" : sortTypeName = "과거순"; break;
			case "sales" : sortTypeName = "인기순"; break;
			case "lowPrice" : sortTypeName = "낮은 가격순"; break;
		}

		model.put("pcId", pcId);
		model.put("pcList", productCategory);
		model.put("sortTypeName", sortTypeName);
		model.put("productList", productPagedList);
		model.put("productCount", productList.size());
		
		model.put("page", productPagedList.getPage() + 1);
		model.put("startPage", (productPagedList.getPage() / 5) * 5 + 1);
		model.put("lastPage", productPagedList.getPageCount());
		return "productList";
	}

}