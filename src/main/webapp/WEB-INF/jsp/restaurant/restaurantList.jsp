<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>a{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>

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
		<button onClick="location.href='<c:url value='/eating/adminRes' />'">임시 식당등록버튼(마이페이지)</button>
	</div>
	
	
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