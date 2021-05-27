<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="needs-validation" novalidate="">
    <div class="container row mb-3">
    	<div class="col-md-8">
	    	<div class="mb-5 pb-5 border-bottom pr-5">
		      <h4 class="mb-5 mx-2">주문 정보</h4>
		        <div class="row w-50 mx-2 mb-3">
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
					<input type="text" class="form-control" maxlength="4">
					<input type="text" class="form-control" maxlength="4">
				</div>
		
		        <div class="row w-100 mx-2 mb-3">
		          <label for="email">이메일</label>
		          <input type="email" class="form-control" id="email" placeholder="you@example.com">
		        </div>
		
		        <div class="row px-2 mb-1">
		        	<label for="zip" class="col-md-3">우편번호</label>
		        	<label for="address" class="col-md-9">주소</label>
		        </div>
		        <div class="row mx-2 mb-3 input-group">
					<input type="number" class="col-md-3 form-control" id="zip">
					<input type="text" class="col-md-9 form-control" id="address">
				</div>
			</div>
	    	<div class="mb-5 pb-5 border-bottom pr-5">
		      <h4 class="mb-3 mx-2">배송 정보</h4>
			    <div class="mb-3 text-right custom-control custom-checkbox">
			          <input type="checkbox" class="custom-control-input" id="same-address">
		          <label class="custom-control-label" for="same-address">결제 정보와 동일</label>
			    </div>
		        <div class="row w-50 mx-2 mb-3">
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
					<input type="text" class="form-control" maxlength="4">
					<input type="text" class="form-control" maxlength="4">
				</div>
		
		        <div class="row w-100 mx-2 mb-3">
		          <label for="email">이메일</label>
		          <input type="email" class="form-control" id="email" placeholder="you@example.com">
		        </div>
		
		        <div class="row px-2 mb-1">
		        	<label for="zip" class="col-md-3">우편번호</label>
		        	<label for="address" class="col-md-9">주소</label>
		        </div>
		        <div class="row mx-2 mb-3 input-group">
					<input type="number" class="col-md-3 form-control" id="zip">
					<input type="text" class="col-md-9 form-control" id="address">
				</div>
			</div>
			
	    	<div class="mb-5 pb-5 border-bottom pr-5">
	        	<h4 class="mx-2 mb-5">결제 정보</h4>
				<div class="row w-100 mx-2 mb-3 no-gutters">
					<label for="username" class="col-4 col-form-label">카드 이름</label>
					<div class="col-8">
						<select id="select" name="select" class="custom-select">
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
					<label for="username" class="col-4 col-form-label">카드 번호</label>
						<div class="col-8">
									<input id="nickname" name="nickname" placeholder="카드 번호"
										class="form-control here" required="required" type="text">
						</div>
				</div>
				<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
					<label for="lastname" class="col-4 col-form-label">카드 정보</label>
					<div class="row col-8 no-gutters">
						<div class="col-6 input-group">
							<input name="year" placeholder="YY" class="form-control" maxlength="2" required type="text">
							<input name="month" placeholder="MM" class="form-control " maxlength="2" required type="text">
						</div>
						<div class="col-1"></div>
						<div class="col-5">
							<input placeholder="CVC" class="form-control" required="required" type="text">
						</div>
					</div>
				</div>
			</div>
		</div>
        
    	<div class="col-md-4">
    		<div class="bg-light py-4 rounded-lg px-4">
					<h3 class="mt-2 mb-5 text-uppercase">주문 합계</h3>
					<div
						class="py-1 pt-3 px-3 row justify-content-between border-bottom">
						<span>상품 금액</span><span>${productsPrice}원</span>
					</div>
					<div
						class="py-1 pt-3 px-3 row justify-content-between border-bottom">
						<span>배송비</span><span>${shippingFee}원</span>
					</div>
					<div
						class="py-1 pt-3 px-3 row align-items-end justify-content-between border-bottom">
						<span>합계</span>
						<h4>${totalPrice}원</h4>
					</div>
					<div class="row justify-content-center">
						<a type="button"
							class="btn btn-orange btn-block rounded-pill py-3 my-1 mt-3 mx-3"
							href="<c:url value='/order' />"> <small><i
								class="far fa-credit-card pr-1"></i></small> 결제하기
						</a>
					</div>
				</div>
    	</div>
	</div>
</form>