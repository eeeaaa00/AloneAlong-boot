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

<div class="row mx-5 mb-5" name="FoodInfoWithCart">
	<!-- 사진 -->
	<div class="col-md-6 my-3">
		<svg class="img" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); 
				background-size: cover; background-position:center; width:100%; height:400px;"></svg>
	</div>
	<!-- 가격 정보 -->
	<div class="col-md-6 my-3" style="height:400px">
		<div class="mx-2" style="height:150px">
			<h1 class="text-right mb-3">${restaurant.resName}</h1>
			<h4 class="price text-right"><b>${restaurant.resAddress}</b></h4>
		</div>
		<div class="mx-2 my-2 priceInfo" style="height:110px;">
			<p class="mb-2"><span class="border-right pr-4 mr-4">번호 </span> ${restaurant.resPhone} </p><nbsp>
			<p class="mb-2"><span class="border-right pr-4 mr-4">별점 </span> ${restaurant.avgRating} 점</p><nbsp>
			<p class="mb-2">${restaurant.resDescription}</p>
			<small class="text-muted"></small>
		</div>
		<div class="totalPriceInfo bg-light">
			<p class="text-left">구매할 것</p>
			<div name="foodCart">
				<c:forEach var="food" items="${foodCart}">
			       <p class="mb-3">
					<span class=" border-right pr-4 mr-4">${food.name}</span>
					<input class="form-control text-center w-25" name="quantity" type="number" value="${food.quantity}" min="1">
				</p>
				</c:forEach>
				<button class="btn btn-light" type="submit" onClick="location.href='<c:url value='/eating/${restaurant.resId}/updateFoodCartQuantities' />'">수량변경</button>
			</div>
			<p class="text-right">총 금액  <b class="pl-2">4,500</b>원</p>
			<div class="row justify-content-around">
				<a type="button" class="btn btn-orange rounded-pill" href="<c:url value='/order' />"><small>
					<i class="far fa-credit-card pr-1"></i></small> 결제하기</a>
			</div>
		</div>
	</div>
</div>