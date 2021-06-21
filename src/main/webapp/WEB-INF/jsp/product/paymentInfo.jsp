<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
function samePayment(s){
	var bank = ["농협", "국민", "신한", "우리", "기업", "SC제일", "카카오뱅크", "새마을금고"];
	
	if(s.checked){
		document.getElementById("cardName").options[bank.indexOf("${orderForm.getPayment().getCard_name()}")].selected = true;
		document.getElementById("cardNum").value = "${orderForm.getPayment().getCard_num()}";
		document.getElementById("cardMonth").value = "${orderForm.getPayment().getCard_month()}";
		document.getElementById("cardYear").value = "${orderForm.getPayment().getCard_year()}";
		document.getElementById("cardCVC").value = "${orderForm.getPayment().getCard_cvc()}";
	}
	else{
		document.getElementById("cardNum").value = "";
		document.getElementById("cardYear").value = "";
		document.getElementById("cardMonth").value = "";
		document.getElementById("cardCVC").value =  "";
	}
}
</script>

<div class="mb-5 pb-5 border-bottom pr-5">
	<h4 class="mx-2 mb-3">결제 정보</h4>
	<div class="mb-3 text-right custom-control custom-checkbox">
		<input type="checkbox" class="custom-control-input" id="same-payment" onClick="samePayment(this)">
	<label class="custom-control-label" for="same-payment">등록된 결제정보 사용</label>
	</div>
	<div class="row w-100 mx-2 mb-3 no-gutters">
		<label for="cardname" class="col-4 col-form-label">카드 이름</label>
		<div class="col-8">
			<form:select path="order.cardName" id="cardName" name="cardName" class="custom-select">
				<form:option value="농협">농협</form:option>
				<form:option value="국민">국민</form:option>
				<form:option value="신한">신한</form:option>
				<form:option value="우리">우리</form:option>
				<form:option value="기업">기업</form:option>
				<form:option value="SC제일">SC제일</form:option>
				<form:option value="카카오뱅크">카카오뱅크</form:option>
				<form:option value="새마을금고">새마을금고</form:option>
			</form:select>
		</div>
	</div>
	<div class="row w-100 mx-2 mb-3 no-gutters">
		<label for="cardNum" class="col-4 col-form-label">카드 번호</label>
		<div class="col-8">
			<form:input path="order.cardNum" id="cardNum" name="cardNum" placeholder="카드 번호"
				class="form-control here" type="text"  maxlength="30"/>
				<B style="color: #FF0000;"><form:errors path="order.cardNum" cssClass="error" /></B>
		</div>
	</div>
	<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
		<label class="col-4 col-form-label">카드 정보</label>
		<div class="row col-8 no-gutters">
			<div class="col-6">
				<div class="input-group">
				<form:input path="order.cardMonth" id="cardYear" name="cardMonth" placeholder="MM"
					class="form-control" maxlength="2" type="text"/>
				<form:input path="order.cardYear" id="cardMonth" name="cardYear" placeholder="YY"
					class="form-control " maxlength="2" type="text"/>
				</div>
				<B style="color: #FF0000;"><form:errors path="order.cardMonth" cssClass="error" /></B>
				<B style="color: #FF0000;"><form:errors path="order.cardYear" cssClass="error" /></B>
			</div>
			<div class="col-1"></div>
			<div class="col-5">
				<form:input path="order.cardCVC" placeholder="CVC" class="form-control" type="text"/>
				<B style="color: #FF0000;"><form:errors path="order.cardCVC" cssClass="error" /></B>
			</div>
		</div>
	</div>
</div>
<div class="row mx-5 mb-5 pb-5 justify-content-end">
	<div class="col-md-3 text-right align-self-end">
		합계 <span class="text-orange-roboto text-roboto pl-1"> <fmt:formatNumber
				value="${totalPrice}" pattern="#,###,###" /></span>원
	</div>
	<div class="col-md-6">
		<form:hidden path="type" value="${type}"/>
		<button type="submit" class="btn btn-orange btn-block rounded-pill py-3 my-1 mt-3 mx-3">
			<small><i class="far fa-credit-card pr-1"></i></small> 결제하기
		</button>
	</div>
</div>