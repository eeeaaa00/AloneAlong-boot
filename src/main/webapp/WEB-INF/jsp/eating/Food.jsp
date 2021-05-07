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
							<h1 class="text-right mb-3">${restaurant.resName}</h1>
							<h4 class="price text-right"><b>${restaurant.resAddress}</b></h3>
						</div>
						<div class="mx-2 my-2 priceInfo" style="height:110px;">
							<form class="form-inline">
							<p class="mb-2"><span class="border-right pr-4 mr-4">번호 </span> 0507-1415-7178 </p><nbsp>
							<p class="mb-2"><span class="border-right pr-4 mr-4">별점 </span> 4.5 점</p><nbsp>
							<p class="mb-2">태국식 캐쥬얼 레스토랑 누들아한타이입니다. 태국현지식 자재를 사용하여 태국음식의 풍미를 자랑합니다.</p>
							<small class="text-muted"></small>
						</div>
						<div class="totalPriceInfo bg-light">
							<p class="text-left">구매할 것</p>
							<div>
							미니카트
							</div>
							<p class="text-right">총 금액  <b class="pl-2">4,500</b>원</p>
							<div class="row justify-content-around">
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
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active" href="<c:url value='/eating/'/> ${res.resId}">메뉴</a></li>
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/eating/res01/RestaurantReview' />">한줄평</a></li> <!-- mav.setViewName("/eating/RestaurantReview");로 연결 -->
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" >같밥 모집ing</a></li>
				        </ul>
				        <!-- General info tab-->
				        <div class="tab-content px-lg-3 py-5">
				        <div class="info-content px-4 pt-lg-3 pb-3 mb-5 border">
				        <button onClick="location.href='<c:url value='/eating/r2/adminFood/'/> />'">메뉴 추가</button> <!-- 여기 r2라고 해놨으니 바꿔야해 -->
				        <c:forEach var="food" items="${foodList}">
							<div class="card shadow-sm m-2">
				            <div class="row no-gutters">
				              <div class="col-4">
				                <img src="https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg" width="100%" height="150px" />
				              </div>
				                <div class="card-body">
					                <div class="d-flex justify-content-between align-items-start py-2" >
									<h6 class="card-text text-left">${food.name}</h6>
									</div>
									<p>설명</p>
									<p>${food.price}원 </p>  
				              </div>
				              <div class="card-footer">
					              <button>담기</button></br>
					              <button type="button" onClick="location.href='<c:url value='/eating/viewFood/food01/adminFood' />'">수정</button>
					              <button>삭제</button>
				              </div>
				              
				            </div>
				          </div>
						<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
					</c:forEach>
				          
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
   <!-- Footer -->
   <%@include file="../footer.jsp" %>
</body>
</html>