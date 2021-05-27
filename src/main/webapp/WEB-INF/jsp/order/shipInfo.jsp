<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="mb-5 pb-5 border-bottom pr-5">
	<h4 class="mb-5 mx-2">주문 정보</h4>
	<div class="row w-50 mx-2 mb-3">
		<label>이름</label> <input name="shipName" type="text" class="form-control" required >
	</div>

	<label class="mx-2">전화번호</label>
	<div class="row w-50 mx-2 mb-3 input-group">
		<div class="input-group-prepend">
			<select name="shipPhone1" class="custom-select">
				<option selected>010</option>
				<option value="1">011</option>
				<option value="2">016</option>
				<option value="3">017</option>
			</select>
		</div>
		<input type="text" name="shipPhone2" class="form-control" maxlength="4" required>
		<input type="text" name="shipPhone3" class="form-control" maxlength="4" required>
	</div>

	<div class="row w-100 mx-2 mb-3">
		<label for="shipEmail">이메일</label>
		<input type="email" class="form-control" name="shipEmail" id="shipEmail" placeholder="you@example.com">
	</div>

	<div class="row px-2 mb-1">
		<label for="shipZip" class="col-md-3">우편번호</label>
		<label for="shipAddress" class="col-md-9">주소</label>
	</div>
	<div class="row mx-2 mb-3 input-group">
		<input type="number" name="shipZip" class="col-md-3 form-control" id="shipZip" required>
		<input type="text" name="shipAddress" class="col-md-9 form-control" id="shipAddress" required>
	</div>
</div>