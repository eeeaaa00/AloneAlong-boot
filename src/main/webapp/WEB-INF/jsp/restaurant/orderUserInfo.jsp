<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
$(document).ready(function() {
	console.log("cardName", "${payment.card_name}");
	$("#ccName").val("${payment.card_name}").attr("selected", "selected");
	$("#ccNum").val("${payment.card_num}");
	
	var date = '${payment.card_date}'.split("/");
	$("#ccDateYY").val(date[0]);
	$("#ccDateMM").val(date[1]);
	$("#ccCVC").val("${payment.card_cvc}");
	
	var date = new Date();
    var day = date.getDate() + 1;
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;
    var today = year + "-" + month + "-" + day;     
    $("#visitDate").attr("min", today);

});
function getData() {
	$("#ccName").val("${payment.card_name}").prop("selected", true);
	$("#ccNum").val("${payment.card_num}");
	
	var date = '${payment.card_date}'.split("/");
	$("#ccDateYY").val(date[0]);
	$("#ccDateMM").val(date[1]);
	$("#ccCVC").val("${payment.card_cvc}");
}




</script>
	  <form:form modelAttribute="foodOrderForm" action="/eating/order/confirm" class="needs-validation" novalidate="">
    	<div class="mb-5 pb-5 border-bottom">
	      <h4 class="mb-4">주문 정보</h4>
	        <div class="d-block my-3">
	          <div class="custom-control custom-radio">
	            <input id="visit" value = "visit" name="reserveType" type="radio" class="custom-control-input" checked="" required="">
	            <label class="custom-control-label" for="visit">방문 예약</label>
	          </div>
	          <div class="custom-control custom-radio">
	            <input id="packing" value = "packing" name="reserveType" type="radio" class="custom-control-input" required="">
	            <label class="custom-control-label" for="packing">포장 예약</label>
	          </div>
	        </div>
	        
	        <div class="row w-50 mx-2 mb-3">
	          <label for="visitDate">예약 날짜</label>
	          <input type="date" class="form-control" id="visitDate" name = "visitDate" required>
	          <input type="time" class="form-control" id="visitDate" name = "visitDate" required>
	        </div> 
	           
			<div class="row w-50 mx-2 ">
	          <label for="phone">전화번호</label>
	          <div class="row w-50 mx-2 mb-3 input-group">
	          	${user.phone}
	          </div>
	        </div>
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">이메일</label>
	          <div class="row w-50 mx-2 mb-3 input-group">
	          	${user.email}
	          </div>
	        </div>
	
        <hr class="mb-4">

        <div class="row"><h4 class="mx-2 mb-5">결제 정보</h4> 
        <a type="button" id="getData" onclick="getData()" style="font-size: smaller;"><i class="far fa-address-card"></i> 불러오기</a></div>
        
			<div class="row w-100 mx-2 mb-3 no-gutters">
			
				<label for="cardname" class="col-4 col-form-label">카드 이름</label>
				<div class="col-8">
					<select id="ccName" name="ccName" class="custom-select">
						<option value="농협">농협</option>
						<option value="국민">국민</option>
						<option value="신한">신한</option>
						<option value="우리">우리</option>
						<option value="기업">기업</option>
						<option value="SC제일">SC제일</option>
						<option value="카카오뱅크">카카오뱅크</option>
						<option value="새마을금고">새마을금고</option>
					</select>
				</div>
			</div>
        <div class="row w-100 mx-2 mb-3 no-gutters">
			<label for="cardNum" class="col-4 col-form-label">카드 번호</label>
			<div class="col-8">
				<input id="ccNum" name="ccNum" placeholder="카드 번호"
					class="form-control here" required="required" type="text">
			</div>
		</div>
		<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
			<label class="col-4 col-form-label">카드 정보</label>
			<div class="row col-8 no-gutters">
				<div class="col-6 input-group">
					<input id="ccDateYY" name="ccDate" placeholder="YY" class="form-control" maxlength="2" required type="text">
					<input id="ccDateMM" name="ccDate" placeholder="MM" class="form-control " maxlength="2" required type="text">
				</div>
				<div class="col-1"></div>
				<div class="col-5">
					<input id="ccCVC" name="ccCVC" placeholder="CVC" class="form-control" required type="text">
				</div>
			</div>
		</div>
        <hr class="mb-4">
        <input type="hidden" name="resId" value="${resId}"/>
        <button class="btn btn-orange btn-lg btn-block rounded-pill" type="submit"><i class="far fa-credit-card pr-1"></i>결제하기</button>
        </div>
      </form:form>
