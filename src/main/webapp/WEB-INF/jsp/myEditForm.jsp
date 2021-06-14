<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-md-9">
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<form:form modelAttribute="userForm" method="post">
						<div class="form-group row">
							<label for="userId" class="col-4 col-form-label">아이디</label>
							<div class="col-8">
							 <form:input class="form-control here" placeholder="아이디" path="user.id" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-4 col-form-label">비밀번호</label>
							<div class="col-8">
								 <form:input type="password" class="form-control here" placeholder="비밀번호" path="user.pw" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="password2" class="col-4 col-form-label">비밀번호 확인</label>
							<div class="col-8">
							 <form:input type="password" class="form-control here" placeholder="비밀번호 확인" path="repeatedPassword" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="username" class="col-4 col-form-label">이름</label>
							<div class="col-8">
							 <form:input class="form-control here" placeholder="이름" path="user.name" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="username" class="col-4 col-form-label">닉네임</label>
							<div class="col-8">
								 <form:input class="form-control here" placeholder="닉네임" path="user.nickname" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-4 col-form-label">이메일</label>
							<div class="col-8">
							 <form:input class="form-control here" placeholder="이메일" path="user.email" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="website" class="col-4 col-form-label">전화번호</label>
							<div class="col-8">
							 <form:input class="form-control here" placeholder="-를 제외하고 입력해주세요." path="user.phone" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="select" class="col-4 col-form-label">성별</label>
							<div class="col-8">
								<form:select class="custom-select" path="user.sex" items="${sex}"  required="required" />
							</div>
						</div>
						<div class="form-group row">
							<label for="birthday" class="col-4 col-form-label">생년월일</label>
							<div class="col-8">
								 <form:input type="date" class="form-control here" placeholder="6자리로 입력해주세요.(001122)" path="user.birthday" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="newpass" class="col-4 col-form-label">주소</label>
							<div class="col-8">
								 <form:input class="form-control here" placeholder="주소 및 상세정보를 입력해주세요." path="user.address" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="newpass" class="col-4 col-form-label">우편번호</label>
							<div class="col-8">
							 <form:input class="form-control here" placeholder="우편번호" path="user.zip" required="required"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="publicinfo" class="col-4 col-form-label">사업자
								등록</label>
							<div class="col-8">
								<button type="button" class="btn btn-link" name="addOwn"
									data-toggle="modal" data-target="#exampleModal">
									<i class="far fa-edit"></i> 사업자 등록
								</button>
							</div>
						</div>
						<div class="form-group row">
							<div class="offset-4 col-8">
								<button name="submit" type="submit"
									class="btn btn-success btn-lg active">완료</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content pb-4">
			<div class="modal-header">
				<h5 class="modal-title">사업자 등록</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form class="form">
					<div class="form-group">
						<input id="bsId" name="bsId" placeholder="사업자번호를 입력하세요."
							class="form-control here" type="text">
					</div>
				</form>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-outline-success">등록</button>
				<button type="button" class="btn btn-outline-success">취소</button>
			</div>
		</div>
	</div>
</div>




