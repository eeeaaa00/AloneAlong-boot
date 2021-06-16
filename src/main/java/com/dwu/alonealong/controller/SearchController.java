package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class SearchController {

	private AloneAlongFacade alonealong;

	@Autowired
	public void setAlonealong(AloneAlongFacade alonealong) {
		this.alonealong = alonealong;
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request, @RequestParam("keyword") String keyword, ModelMap model)
			throws Exception {

			// 상품 검색
			List<Product> productList = this.alonealong.searchProductList(keyword);
			model.put("productList", productList);

			// 식당 검색
			List<Restaurant> restaurantList = alonealong.searchRestaurantList(keyword);
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

			// 함먹 검색
			List<Together> togetherList = alonealong.searchTogetherList(keyword);
			model.put("togetherList", togetherList);
			// System.out.print(togetherList.get(0).getTogetherMemberList().get(0)+"!!");

			
			// 검색 갯수 반환
			String resCnt = Integer.toString(restaurantList.size());
			String productCnt = Integer.toString(productList.size());
			String togCnt = Integer.toString(togetherList.size());

			String totalCnt = Integer.toString(restaurantList.size() + productList.size() + togetherList.size());

			if(keyword.equals(""))
				totalCnt = "-1";
			
			model.put("productCnt", productCnt);
			model.put("resCnt", resCnt);
			model.put("togCnt", togCnt);
			model.put("totalCnt", totalCnt);
			model.put("keyword", keyword);
		

		return "search";
	}
}
