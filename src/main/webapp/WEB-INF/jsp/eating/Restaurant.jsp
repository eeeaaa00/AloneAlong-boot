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
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
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
				<a href="<c:url value='/shopping' />" class="btn btn-outline-success rounded-pill my-1 btn-block active">지역</a>
					<a href="#" class="dropdown-menu active" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="#"><small>서울특별시</small></a>
								<a class="dropdown-item" href="#"><small>인천광역시</small></a>
								<a class="dropdown-item" href="#"><small>대구광역시</small></a>
								<a class="dropdown-item" href="#"><small>대전광역시</small></a>
								<a class="dropdown-item" href="#"><small>부산광역시</small></a>
								<a class="dropdown-item" href="#"><small>울산광역시</small></a>
								<a class="dropdown-item" href="#"><small>광주광역시</small></a>
					</a>
				<div class="dropdown btn-outline-success">
						<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
							aria-haspopup="true">최신순</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#"><small>서울특별시</small></a>
								<a class="dropdown-item" href="#"><small>인천광역시</small></a>
								<a class="dropdown-item" href="#"><small>대구광역시</small></a>
								<a class="dropdown-item" href="#"><small>대전광역시</small></a>
								<a class="dropdown-item" href="#"><small>부산광역시</small></a>
								<a class="dropdown-item" href="#"><small>울산광역시</small></a>
								<a class="dropdown-item" href="#"><small>광주광역시</small></a>
						</div>
					</div>	
				<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">분류</a>
					<a href="#" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="#"><small>분식</small></a>
								<a class="dropdown-item" href="#"><small>한식</small></a>
								<a class="dropdown-item" href="#"><small>양식</small></a>
			</div>
			<div class="col-md-10 my-1">
				<!-- 상단 설명 -->
				<div class="row mx-3">
					<div class="col-md-5">
						<h2 style="text-color: #29A65F;">식당</h2>
						총 <b>${restaurantList.size()}</b>개의 식당이 있습니다.
					</div>
					<div class="col-md-5"></div>
					<div class="col-md-2"></div>
				</div>
				<div class="mx-5 my-3 text-right">
					<div class="dropdown">
						<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
							aria-haspopup="true">최신순</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#"><small>과거순</small></a>
							<a class="dropdown-item" href="#"><small>인기순</small></a>
							<a class="dropdown-item" href="#"><small>낮은 가격순</small></a>
						</div>
					</div>
				</div>
				<button onClick="location.href='<c:url value='/eating/adminRes' />'">임시 식당등록버튼(마이페이지)</button>
				
				<!-- 물품 목록 -->
				<div class="row px-5 mb-lg-5 justify-content-between">
					<c:forEach var="res" items="${restaurantList}">
						<div class="card shadow-sm" type="button" onClick="location.href='<c:url value='/eating/' />${res.resId}'"> 
							<svg class="img" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); 
								background-size: cover; background-position: center" width="100%" height="150px"></svg>
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-start">
									<h6 class="card-text text-left">${res.resName}</h6>
									<a href="/" class="btn btn-outline-success btn-sm rounded-circle"><i
										class="fas fa-shopping-cart"></i></a></div>
								<p>별점 : 4.5</p>
								<p>주소 : ${res.resAddress} </p>
							</div>
						</div>
						<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
					</c:forEach>
	
				<!-- /.물품목록 -->
							
				<div class="row my-xl-5 justify-content-center">
					<div class="paginate mb-xl-5 btn-toolbar" role="toolbar">
					  <button type="button" class="btn"><i class="fas fa-chevron-left"></i></button>
					  <div class="btn-group"><button type="button" class="btn active rounded-circle" >1</button></div>
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
	<!-- /.container -->

   <!-- Footer -->
   <%@include file="../footer.jsp" %>
</body>
</html>