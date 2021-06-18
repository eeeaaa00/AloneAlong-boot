package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class ViewTestController {

	private AloneAlongFacade alonealong;

	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}

	@RequestMapping("/")
	public String now(HttpServletRequest request, ModelMap model) throws Exception {
		if ((UserSession) request.getSession().getAttribute("userSession") != null) {
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			User user = this.alonealong.getUserByUserId(userSession.getUser().getId());
			List<Together> recommandList = this.alonealong.recommandTogetherList(user.getSex(), user.getAddress());

			if (recommandList.isEmpty()) {
				List<Together> togetherList = this.alonealong.getTogetherList();
				model.put("togetherList", togetherList);

			} else {
				model.put("user", user);
				model.put("recommandList", recommandList);
			}
		} else {
			List<Together> togetherList = this.alonealong.getTogetherList();
			model.put("togetherList", togetherList);
		}

		String category1 = "지역";
		String category2 = "분류";
		String sortTypeName = "review";
		String sortTypeQuery = "RES_DATE";

		List<Restaurant> restaurantList = alonealong.getRestaurantListByCategory(category1, category2, sortTypeQuery);

		model.put("sortTypeName", sortTypeName);
		model.put("category1", category1);
		model.put("category2", category2);
		model.put("restaurantList", restaurantList);

		Encoder encoder = Base64.getEncoder();
		for (Restaurant res : restaurantList) {
			byte[] imagefile = res.getImgFile();
			if (imagefile == null)
				continue;
			String encodedString = encoder.encodeToString(imagefile);
			System.out.println("여기64: " + encodedString);
			res.setImg64(encodedString);
		}

		int pcId = 1;
		String sortType = "new";

		List<Product> productList = alonealong.getProductList(pcId, sortType);

		PagedListHolder<Product> productPagedList = new PagedListHolder<Product>(productList);

		encoder = Base64.getEncoder();
		for (Product product : productPagedList.getPageList()) {
			byte[] imagefile = product.getProductImg();
			if (imagefile == null)
				continue;
			String encodedString = encoder.encodeToString(imagefile);
			product.setImg64(encodedString);
		}
		model.put("pcId", pcId);
		model.put("productList", productList);
		model.put("sortTypeName", sortTypeName);
		model.put("productList", productList);

		return "index";
	}

	@RequestMapping("/product")
	public String product() {
		return "product";
	}

	@RequestMapping("/productOrderResult")
	public String orderSuccess(HttpServletRequest request, ModelMap model) {

		return "productOrderResult";
	}

	@RequestMapping("/resOrderResult")
	public String orderSuccess1(HttpServletRequest request, ModelMap model) {

		return "resOrderResult";
	}

//	@RequestMapping(value = "/shopping")
//	public ModelAndView productList() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productList");
//		return mav;
//	}

//	@RequestMapping(value = "/shopping/{id}")
//	public ModelAndView productInfo() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/product");
//		mav.setViewName("/product");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/shopping/{id}/review")
//	public ModelAndView productReview() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productReview");
//		mav.setViewName("/productReview");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/shopping/cart")
//	public ModelAndView productCart() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/shopping/productCart");
//		return mav;
//	}

	@RequestMapping(value = "/shopping")
	public String productList() {
		return "productList";
	}

	@RequestMapping(value = "/shopping/{id}")
	public String productInfo() {
		return "product";
	}

	@RequestMapping(value = "/shopping/{id}/review")
	public String productReview() {
		return "productReview";
	}

	@RequestMapping(value = "/shopping/cart")
	public String productCart() {
		return "productCart";
	}

	@RequestMapping(value = "/order")
	public ModelAndView order() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order");
		return mav;
	}

	@RequestMapping(value = "/orderTest")
	public String orderTest() {
		return "order_layout";
	}

	@RequestMapping(value = "/productOrderTest")
	public String productOrderTest() {
		return "productOrder";
	}

//	@RequestMapping(value = "/togetherOrderTest")
//	public String togetherOrderTest() {
//		return "togetherOrder";
//	}

	@RequestMapping(value = "/foodOrderTest")
	public String foodOrderTest() {
		return "foodOrder";
	}
}
