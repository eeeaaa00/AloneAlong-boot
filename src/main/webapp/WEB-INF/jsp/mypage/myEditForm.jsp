<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-12">
	<form:form modelAttribute="userForm" method="post">
	<form:errors cssClass="error" /> 
	
		<div class="form-group row">
			<label for="userId" class="col-4 col-form-label">아이디</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="아이디"
					path="user.id" htmlEscape="false" /><B style="color: #FF0000;">
				<form:errors path="user.id"	cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-4 col-form-label">비밀번호</label>
			<div class="col-8">
				<form:input type="password" class="form-control here"
					placeholder="비밀번호" path="user.pw" required="required"/>
				<B><form:errors path="user.pw" cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="password2" class="col-4 col-form-label">비밀번호 확인</label>
			<div class="col-8">
				<form:input type="password" class="form-control here"
					placeholder="비밀번호 확인" path="repeatedPassword" required="required" />
				<B style="color: #FF0000;"><form:errors path="repeatedPassword"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">이름</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="이름"
					path="user.name" required="required" />
					<B style="color: #FF0000;"><form:errors path="user.name"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">닉네임</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="닉네임"
					path="user.nickname" required="required" />
					<B style="color: #FF0000;"><form:errors path="user.nickname"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-4 col-form-label">이메일</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="이메일"
					path="user.email" required="required" />
					<B style="color: #FF0000;"><form:errors path="user.email"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="website" class="col-4 col-form-label">전화번호</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="-를 제외하고 입력해주세요."
					path="user.phone" required="required" />
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
					placeholder="6자리로 입력해주세요.(001122)" path="user.birthday"
					required="required" />
					<B style="color: #FF0000;"><form:errors path="user.birthday"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="address" class="col-4 col-form-label">주소</label>
			<div class="col-8">
				<form:input class="form-control here"
					placeholder="주소 및 상세정보를 입력해주세요." path="user.address"
					required="required" />
					<B style="color: #FF0000;"><form:errors path="user.address"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="zip" class="col-4 col-form-label">우편번호</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="우편번호"
					path="user.zip" required="required" />
					<B style="color: #FF0000;"><form:errors path="user.zip"
						cssClass="error" /></B>
			</div>
		</div>
		<div class="form-group row">
			<label for="publicinfo" class="col-4 col-form-label">사업자등록</label>
			<div class="col-8">
				<form:input class="form-control here" placeholder="사업자번호"
					path="user.buisness_num" />
			</div>
		</div>
		<div class="form-group row">
			<button name="submit" type="submit"
				class="btn btn-outline-success rounded-pill my-1 btn-block">완료</button>

			<c:if test="${!empty userSession.user}">
				<a href="<c:url value='/signOut' />">회원 탈퇴</a>
			</c:if>
		</div>
	</form:form>
</div>


