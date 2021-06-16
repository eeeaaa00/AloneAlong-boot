package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@ModelAttribute("together")
	public Together createTogether(HttpSession session) {
		Together together = (Together)session.getAttribute("together");
		together = new Together();
		return together;
	}

	@RequestMapping("/together/{togetherId}")
	public String viewTogether(
			@PathVariable("togetherId") String togId,
			@RequestParam(value="area",  defaultValue="all") String area,
			@RequestParam(value="date",  defaultValue="") String date,
			@RequestParam(value="kind",  defaultValue="all") String kind,
			@RequestParam(value="price",  defaultValue="99999") int price,
			@RequestParam(value="sex",  defaultValue="all") String sex,
			@RequestParam(value="age",  defaultValue="all") String age,
			ModelMap model) throws Exception {
		Together together = this.aloneAlong.getTogetherByTogId(togId);
		
		//이미지
//		Encoder encoder = Base64.getEncoder();
//		byte[] imagefile = together.getRestaurant().getImgFile();
//    	
//        String encodedString = encoder.encodeToString(imagefile);
//        System.out.println("여기64: " + encodedString);
//        together.getRestaurant().setImg64(encodedString);
		
		
		//카테고리
		String areaName = "모든 지역";
		switch(area) {
			case "seoul" : areaName = "서울특별시"; break;
			case "busan" : areaName = "부산광역시"; break;
			case "incheon" : areaName = "인천광역시"; break;
			case "deagu" : areaName = "대구광역시"; break;
			case "deageon" : areaName = "대전광역시"; break;
			case "guangju" : areaName = "광주광역시"; break;
			case "ulsan" : areaName = "울산광역시"; break;
		}
		
		String kindName = "모든 종류 음식";
		switch(kind) {
			case "korean" : kindName = "한식"; break;
			case "western" : kindName = "양식"; break;
			case "japanese" : kindName = "일식"; break;
			case "chinese" : kindName = "중식"; break;
			case "etc" : kindName = "기타"; break;
		}
		
		String priceName = "모든 가격대";
		switch(price) {
			case 10000 : priceName = "10000원 미만"; break;
			case 15000 : priceName = "15000원 미만"; break;
			case 20000 : priceName = "20000원 미만"; break;
			case 25000 : priceName = "25000원 미만"; break;
			case 35000 : priceName = "30000원 미만"; break;
		}
		
		String sexName = "모든 성별";
		switch(sex) {
			case "female" : sexName = "여성"; break;
			case "male" : sexName = "남성"; break;
		}
		
		String ageName = "모든 나이";
		switch(age) {
			case "10" : ageName = "10대"; break;
			case "20" : ageName = "20대"; break;
			case "30" : ageName = "30대"; break;
			case "40" : ageName = "40대"; break;
			case "50" : ageName = "50대 이상"; break;
		}
		
		model.put("areaName", areaName);
		model.put("kindName", kindName);
		model.put("priceName", priceName);
		model.put("sexName", sexName);
		model.put("ageName", ageName);
		
		model.put("area", area);
		model.put("date", date);
		model.put("kind", kind);
		model.put("price", price);
		model.put("sex", sex);
		model.put("age", age);
		
		model.put("together", together);
		return "togetherInfo";
	}
}
