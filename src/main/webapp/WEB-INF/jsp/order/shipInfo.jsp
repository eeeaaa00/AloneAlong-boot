<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function check(s){
	if(s.checked){
		document.getElementById("shipName").value = document.getElementById("orderName").value;
		document.getElementById("shipPhone1").options[document.getElementById("orderPhone1").selectedIndex].selected = true;
		document.getElementById("shipPhone2").value = document.getElementById("orderPhone2").value;
		document.getElementById("shipPhone3").value = document.getElementById("orderPhone3").value;
		document.getElementById("shipEmail").value = document.getElementById("orderEmail").value;
		document.getElementById("shipZip").value = document.getElementById("orderZip").value;
		document.getElementById("shipAddress").value = document.getElementById("orderAddress").value;
	}
	else{
		document.getElementById("shipName").value = "";
		document.getElementById("shipPhone2").value = "";
		document.getElementById("shipPhone3").value = "";
		document.getElementById("shipEmail").value =  "";
		document.getElementById("shipZip").value = "";
		document.getElementById("shipAddress").value = "";
	}
}
</script>
<div class="mb-5 pb-5 border-bottom pr-5">
	<h4 class="mb-3 mx-2">배송 정보</h4>
	<div class="mb-3 text-right custom-control custom-checkbox">
		<input type="checkbox" class="custom-control-input" id="same-address" onClick="check(this)">
	<label class="custom-control-label" for="same-address">결제 정보와 동일</label>
	</div>
	<div class="row w-50 mx-2 mb-3">
		<label>이름</label> <input id="shipName" name="shipName" type="text" class="form-control" required >
	</div>

	<label class="mx-2">전화번호</label>
	<div class="row w-50 mx-2 mb-3 input-group">
		<div class="input-group-prepend">
			<select id="shipPhone1" name="shipPhone1" class="custom-select">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
			</select>
		</div>
		<input type="text" id="shipPhone2" name="shipPhone2" class="form-control" maxlength="4" required>
		<input type="text" id="shipPhone3" name="shipPhone3" class="form-control" maxlength="4" required>
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