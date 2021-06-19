package com.dwu.alonealong.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;
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
	public String viewTogether(HttpServletRequest request,
			@PathVariable("togetherId") String togId,
			@RequestParam(value="area",  defaultValue="all") String area,
			@RequestParam(value="date",  defaultValue="") String date,
			@RequestParam(value="kind",  defaultValue="all") String kind,
			@RequestParam(value="price",  defaultValue="99999") int price,
			@RequestParam(value="sex",  defaultValue="all") String sex,
			@RequestParam(value="age",  defaultValue="all") String age,
			ModelMap model) throws Exception {
		Together together = this.aloneAlong.getTogetherByTogId(togId);
		
		//수정, 삭제, 신청 접근 조건
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		boolean isUserNull = false; //로그인 여부
		boolean isHost = false; //호스트 여부
		boolean ifEditPossible = false; //수정 삭제 가능 여부
		boolean alreadyApply = false; //이미 신청했는지 여부
		boolean isPaid = false; //결제 여부
		boolean ifCanApply = false; //신청 조건 맞는지 여부
		
		if(userSession != null) {
			isUserNull = true;
			User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
			
			if(together.getTogetherMemberList().get(0).getUserId().equals(user.getId())) { //호스트 여부
				isHost = true;
				
				TogetherOrder togetherOrder = aloneAlong.getTogetherOrderByTogId(togId).get(0);
				if(togetherOrder.getOrder().getStatus().equals("결제완료")) //결제 여부
					isPaid = true;
				
				if(together.getTogetherMemberList().size() == 1) //수정 삭제 가능 여부
					ifEditPossible = true;
			} else {
				for(int i= 0; i < together.getTogetherMemberList().size(); i++) { //이미 신청했는지 여부
					if(together.getTogetherMemberList().get(i).getUserId().equals(user.getId()))
						alreadyApply = true;
				}
				if(alreadyApply == false) { //신청 조건 맞는지 여부(성별 조건만)
					if(user.getSex().equals(together.getSex()) || together.getSex().equals("상관없음"))
						ifCanApply = true;
				}
			}	
		}
		
		model.put("isUserNull", isUserNull);
		model.put("isHost", isHost);
		model.put("isPaid", isPaid);
		model.put("ifEditPossible", ifEditPossible);
		model.put("alreadyApply", alreadyApply);
		model.put("ifCanApply", ifCanApply);
		
		//이미지
		Encoder encoder = Base64.getEncoder();
		byte[] imagefile = together.getRestaurant().getImgFile();
    	
        String encodedString = encoder.encodeToString(imagefile);
        together.getRestaurant().setImg64(encodedString);
		
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
