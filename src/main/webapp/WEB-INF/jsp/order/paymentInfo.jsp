<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mb-5 pb-5 border-bottom pr-5">
	<h4 class="mx-2 mb-5">결제 정보</h4>
	<div class="row w-100 mx-2 mb-3 no-gutters">
		<label for="cardname" class="col-4 col-form-label">카드 이름</label>
		<div class="col-8">
			<select id="cardName" name="cardName" class="custom-select">
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
			<input id="cardNum" name="cardNum" placeholder="카드 번호"
				class="form-control here" required="required" type="text">
		</div>
	</div>
	<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
		<label class="col-4 col-form-label">카드 정보</label>
		<div class="row col-8 no-gutters">
			<div class="col-6 input-group">
				<input name="cardYear" placeholder="YY" class="form-control" maxlength="2" required type="text">
				<input name="cardMonth" placeholder="MM" class="form-control " maxlength="2" required type="text">
			</div>
			<div class="col-1"></div>
			<div class="col-5">
				<input name="CardCVC" placeholder="CVC" class="form-control" required type="text">
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
		<button type="submit" class="btn btn-orange btn-block rounded-pill py-3 my-1 mt-3 mx-3">
			<small><i class="far fa-credit-card pr-1"></i></small> 결제하기
		</button>
	</div>
</div>