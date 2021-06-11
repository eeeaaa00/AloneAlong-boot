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
<title>주문내역</title>
<style type="text/css">
</style>
</head>
<body>
	<!-- header -->
	<%@include file="../header.jsp"%>

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-2">
				<a href="<c:url value='/myInfo' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block">정보
					변경</a> <a href="<c:url value='/myPayment' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block">결제정보
					관리</a> <a href="<c:url value='/myOrder' />"
					class="btn btn-outline-success rounded-pill my-1 btn-block active">구매
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
								<h4>구매 내역</h4>
								<b style="color: #29A65F;">공지수</b>님의 구매 내역을 확인할 수 있습니다.
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
							<div class="form-row float-right">
							<a href="<c:url value='/shopping/apple/review' />">
									<button class="btn btn-sm btn-outline-success"
										id="advanced-set-submit" >리뷰 작성</button> </a>
								</div>
								<div class="d-flex align-items-center">
									<a href="/detail-1"> <svg class="img rounded-lg"
											style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg>
									</a>
									<div class="cart-title text-left ml-3">
										<a class="text-uppercase text-dark" href="/detail-1"> <strong>유기농
												사과 3개입</strong></a> <br> <small style="color: #f2864b;">주문번호
										</small> &nbsp; <small style="color: #696969;"> 2016546548</small> <Br>
										<small
											style="color: #f2864b;">주문수량 </small> &nbsp; <small
											style="color: #696969;"> 1개</small><br>
										<small style="color: #f2864b;">결제금액 </small> &nbsp;<small
											style="color: #696969;"> 8500원</small> <br> <small
											style="color: #f2864b;">주문상태 </small> &nbsp;<small
											style="color: #696969;"> 배송완료</small>
									</div>
								</div>
								<br>
								<hr>
							</div>
							
							<div class="col-md-12">
							<div class="form-row float-right">
									<button class="btn btn-sm btn-outline-success"
										id="advanced-set-submit">리뷰 작성</button>
								</div>
								<div class="d-flex align-items-center">
									<a href="/detail-1"> <svg class="img rounded-lg"
											style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg>
									</a>
									<div class="cart-title text-left ml-3">
										<a class="text-uppercase text-dark" href="/detail-1"> <strong>유기농
												사과 3개입</strong></a> <br> <small style="color: #f2864b;">주문번호
										</small> &nbsp; <small style="color: #696969;"> 2016546548</small> <Br>
										<small
											style="color: #f2864b;">주문수량 </small> &nbsp; <small
											style="color: #696969;"> 1개</small><br>
										<small style="color: #f2864b;">결제금액 </small> &nbsp;<small
											style="color: #696969;"> 8500원</small> <br> <small
											style="color: #f2864b;">주문상태 </small> &nbsp;<small
											style="color: #696969;"> 배송완료</small>
									</div>
								</div>
								<br>
								<hr>
							</div>
							
							<div class="col-md-12">
							<div class="form-row float-right">
									<button class="btn btn-sm btn-outline-success"
										id="advanced-set-submit">리뷰 작성</button>
								</div>
								<div class="d-flex align-items-center">
									<a href="/detail-1"> <svg class="img rounded-lg"
											style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg>
									</a>
									<div class="cart-title text-left ml-3">
										<a class="text-uppercase text-dark" href="/detail-1"> <strong>유기농
												사과 3개입</strong></a> <br> <small style="color: #f2864b;">주문번호
										</small> &nbsp; <small style="color: #696969;"> 2016546548</small> <Br>
										<small
											style="color: #f2864b;">주문수량 </small> &nbsp; <small
											style="color: #696969;"> 1개</small><br>
										<small style="color: #f2864b;">결제금액 </small> &nbsp;<small
											style="color: #696969;"> 8500원</small> <br> <small
											style="color: #f2864b;">주문상태 </small> &nbsp;<small
											style="color: #696969;"> 배송완료</small>
									</div>
								</div>
								<br>
								<hr>
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