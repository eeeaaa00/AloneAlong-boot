<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- for Icon -->
<script src="https://kit.fontawesome.com/cfb4151af4.js"></script>
<!-- 구글폰트링크 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&family=Roboto&display=swap"
	rel="stylesheet">
<title>정보변경</title>
</head>
<body>
	<!-- header -->
<%@include file="../header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-2">
				<a href="<c:url value='/myInfo' />" class="btn btn-outline-success rounded-pill my-1 btn-block active">정보 변경</a>
			<a href="<c:url value='/myPayment' />" class="btn btn-outline-success rounded-pill my-1 btn-block">결제정보 관리</a>
				<a href="<c:url value='/myOrder' />" class="btn btn-outline-success rounded-pill my-1 btn-block">구매 내역</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">식당 예약</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">같밥 예약</a>
			</div>
		
		<div class="col-md-9">
		    <div class="card">
		        <div class="card-body">
		            <div class="row">
		                <div class="col-md-12">
		                    <h4>정보 변경</h4>
		                    <b style="color: #29A65F;">공지수</b>님의 정보를 변경할 수 있습니다.
		                    <hr>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-12">
		                    <form>
                              <div class="form-group row">
                                <label for="username" class="col-4 col-form-label">이름</label> 
                                <div class="col-8">
                                  <input id="username" name="username" placeholder="이름" class="form-control here" required="required" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="username" class="col-4 col-form-label">닉네임</label> 
                                <div class="col-8">
                                  <input id="nickname" name="nickname" placeholder="닉네임" class="form-control here" required="required" type="text">
                                </div>
                              </div>
                               <div class="form-group row">
                                <label for="lastname" class="col-4 col-form-label">비밀번호</label> 
                                <div class="col-8">
                                  <input id="password1" name="password1" placeholder="비밀번호" class="form-control here" type="password">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="text" class="col-4 col-form-label">비밀번호 확인</label> 
                                <div class="col-8">
                                  <input id="password2" name="password2" placeholder="비밀번호 확인" class="form-control here" required="required" type="password">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="select" class="col-4 col-form-label">성별</label> 
                                <div class="col-8">
                                  <select id="select" name="select" class="custom-select">
                                    <option value="f">여</option>
                                    <option value="m">남</option>
                                  </select>
                                </div>
                              </div>
                               <div class="form-group row">
                                <label for="select" class="col-4 col-form-label">생년월일</label> 
                                <div class="col-8">
                                  <div class="row">
												<div class="col-xs-4 col-md-4">
													 <input id="year" name="year" placeholder="년" class="form-control here" required="required" type="text">
												</div>
												<div class="col-xs-4 col-md-4">
													 <input id="month" name="month" placeholder="월" class="form-control here" required="required" type="text">
												</div>
												<div class="col-xs-4 col-md-4">
													 <input id="day" name="day" placeholder="일" class="form-control here" required="required" type="text">
												</div>
											</div>
											
											
                                </div>
                              </div>
                              	
                              <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">이메일</label> 
                                <div class="col-8">
                                  <input id="email" name="email" placeholder="이메일" class="form-control here" required="required" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="website" class="col-4 col-form-label">전화번호</label> 
                                <div class="col-8">
                                  <input id="phone" name="phone" placeholder="'-' 를 제외하고 입력해주세요." class="form-control here" type="text">
                                </div>
                              </div>
                               <div class="form-group row">
                                <label for="newpass" class="col-4 col-form-label">우편번호</label> 
                                <div class="col-8">
                                  <input id="zip" name="zip" placeholder="우편번호" class="form-control here" type="text">
                                </div>
                              </div> 
                               <div class="form-group row">
                                <label for="newpass" class="col-4 col-form-label">주소</label> 
                                <div class="col-8">
                                  <input id="address" name="address" placeholder="주소 및 상세정보를 입력해주세요." class="form-control here" type="text">
                                </div>
                              </div> 
                              <div class="form-group row">
                                <label for="publicinfo" class="col-4 col-form-label">사업자 등록</label> 
                                <div class="col-8">
                                   <button  type="button" class="btn btn-link" name="addOwn" data-toggle="modal" data-target="#exampleModal"><i class="far fa-edit"></i> 사업자 등록</button>
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="offset-4 col-8">
                                  <button name="submit" type="submit" class="btn btn-success btn-lg active">수정 완료</button>
                                </div>
                              </div>
                            </form>
		                </div>
		            </div>
		            
		        </div>
		    </div>
		</div>
	</div>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
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
						 <input id="bsId" name="bsId" placeholder="사업자번호를 입력하세요." class="form-control here" type="text">
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
	<!-- Footer -->
	<%@include file="../footer.jsp"%>
</body>
</html>