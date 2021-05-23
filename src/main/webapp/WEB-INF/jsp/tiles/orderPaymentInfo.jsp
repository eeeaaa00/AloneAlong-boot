<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row mb-5">
    <div class="col-md-1"></div>
    <div class="col-md-10 mb-3">
	  <form class="needs-validation" novalidate="">
    	<div class="mb-5 pb-5 border-bottom">
	      <h4 class="mb-4">주문 정보</h4>
	        <div class="row w-25 mx-2 mb-3">
	            <label >이름</label>
	            <input type="text" class="form-control">
	        </div>
	            
	        <label class="mx-2">전화번호</label>
	        <div class="row w-50 mx-2 mb-3 input-group">
				<div class="input-group-prepend">
					<select class="custom-select">
					    <option selected>010</option>
					    <option value="1">011</option>
					    <option value="2">016</option>
					    <option value="3">017</option>
					  </select>
				</div>
				<input type="text" class="form-control">
				<input type="text" class="form-control">
			</div>
	
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">이메일</label>
	          <input type="email" class="form-control" id="email" placeholder="you@example.com">
	        </div>
	
	        <div class="row mb-3 mx-1">
		       <div class="col-md-3">
		         <label for="zip">우편번호</label>
		          <input type="text" class="form-control">
		       </div>
		       <div class="col-md-7">
		         <label for="zip">주소</label>
	            <input type="text" class="form-control">
	            </div>
	        </div>
	        
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">상세 주소</label>
	          <input type="email" class="form-control">
	        </div>
        </div>
		
		<div class="mb-5 pb-5 border-bottom">
	      <h4 class="mb-4">배송 정보</h4>
	        <div class="row w-25 mx-2 mb-3">
	            <label >이름</label>
	            <input type="text" class="form-control">
	        </div>
	            
	        <label class="mx-2">전화번호</label>
	        <div class="row w-50 mx-2 mb-3 input-group">
				<div class="input-group-prepend">
					<select class="custom-select">
					    <option selected>010</option>
					    <option value="1">011</option>
					    <option value="2">016</option>
					    <option value="3">017</option>
					  </select>
				</div>
				<input type="text" class="form-control">
				<input type="text" class="form-control">
			</div>
	
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">이메일</label>
	          <input type="email" class="form-control" id="email" placeholder="you@example.com">
	        </div>
	
	        <div class="row mb-3 mx-1">
		       <div class="col-md-3 ">
		         <label for="zip">우편번호</label>
		          <input type="text" class="form-control">
		       </div>
		       <div class="col-md-7">
		         <label for="zip">주소</label>
	            <input type="text" class="form-control">
	            </div>
	        </div>
	        
	        <div class="row w-50 mx-2 mb-3">
	          <label for="email">상세 주소</label>
	          <input type="email" class="form-control">
	        </div>
        </div>
        
        <hr class="mb-4">
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="same-address">
          <label class="custom-control-label" for="same-address">Shipping address is the same as my billing address</label>
        </div>
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="save-info">
          <label class="custom-control-label" for="save-info">Save this information for next time</label>
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
            <input type="text" class="form-control" id="cc-name" placeholder="" required="">
            <small class="text-muted">Full name as displayed on card</small>
            <div class="invalid-feedback">
              Name on card is required
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="cc-number">Credit card number</label>
            <input type="text" class="form-control" id="cc-number" placeholder="" required="">
            <div class="invalid-feedback">
              Credit card number is required
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="cc-expiration">Expiration</label>
            <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
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
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
      </form>
    </div>
  </div>
