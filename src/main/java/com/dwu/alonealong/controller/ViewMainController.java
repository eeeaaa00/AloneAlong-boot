package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
public class ViewMainController {

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

			if(recommandList.isEmpty()) {
				List<Together> togetherList = this.alonealong.getTogetherList();
				model.put("togetherList", togetherList);
			}
			
			model.put("user", user);
			model.put("recommandList", recommandList);
		}
		else {
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
			res.setImg64(encodedString);
		}

		int pcId = 1;
		String sortType = "new";
		List<Product> productList = alonealong.getProductList(pcId, sortType);
		model.put("pcId", pcId);
		model.put("productList", productList);
		model.put("sortTypeName", sortTypeName);
		model.put("productList", productList);
		return "index";
	}

	@RequestMapping(value = "/contact")
	public String handleRequest(HttpServletRequest request,
			@RequestParam(value="contents") String contents,
			ModelMap model) throws Exception {
		alonealong.insertContact(contents);
		String refererURL = request.getHeader("referer");
		if(refererURL != null) {
			return "redirect:" + refererURL;
		}
		else {
			return "redirect:/";
		}
	}
}
