<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- for Icon -->
<script src="https://kit.fontawesome.com/cfb4151af4.js"></script>
<!-- 구글폰트링크 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&family=Roboto&display=swap" rel="stylesheet">
<title>Alone & Along</title>
<style type="text/css">
.btn-orange { background-color:#FFFFFF; color:#F27024; border-color :#F27024; }
.btn-orange:hover, .btn-orange:focus {  color:#FFFFFF; background-color:#F27024; }
</style>
</head>
<body>
   <!-- header -->
   <%@include file="../header.jsp" %>
	
	<!-- Page Content -->
	<div class="container my-5 pb-5">
			<div class=" mb-3 pb-3 text-center">
				<h1 class="mb-5">Shopping cart</h1>
			</div>
			<div class="container">
				<div class="mb-5 row">
					<div class="col-lg-8">
						<div class="cart">
							<div class="cart-header text-center mb-3 pb-3 border-bottom">
								<div class="row">
									<div class="col-md-5">상품</div>
									<div class="d-none d-md-block col">
										<div class="row">
											<div class="col-md-3">가격</div>
											<div class="col-md-3">수량</div>
											<div class="col-md-3">총액</div>
											<div class="col-md-2"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="cart-body">
								<!-- 아이템 1 -->
								<div class="cart-item mb-3">
									<div class=" d-flex align-items-center text-left text-md-center row">
										<div class="col-12 col-md-5">
											<div class="d-flex align-items-center">
												<a href="/detail-1">
													<svg class="img rounded-lg" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); 
														background-size: cover; background-position:center; width:100px; height:100px;"></svg>
														</a>
												<div class="cart-title text-left ml-3">
													<a class="text-uppercase text-dark" href="/detail-1">
													<strong>유기농 사과 3개입</strong></a>
												</div>
											</div>
										</div>
										<div class="mt-4 mt-md-0 col-12 col-md-7">
											<div class="align-items-center row">
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">1,500원</div>
													</div>
												</div>
												<div class="col-md-3 text-center">
													<div class="row text-center my-auto">
														<div class="input-group">
															<div class="input-group-prepend"><button class="btn btn-light" type="button">-</button></div>
															<input type="text" class="form-control text-center" value="2">
															<div class="input-group-append"><button class="btn btn-light" type="button">+</button></div>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">3,000원</div>
													</div>
												</div>
												<div class="d-none d-md-block text-center col-2">
													<a class="cart-remove text-success" href="#"><i
														class="delete fa fa-times"></i></a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 아이템 2 -->
								<div class="cart-item mb-3">
									<div
										class=" d-flex align-items-center text-left text-md-center row">
										<div class="col-12 col-md-5">
											<div class="d-flex align-items-center">
												<a href="/detail-1">
													<svg class="img rounded-lg" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/161544350511y0.jpg'); 
														background-size: cover; background-position:center; width:100px; height:100px;"></svg>
														</a>
												<div class="cart-title text-left ml-3">
													<a class="text-uppercase text-dark" href="/detail-1">
													<strong>유기농 귤 5개입</strong></a>
												</div>
											</div>
										</div>
										<div class="mt-4 mt-md-0 col-12 col-md-7">
											<div class="align-items-center row">
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">3,000원</div>
													</div>
												</div>
												<div class="col-md-3 text-center">
													<div class="row text-center my-auto">
														<div class="input-group">
															<div class="input-group-prepend"><button class="btn btn-light" type="button">-</button></div>
															<input type="text" class="form-control text-center" value="3">
															<div class="input-group-append"><button class="btn btn-light" type="button">+</button></div>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">9,000원</div>
													</div>
												</div>
												<div class="d-none d-md-block text-center col-2">
													<a class="cart-remove text-success" href="#"><i
														class="delete fa fa-times"></i></a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 아이템 3 -->
								<div class="cart-item mb-3">
									<div
										class=" d-flex align-items-center text-left text-md-center row">
										<div class="col-12 col-md-5">
											<div class="d-flex align-items-center">
												<a href="/detail-1">
													<svg class="img rounded-lg" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1617175056507y0.jpg'); 
														background-size: cover; background-position:center; width:100px; height:100px;"></svg>
														</a>
												<div class="cart-title text-left ml-3">
													<a class="text-uppercase text-dark" href="/detail-1">
													<strong>컷팅 수박 500g</strong></a>
												</div>
											</div>
										</div>
										<div class="mt-4 mt-md-0 col-12 col-md-7">
											<div class="align-items-center row">
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">1,500원</div>
													</div>
												</div>
												<div class="col-md-3 text-center">
													<div class="row text-center my-auto">
														<div class="input-group">
															<div class="input-group-prepend"><button class="btn btn-light" type="button">-</button></div>
															<input type="text" class="form-control text-center" value="1">
															<div class="input-group-append"><button class="btn btn-light" type="button">+</button></div>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="row">
														<div class="text-right text-md-center col-6 col-md-12">1,500원</div>
													</div>
												</div>
												<div class="d-none d-md-block text-center col-2">
													<a class="cart-remove text-success" href="#"><i
														class="delete fa fa-times"></i></a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="mb-5">
							<div class="bg-light py-4 rounded-lg px-4">
								<h3 class="mt-2 mb-5 text-uppercase">주문 합계</h3>
								<div class="py-1 pt-3 px-3 row justify-content-between border-bottom">
										<span>상품 금액</span><span>13,500원</span></div>
								<div class="py-1 pt-3 px-3 row justify-content-between border-bottom">
										<span>배송비</span><span>3,000원</span></div>
								<div class="py-1 pt-3 px-3 row align-items-end justify-content-between border-bottom">
										<span>합계</span><h4>16,500원</h4></div>
								<div class="row justify-content-center">
								<a type="button" class="btn btn-orange btn-block rounded-pill py-3 my-1 mt-3 mx-3" href="<c:url value='/order' />">
									<small><i class="far fa-credit-card pr-1"></i></small> 결제하기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

   <!-- Footer -->
   <%@include file="../footer.jsp" %>
</body>
</html>