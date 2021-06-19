<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function signOut() {
		if (confirm("탈퇴하시겠습니까?")) {
			window.location.href = "/signOut";
		} else {
			alert("탈퇴 취소");
		}
	}
</script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else { 
                addr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById("address").value = extraAddr;
            
            } else {
                document.getElementById("address").value = '';
            }

            document.getElementById("zip").value = data.zonecode;
            document.getElementById("address").value = addr + " ";
            document.getElementById("address").focus();
        }
    }).open();
}
</script>
<div class="col-md-12">
	<form:form modelAttribute="userForm" method="post">
		<B style="color: #FF0000;"><form:errors cssClass="error" /></B>

		<div class="form-group row">
			<label for="userId" class="col-4 col-form-label">아이디</label>
			<div class="col-8">
				<c:choose>
					<c:when test="${!empty userSession.user}">
						<form:input class="form-control here" placeholder="아이디"
							path="user.id" htmlEscape="false" readonly="true" />
					</c:when>
					<c:otherwise>
						<form:input class="form-control here" placeholder="아이디"
							path="user.id" htmlEscape="false" />
					</c:otherwise>
				</c:choose>
				<B style="color: #FF0000;"><form:errors path="user.id"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-4 col-form-label">비밀번호</label>
			<div class="col-8">
				<form:input type="password" class="form-control here"
					placeholder="비밀번호" path="user.pw" />
			</div>
		</div>
		<div class="form-group row">
			<label for="password2" class="col-4 col-form-label">비밀번호 확인</label>
			<div class="col-8">
				<form:input type="password" class="form-control here"
					placeholder="비밀번호 확인" path="repeatedPassword" />
				<B style="color: #FF0000;"><form:errors path="repeatedPassword"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">이름</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="이름"
					path="user.name" />
				<B style="color: #FF0000;"><form:errors path="user.name"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">닉네임</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="닉네임"
					path="user.nickname" />
				<B style="color: #FF0000;"><form:errors path="user.nickname"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-4 col-form-label">이메일</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="이메일"
					path="user.email" />
				<B style="color: #FF0000;"><form:errors path="user.email"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="website" class="col-4 col-form-label">전화번호</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="-를 포함해 입력해주세요."
					path="user.phone" />
				<B style="color: #FF0000;"><form:errors path="user.phone"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="select" class="col-4 col-form-label">성별</label>
			<div class="col-8">
				<form:select class="custom-select" path="user.sex" items="${sex}"
					required="required" />

			</div>
		</div>
		<div class="form-group row">
			<label for="birthday" class="col-4 col-form-label">생년월일</label>
			<div class="col-8">
				<form:input type="date" class="form-control here"
					path="user.birthday" />
			</div>
		</div>
		<div class="form-group row">
			<label for="zip" class="col-4 col-form-label">우편번호</label>
			<div class="col-3">
				<form:input class="form-control here" placeholder="우편번호를 입력해주세요."
					path="user.zip" id="zip" />
				<B style="color: #FF0000;"><form:errors path="user.zip"
						cssClass="error" /></B>
			</div>
			<div class="col-3">
				<button type="button" class="btn btn-orange" onClick="sample6_execDaumPostcode()">우편번호 찾기</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="address" class="col-4 col-form-label">주소</label>
			<div class="col-8">
				<form:input class="form-control here" id="address"
					placeholder="주소 및 상세정보를 입력해주세요." path="user.address" />
				<B style="color: #FF0000;"><form:errors path="user.address"
						cssClass="error" /></B>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="publicinfo" class="col-4 col-form-label">사업자등록</label>
			<div class="col-8">
				<form:input class="form-control here"
					placeholder="000-00-00000(사업자번호는 선택사항입니다.)"
					path="user.business_num" />
				<B style="color: #FF0000;"><form:errors path="user.business_num"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<button name="submit" type="submit"
				class="btn btn-outline-success rounded-pill my-1 btn-block">완료</button>
		</div>
	</form:form>
	<div class="form-group row">
		<c:if test="${!empty userSession.user}">
			<button name="submit" type="submit"
				class="btn btn-outline-danger rounded-pill my-1 btn-block"
				onClick="signOut()">회원 탈퇴</button>
		</c:if>
	</div>
</div>