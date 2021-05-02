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
.price>b { font-family: 'Roboto', serif; color:#F27024;}
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
</style>
</head>
<body>
   <!-- header -->
   <%@include file="../header.jsp" %>
	
	<!-- Page Content -->
	<div class="container mt-4">
		<div class="row">
		
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
							<h3 class="price text-right"><b>1,500</b> 원</h3>
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
					<div class="col-md-12" height="100%;">
				      <div class="shadow-sm rounded-lg">
				        <!-- Tabs-->
				        <ul class="nav nav-tabs nav-fill" role="tablist">
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active" >상세 정보</a></li>
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/shopping/apple/review' />">상품 리뷰</a></li>
				        </ul>
				        <div class="info-content px-4 pt-lg-3 pb-3 mb-5 border">
				          <div class="tab-content px-lg-3 py-5">
				            <!-- General info tab-->
				            <img style="width:100%;" alt="productInfo" src="http://chungjuc.com/web/upload/NNEditor/20201105/121_shop1_143841.jpg">
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
   <!-- Footer -->
   <%@include file="../footer.jsp" %>
</body>
</html>