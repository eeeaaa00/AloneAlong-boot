<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
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
	          <input type="date" class="form-control" id="visitDate" name = "visitDate">
	          <input type="time" class="form-control" id="visitDate" name = "visitDate">
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

        <h4 class="mx-2 mb-5">결제 정보</h4>
			<div class="row w-100 mx-2 mb-3 no-gutters">
				<label for="cardname" class="col-4 col-form-label">카드 이름</label>
				<div class="col-8">
					<select id="ccName" name="ccName" class="custom-select">
						<option value="NH">농협</option>
						<option value="KM">국민</option>
						<option value="SH">신한</option>
						<option value="WE">우리</option>
						<option value="IBK">기업</option>
						<option value="SC">SC제일</option>
						<option value="KK">카카오뱅크</option>
						<option value="NT">새마을금고</option>
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
					<input name="ccDate" placeholder="YY" class="form-control" maxlength="2" required type="text">
					<input name="ccDate" placeholder="MM" class="form-control " maxlength="2" required type="text">
				</div>
				<div class="col-1"></div>
				<div class="col-5">
					<input name="ccCVC" placeholder="CVC" class="form-control" required type="text">
				</div>
			</div>
		</div>
        <hr class="mb-4">
        <input type="hidden" name="resId" value="${resId}"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
        </div>
      </form:form>
