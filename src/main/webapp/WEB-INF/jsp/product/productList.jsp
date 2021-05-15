<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>button{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>

<!-- 물품 목록 -->
<div class="row px-5 mb-lg-5 justify-content-between">
<c:forEach items="${productList}" var="product" varStatus="idx">
<c:if test="${idx.index % 3 == 0}">
</div>
<div class="row px-5 mb-lg-5 justify-content-between">
</c:if>
	<form action='<c:url value="/shop"/>' method="post">
	<input name="productId" type="hidden" value="${product.productId}"/>
	<div class="card shadow-sm">
		<div class="contents">
			<svg class="img"
				style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center"
				width="100%" height="150px"></svg>
			<div class="card-body">
				<div class="d-flex justify-content-between align-items-start">
					<h6 class="card-text text-left"><c:out value="${product.productName}"/></h6>
					<button type="submit" class="btn btn-green btn-sm rounded-circle">
						<i class="fas fa-shopping-cart"></i></button>
				</div>
				<p><c:out value="${product.productPrice}"/>원</p>
				<c:if test="${product.productStock == 0}">					
					<small class="sold-out text-center rounded-pill">품절</small>
				</c:if>
			</div>
		</div>
		<div class="overlay" type="button"
			onClick="location.href='<c:url value='/shop/${product.productId}' />'"></div>
	</div>
	</form>
</c:forEach>
</div>
<div class="row px-5 mb-lg-5 justify-content-between">
	
	
	
</div>
<!-- (임시) view 구성용 반복  -->
<c:forEach begin="2" end="5">
	<div class="row px-5 my-5 justify-content-between">
		<!-- (임시) view 구성용 반복 -->
		<div class="card shadow-sm">
			<svg class="img"
				style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center"
				width="100%" height="150px"></svg>
			<div class="card-body">
				<div class="d-flex justify-content-between align-items-start">
					<h6 class="card-text text-left">유기농 사과 3개입</h6>
					<a href="/" class="btn btn-outline-success btn-sm rounded-circle"><i
						class="fas fa-shopping-cart"></i></a>
				</div>
				<p>1,500원</p>
			</div>
			<div class="overlay" type="button"
				onClick="location.href='<c:url value='/shopping/apple' />'"></div>
		</div>
		<div class="card shadow-sm">
			<svg class="img"
				style="background-image: url('https://img-cf.kurly.com/shop/data/goods/161544350511y0.jpg'); background-size: cover; background-position: center"
				width="100%" height="150px"></svg>
			<div class="card-body">
				<div class="d-flex justify-content-between align-items-start">
					<h6 class="card-text text-left">유기농 귤 5개입</h6>
					<a href="/" class="btn btn-outline-success btn-sm rounded-circle"><i
						class="fas fa-shopping-cart"></i></a>
				</div>
				<p>3,000원</p>
				<small class="sold-out text-center rounded-pill">품절</small>
			</div>
			<div class="overlay" type="button"
				onClick="location.href='<c:url value='/shopping/apple' />'"></div>
		</div>
		<div class="card shadow-sm">
			<svg class="img"
				style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1617175056507y0.jpg'); background-size: cover; background-position: center"
				width="100%" height="150px"></svg>
			<div class="card-body">
				<div
					class="d-flex justify-content-between align-items-start rounded-circle">
					<h6 class="card-text text-left">컷팅 수박 500g</h6>
					<a href="/" class="btn btn-outline-success btn-sm rounded-circle"><i
						class="fas fa-shopping-cart"></i></a>
				</div>
				<p>1,500원</p>
			</div>
			<div class="overlay" type="button"
				onClick="location.href='<c:url value='/shopping/apple' />'"></div>
		</div>
	</div>
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