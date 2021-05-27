<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row mb-5">
    <div class="col-md-1"></div>
    <div class="col-md-10 mb-3">
    
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
	           
	        <label class="mx-2">전화번호</label>
	        <div class="row w-50 mx-2 mb-3 input-group">
				전화번호
			</div>
	
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">이메일</label>
	          <div class="row w-50 mx-2 mb-3 input-group">
	          	이메일. 수정할거있으면 회원정보수정링크 만들어놓겠음
	          </div>
	        </div>
	
        <hr class="mb-4">

        <h4 class="mb-3">Payment</h4>

        <div class="d-block my-3">
          <div class="custom-control custom-radio">
            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
            <label class="custom-control-label" for="credit">Credit card</label>
          </div>
          <div class="custom-control custom-radio">
            <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required="">
            <label class="custom-control-label" for="debit">Debit card</label>
          </div>
          <div class="custom-control custom-radio">
            <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required="">
            <label class="custom-control-label" for="paypal">PayPal</label>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="cc-name">Name on card</label>
            <input type="text" class="form-control" name = "ccName" id="cc-name" placeholder="" required="">
            <small class="text-muted">Full name as displayed on card</small>
            <div class="invalid-feedback">
              Name on card is required
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="cc-number">Credit card number</label>
            <input type="text" class="form-control" name = "ccNum" id="cc-number" placeholder="" required="">
            <div class="invalid-feedback">
              Credit card number is required
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="cc-expiration">Expiration</label>
            <input type="text" class="form-control" name = "ccDate" id="cc-expiration" placeholder="" required="">
            <div class="invalid-feedback">
              Expiration date required
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="cc-cvv">CVV</label>
            <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
            <div class="invalid-feedback">
              Security code required
            </div>
          </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="resId" value="${resId}"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
        </div>
      </form:form>
    </div>
  </div>
