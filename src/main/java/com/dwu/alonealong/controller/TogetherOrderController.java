package com.dwu.alonealong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.Order;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;
import com.dwu.alonealong.service.AloneAlongFacade;

@Controller
@SessionAttributes({"together"})
public class TogetherOrderController {

	private AloneAlongFacade aloneAlong;
	
	@Autowired
	public void setAlonealong(AloneAlongFacade aloneAlong) {
		this.aloneAlong = aloneAlong;
	}
	
	//신청하기	
	@RequestMapping(value = "/togetherOrder")
	public String joinTogether(HttpServletRequest request,
			@ModelAttribute("together") Together together) {
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		
		if(userSession == null) {
			return "redirect:/login";
		}
		
		return "together/togetherOrder";
//		return "togetherOrder";
	}
	
	//결제하기
	@RequestMapping("/togetherOrder/complete")
//	@PostMapping(value = "/togetherOrder/complete")
	public String orderTogether(
			HttpServletRequest request,
			@ModelAttribute("together") Together together,
			@RequestParam("cardName") String cardName,
			@RequestParam("cardNum") String cardNum,
			@RequestParam("cardDate1") String cardDate1,
			@RequestParam("cardDate2") String cardDate2,
			ModelMap model) {
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		User user = aloneAlong.getUserByUserId(userSession.getUser().getId());
		
		//카드 결제(호스트인 사람)
		if(together.getTogetherMemberList().get(0).getUserId().equals(user.getId())) {
			String orderId = aloneAlong.getTogetherOrderByTogId(together.getTogetherId()).get(0).getOrderId();
			
			System.out.println("결제 전");
			
			String orderDate = cardDate1 + "/" + cardDate2;
			Order newOrder = new Order(orderId, together.getPrice(), "결제완료", user.getId(), cardNum, orderDate, cardName);
			
			System.out.println("객체 생성?" + newOrder.toString());
			
			aloneAlong.updateTogetherOrderInfo(newOrder);
			
			System.out.println("결제 후");
			
		} 
		else { //(호스트 아닌 사람)
			//카드 결제
			String orderDate = cardDate1 + "/" + cardDate2;
			Order newOrder = new Order("ORDER_ID.NEXTVAL", together.getPrice(), "결제완료", user.getId(), cardNum, orderDate, cardName);
			aloneAlong.insertTogetherOrderInfo(newOrder);
			
			System.out.println("객체 생성?" + newOrder.toString());
			
			System.out.println("주문 목록 넣기 전");
			//주문목록에 넣기
			TogetherOrder togetherOrder = new TogetherOrder(newOrder.getOrderId(), together.getTogetherId());
			aloneAlong.insertTogetherOrder(togetherOrder);
			
			System.out.println("멤버 추가 전");
			//TogetherMember에 추가
			TogetherMember togetherMember = new TogetherMember("TOGMEM_ID.NEXTVAL", user.getId(), together.getTogetherId(), 0);
			aloneAlong.insertTogetherMember(togetherMember);
			
			System.out.println("멤버사이즈: " + together.getTogetherMemberList().size());
			//만약에 멤버 다찼으면 state -> 1, foodOrder에 들어가기
			if(together.getTogetherMemberList().size() + 1 == together.getHeadCount()) {
				Together newTogether = new Together(together.getTogetherId(), together.getTogetherName(), together.getHeadCount(), together.getTogetherDate(), together.getTogetherTime(), 
						together.getSex(), together.getAge(), together.getTogetherDes(), together.getResId(), 1, together.getPrice());
				aloneAlong.updateTogether(newTogether);
				
				System.out.println("음식 주문 추가 전");
				//foodOrder에 넣기
				for(int i = 0; i < together.getTogetherFoodList().size(); i++) {
					FoodOrder foodOrder = new FoodOrder(newOrder.getOrderId(), "visit", together.getTogetherDate() + "," + together.getTogetherTime(), 
							together.getTogetherFoodList().get(i).getFoodId(), together.getResId());
					aloneAlong.insertFoodOrderForTogetherOrder(foodOrder);
				}
			}
		}
		
		String togName = aloneAlong.getTogetherByTogId(together.getTogetherId()).getTogetherName();
		model.put("togName", togName);
		return "togOrderResult";
	}

}
