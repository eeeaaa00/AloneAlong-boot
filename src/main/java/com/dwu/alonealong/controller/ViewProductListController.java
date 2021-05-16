package com.dwu.alonealong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/shop")
	public String insertCartItem(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="pcId", required=false, defaultValue="1") int pcId, 
			@RequestParam(value="sortType",  defaultValue="new") String sortType,
			@RequestParam(value="productId") String productId,
			ModelMap model) throws Exception {
		String userId = "1";
		List<Product> productList = this.aloneAlong.getProductList(pcId, sortType);
		aloneAlong.insertCartItem(productId, 1, userId);

		String sortTypeName = "최신순";
		switch(sortType) {
			case "past" : sortTypeName = "과거순"; break;
			case "sales" : sortTypeName = "인기순"; break;
			case "lowPrice" : sortTypeName = "낮은 가격순"; break;
		}

		model.put("pcId", pcId);
		model.put("pcList", productCategory);
		model.put("productList", productList);
		model.put("sortTypeName", sortTypeName);
		model.put("insertCart", true);
		return "productList";
	}
	
	@GetMapping("/shop")
	public String handleRequest(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="pcId",  defaultValue="1") int pcId, 
			@RequestParam(value="sortType",  defaultValue="new") String sortType, //new, past, sales, lowPrice
			ModelMap model) throws Exception {
		List<Product> productList = this.aloneAlong.getProductList(pcId, sortType);
//		PagedListHolder<Product> productList = new PagedListHolder<Product>(this.aloneAlong.getProductList(pcId, sortType));
//		productList.setPageSize(15);
//		productList.setPage(page);
		String sortTypeName = "최신순";
		switch(sortType) {
			case "past" : sortTypeName = "과거순"; break;
			case "sales" : sortTypeName = "인기순"; break;
			case "lowPrice" : sortTypeName = "낮은 가격순"; break;
		}

		model.put("pcId", pcId);
		model.put("pcList", productCategory);
		model.put("sortTypeName", sortTypeName);
		model.put("productList", productList);
		return "productList";
	}

}