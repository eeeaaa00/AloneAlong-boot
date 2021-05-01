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
<title>쇼핑</title>
<style type="text/css">
.orange { font-family: 'Roboto', serif; color:#F27024;}
p>b { font-family: 'Roboto', serif; font-size:30px; }
.totalPriceInfo {width:100%; height:130px;  border-radius: 20px; padding:10px 20px 10px 20px;}
.praceInfo>form { width:50px;}
.totalPriceInfo>div>.btn { width:160px; height:45px;  }
.btn-green { background-color:#FFFFFF; color:#29A65F; border-color :#29A65F; }
.btn-orange { background-color:#FFFFFF; color:#F27024; border-color :#F27024; }
.btn-green:hover, .btn-green:focus {  color:#FFFFFF; background-color:#29A65F; }
.btn-orange:hover, .btn-orange:focus {  color:#FFFFFF; background-color:#F27024; }
.nav { border-color:#29A65F; }
.nav-link { border-color:#29A65F; color:#29A65F; }
.nav-item>.nav-link.active, .nav-link:hover, .nav-link:focus { border-color:#29A65F; background-color:#29A65F; color:#FFFFFF;}
.green-roboto {font-family: 'Roboto', serif; color:#29A65F;}
.green { color:#29A65F;}
.paginate>button { color:gray; }
.paginate>div>button:hover, .paginate>button:hover { color:#29A65F; font-weight:bold; text-decoration: none;}
.paginate>div>button:focus, .paginate>div>button.active { color:#FFFFFF; background-color:#29A65F; }
</style>
</head>
<body>
   <!-- header -->
   <%@include file="../header.jsp" %>
	<!-- Page Content -->
	<div class="container mt-4">
		<div class="row">
			<!-- 좌측 카테고리 -->
			<div class="col-md-2">
				<a href="<c:url value='/shopping' />" class="btn btn-outline-success rounded-pill my-1 btn-block active">소량 과일</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">소량 채소</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">소량 육류</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">소량 식재료</a>
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">밀키트</a>
			</div>
			
			<div class="col-md-10 my-1">
				<div class="row mx-5 mb-5">
					<!-- 사진 -->
					<div class="col-md-6 my-3">
						<svg class="img" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); 
								background-size: cover; background-position:center; width:100%; height:400px;"></svg>
					</div>
					<!-- 가격 정보 -->
					<div class="col-md-6 my-3" style="height:400px">
						<div class="mx-2" style="height:150px">
							<h1 class="text-right mb-3">유기농 사과 3개입</h1>
							<h3 class="orange text-right"><b>1,500</b> 원</h3>
						</div>
						<div class="mx-2 my-2 priceInfo" style="height:110px;">
							<form class="form-inline">
							<p class="mb-3"><span class=" border-right pr-4 mr-4">수량　</span>
								<input class="form-control text-center w-25" type="number" value="1" min="1"></p>
							</form>
							<p class="mb-2"><span class="border-right pr-4 mr-4">배송비</span> 3,000원</p>
							<small class="text-muted">30,000원 이상 구매시 무료 / 제주 · 도서 지역 추가 5,000원</small>
						</div>
						<div class="totalPriceInfo bg-light">
							<p class="text-right">총 금액  <b class="pl-2">4,500</b>원</p>
							<div class="row justify-content-around">
								<a type="button" class="btn btn-green rounded-pill" data-toggle="modal" data-target="#cartModal">
									<small><i class="fas fa-shopping-cart pr-1"></i></small> 장바구니</a>
								<a type="button" class="btn btn-orange rounded-pill" href="<c:url value='/order' />"><small>
									<i class="far fa-credit-card pr-1"></i></small> 결제하기</a>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 상품 정보 -->
				<div class="row my-5 mx-5">
					<div class="col-md-12" style="width:100%;">
				      <div class="shadow-sm rounded-lg">
				        <!-- Tabs-->
				        <ul class="nav nav-tabs nav-fill" role="tablist">
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/shopping/apple' />" >상세 정보</a></li>
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active">상품 리뷰</a></li>
				        </ul>
				        
				        <!-- 내용 -->
				        <div class="review-content pb-3 mb-5 border">
				          <!-- 상단 리뷰 통계 -->
				          <div class="bg-light py-5">
				          	<div class="row align-items-center">
				          		<div class="col-md-1"></div>
				          		<div class="col-md-3 text-center">
				          			<h4><i class="green fas fa-comment-dots"></i></h4>
				          			<h4 class="green pb-1">리뷰 수</h4>
				          			<h4><b class="orange">56</b><small> 개</small></h4>
				          		</div>
				          		<div class="col-md-4 text-center align-items-center">
				          			<h4><i class="far green fa-star"></i></h4>
				          			<h4 class="green pb-1">평균 평점</h4>
				          			<h4><b class="orange">3.6</b><small> 점</small></h4>
				          		</div>
				          		<div class="col-md-3 text-center align-items-center">
				          			<h4><i class="green fas fa-signal"></i></h4>
				          			<h4 class="green pb-1">최다 평점</h4>
				          			<h4><b class="orange">4</b><small> 점</small></h4>
				          		</div>
				          		<div class="col-md-1"></div>
				          	</div>
				          </div>

						  <div class="px-5 pt-lg-5">
						   <!-- 상단 -->
							<div class="d-flex justify-content-between pb-4 px-4 border-bottom mb-4">
							
							<!-- 드롭다운 -->
							<div class="dropdown">
								<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true">최신순</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" href="#"><small>좋아요순</small></a>
										<a class="dropdown-item" href="#"><small>높은 평점순</small></a>
										<a class="dropdown-item" href="#"><small>낮은 평점순</small></a>
									</div>
							</div>
							<!-- 리뷰 작성 -->
							<button type="button" class="btn btn-sm btn-orange rounded-pill px-3"
								data-toggle="modal" data-target="#exampleModal"><i class="far fa-edit"></i> 작성하기</button>
						</div>

						<!-- 리뷰 목록 -->
						<div class="product-review mx-4 pb-4 mb-4 border-bottom">
							<div class="d-flex align-middle me-4 pe-2">
								<h6 class="green-roboto px-2">5</h6>
								<div class="star-rating green">
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
								</div>
							</div>
							<div class="text-muted ml-2">
								<small>공지수 | 2021.04.06</small>
							</div>
							<div class="mx-4 my-2">
								<div class="my-3">
									첫구매도 맛이 달콤달콤 새콤새콤해서 너무맛있게 먹어서 두번째로시키게되었는데요<br>배송은 역시나
									빨랐어요 새벽에 받자마자 열어보았는데 사과냄새향수가있나할정도였어요😚
								</div>
								<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green far fa-thumbs-up"></i>
									<span class="green-roboto">25</span><small class="text-muted"> 명이 추천</small></div>
							</div>
						</div>
						<!-- 리뷰 목록 -->
						<div class="product-review mx-4 pb-4 mb-4 border-bottom">
							<div class="d-flex align-middle me-4 pe-2">
								<h6 class="green-roboto px-2">2</h6>
								<div class="star-rating green">
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="far fa-star"></i>
									<i class="far fa-star"></i>
									<i class="far fa-star"></i>
								</div>
							</div>
							<div class="text-muted ml-2">
								<small>공지수 | 2021.04.06</small>
							</div>
							<div class="mx-4 my-2">
								<div class="my-3">
									걍 그래요...
								</div>
								<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green fas fa-thumbs-up"></i>
									<span class="green-roboto">3</span><small class="text-muted"> 명이 추천</small></div>
							</div>
						</div>
						<!-- 리뷰 목록 -->
						<div class="product-review mx-4 pb-4 mb-4 border-bottom">
							<div class="d-flex align-middle me-4 pe-2">
								<h6 class="green-roboto px-2">4</h6>
								<div class="star-rating green">
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="far fa-star"></i>
								</div>
							</div>
							<div class="text-muted ml-2">
								<small>공지수 | 2021.04.06</small>
							</div>
							<div class="mx-4 my-2">
								<div class="my-3">
									싸고 필요한 만큼만 있어서 좋아요 맛있어요
								</div>
								<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green far fa-thumbs-up"></i>
									<span class="green-roboto">0</span><small class="text-muted"> 명이 추천</small></div>
							</div>
						</div>
						<!-- 페이지네이션 -->
						<div class="row my-xl-5 justify-content-center">
							<div class="paginate mb-xl-2 btn-toolbar" role="toolbar">
								<button type="button" class="btn"> <i class="fas fa-chevron-left"></i></button>
								<div class="btn-group"><button type="button" class="btn active rounded-circle">1</button></div>
								<div class="btn-group"><button type="button" class="btn rounded-circle">2</button></div>
								<div class="btn-group"><button type="button" class="btn rounded-circle">3</button></div>
								<div class="btn-group"><button type="button" class="btn rounded-circle">4</button></div>
								<div class="btn-group"><button type="button" class="btn rounded-circle">5</button></div>
								<button type="button" class="btn"><i class="fas fa-chevron-right"></i></button>
							</div>
						</div>
					</div>
					</div>
				</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<!-- Modal -->
	<!-- 장바구니 -->
	<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content py-5">
				<div class="modal-body text-center pb-4">
					<h6>상품이 장바구니에 담겼습니다.</h6>
					<h6>장바구니로 이동하시겠습니까?</h6>
				</div>
				<div class="row mx-5 mb-2 justify-content-center">
					<a type="button" class="btn btn-green rounded-pill mx-2 py-2 px-3" data-dismiss="modal">쇼핑 계속하기</a>
					<a type="button" class="btn btn-orange rounded-pill mx-2 py-2 px-3" href="<c:url value='/shopping/cart' />" >장바구니 보기</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 리뷰 작성 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content pb-4">
				<div class="modal-header">
					<h5 class="modal-title">리뷰 작성</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="form">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<select name="rating" id="rating"
										class="custom-select focus-shadow-0">
										<option value="5">★★★★★ (5/5)</option>
										<option value="4">★★★★☆ (4/5)</option>
										<option value="3">★★★☆☆ (3/5)</option>
										<option value="2">★★☆☆☆ (2/5)</option>
										<option value="1">★☆☆☆☆ (1/5)</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<textarea rows="4" name="review" id="review"
								placeholder="리뷰를 작성하세요" required="" class="form-control"></textarea>
						</div>
					</form>
				</div>
				<div class="text-center">
					<button type="button" class="btn btn-orange rounded-pill w-25 pb-2">작성하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
   <%@include file="../footer.jsp" %>
</body>
</html>