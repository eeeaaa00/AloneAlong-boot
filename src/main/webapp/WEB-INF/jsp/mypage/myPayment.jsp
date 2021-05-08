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
<title>결제관리</title>
</head>
<body>
	<!-- header -->
	<%@include file="../header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<a href="<c:url value='/myInfo' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block">정보
					변경</a> <a href="<c:url value='/myPayment' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block active">결제정보
					관리</a> <a href="<c:url value='/myOrder' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block">구매
					내역</a> <a href="#"
					class="btn btn-outline-success rounded-pill my-1 btn-block">식당
					예약</a> <a href="#"
					class="btn btn-outline-success rounded-pill my-1 btn-block">같밥
					예약</a>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<h4>결제정보 관리</h4>
								<p>카드는 하나만 등록할 수 있습니다.</p>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form>
									<div class="form-group row">
										<label for="username" class="col-4 col-form-label">카드
											이름</label>
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
									<div class="form-group row">
										<label for="username" class="col-4 col-form-label">카드
											번호</label>
										<div class="col-8">
											<input id="nickname" name="nickname" placeholder="카드 번호"
												class="form-control here" required="required" type="text">
										</div>
									</div>
									<div class="form-group row">
										<label for="lastname" class="col-4 col-form-label">카드
											유효기간</label>
										<div class="col-8">
											<div class="row">
												<div class="col-xs-4 col-md-4">
													<input id="year" name="year" placeholder="년"
														class="form-control here" required="required" type="text">
												</div>
												<div class="col-xs-4 col-md-4">
													<input id="month" name="month" placeholder="월"
														class="form-control here" required="required" type="text">
												</div>
												<div class="col-xs-4 col-md-4">
													<input id="day" name="day" placeholder="일"
														class="form-control here" required="required" type="text">
												</div>
											</div>


										</div>
									</div>
									<div class="form-group row">
										<div class="offset-4 col-8">
											<button name="submit" type="submit"
												class="btn btn-success btn-lg active">카드 등록</button>
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

	<!-- Footer -->
	<%@include file="../footer.jsp"%>
</body>
</html>