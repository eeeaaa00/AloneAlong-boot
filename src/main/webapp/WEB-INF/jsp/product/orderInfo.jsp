<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="mb-5 pb-5 border-bottom pr-5">
	<h4 class="mb-5 mx-2">주문 정보</h4>
	<div class="row w-50 mx-2 mb-3">
		<label>이름</label> <input id="orderName" name="orderName" type="text" class="form-control" required value="${orderForm.getOrderUser().name}" readonly>
	</div>

	<label class="mx-2">전화번호</label>
	<c:set var="orderPhone" value="${fn:split(orderForm.getOrderUser().phone, '-')}"/>
	<div class="row w-50 mx-2 mb-3 input-group">
		<div class="input-group-prepend">
			<select id="orderPhone1" name="orderPhone1" class="custom-select" disabled>
				<option ${orderPhone[0] == '010' ? 'selected="selected"' : ''} value="010">010</option>
				<option ${orderPhone[0] == '011' ? 'selected="selected"' : ''} value="011">011</option>
				<option ${orderPhone[0] == '016' ? 'selected="selected"' : ''} value="016">016</option>
				<option ${orderPhone[0] == '017' ? 'selected="selected"' : ''} value="017">017</option>
			</select>
		</div>
		<input type="text" id="orderPhone2" name="orderPhone2" class="form-control" maxlength="4" required value="${orderPhone[1]}" readonly>
		<input type="text" id="orderPhone3" name="orderPhone3" class="form-control" maxlength="4" required value="${orderPhone[2]}" readonly>
	</div>

	<div class="row w-100 mx-2 mb-3">
		<label for="orderEmail">이메일</label>
		<input type="email" class="form-control" name="orderEmail" id="orderEmail" value="${orderForm.getOrderUser().email}" readonly>
	</div>

	<div class="row px-2 mb-1">
		<label for="orderZip" class="col-md-3">우편번호</label>
		<label for="orderAddress" class="col-md-9">주소</label>
	</div>
	<div class="row mx-2 mb-3 input-group">
		<input type="number" name="orderZip" class="col-md-3 form-control" id="orderZip" required value="${orderForm.getOrderUser().zip}" readonly>
		<input type="text" name="orderAddress" class="col-md-9 form-control" id="orderAddress" required  value="${orderForm.getOrderUser().address}" readonly>
	</div>
</div>