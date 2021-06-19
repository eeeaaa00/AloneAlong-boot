<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("shipAddress").value = extraAddr;
            
            } else {
                document.getElementById("shipAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('shipZip').value = data.zonecode;
            document.getElementById("shipAddress").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("shipAddress2").focus();
        }
    }).open();
}
</script>
<script type="text/javascript">
function sameAddress(s){
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
		<input type="checkbox" class="custom-control-input" id="same-address" onClick="sameAddress(this)">
	<label class="custom-control-label" for="same-address">주문 정보와 동일</label>
	</div>
	<div class="row w-50 mx-2">
		<label>이름 <strong class="text-green">*</strong></label> <form:input path="order.shipName" id="shipName" class="form-control" type="text"/>
		<B style="color: #FF0000;"><form:errors path="order.shipName" cssClass="error" /></B>
	</div>

	<label class="mx-2  mt-3">전화번호 <strong class="text-green">*</strong></label>
	<div class="w-50">
	<div class="row mx-2 input-group">
		<div class="input-group-prepend">
			<form:select path="order.shipPhone1" id="shipPhone1" class="custom-select">
				<form:option value="010">010</form:option>
				<form:option value="011">011</form:option>
				<form:option value="016">016</form:option>
				<form:option value="017">017</form:option>
			</form:select>
		</div>
		<form:input path="order.shipPhone2" id="shipPhone2" type="text" class="form-control" maxlength="4"/>
		<form:input path="order.shipPhone3" id="shipPhone3" type="text" class="form-control" maxlength="4"/>
	</div>
	<b class="mx-2" style="color: #FF0000;"><form:errors path="order.shipPhone2" cssClass="error" /></b>
	<b class="mx-2" style="color: #FF0000;"><form:errors path="order.shipPhone3" cssClass="error" /></b>
	</div>

	<div class="row w-100 mx-2 mt-3">
		<label for="shipEmail">이메일</label>
		<form:input path="order.shipEmail" id="shipEmail" type="email" class="form-control" placeholder="you@example.com"/>
	</div>
	<b class="mx-2" style="color: #FF0000;"><form:errors path="order.shipEmail" cssClass="error" /></b>

	<div class="row px-2 mt-3">
		<label for="shipZip" class="col-md-3">우편번호 <strong class="text-green">*</strong></label>
	</div>
	<div class="row mx-2 input-group">
		<form:input path="order.shipZip" id="shipZip" type="text" class="col-md-3 form-control" readonly="true"/>
		<button type="button" class="btn btn-orange" onClick="sample6_execDaumPostcode()">우편번호 찾기</button>
	</div>
	<b class="mx-2" style="color: #FF0000;"><form:errors path="order.shipZip" cssClass="error" /></b>
	<div class="row px-2 mb-1 mt-3">
		<label for="shipAddress" class="col-md-6">주소 <strong class="text-green">*</strong></label>
		<label for="shipAddress2" class="col-md-6">상세주소</label>
	</div>
	<div class="row mx-2 input-group">
		<form:input path="order.shipAddress" id="shipAddress" type="text" class="col-md-6 form-control" readonly="true"/>
		<form:input path="order.shipAddress2" id="shipAddress2" type="text" class="col-md-6 form-control"/>
	</div>
	<b class="mx-2" style="color: #FF0000;"><form:errors path="order.shipAddress" cssClass="error" /></b>
</div>