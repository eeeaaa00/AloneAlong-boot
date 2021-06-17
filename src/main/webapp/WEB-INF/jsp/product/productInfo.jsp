<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div class="row mx-5 mb-5">
	<!-- 사진 -->
	<div class="col-md-6 my-3">
		<svg class="img"
			style="background-image: url('data:image/jpeg;base64,${product.img64}'); background-size: cover; background-position: center; width: 100%; height: 400px;"></svg>
	</div>
	<!-- 가격 정보 -->
	<div class="col-md-6 my-3" style="height: 400px">
		<div class="mx-2" style="height: 150px">
			<h1 class="text-right mb-3">${product.productName}</h1>
			<h3 class="text-right"><b class="text-orange-roboto">
				<fmt:formatNumber value="${product.productPrice}" pattern="#,###,###"/></b> 원</h3>
		</div>
		<div class="mx-2 my-2 priceInfo" style="height: 110px;">
			<form class="form-inline" action='<c:url value="/shop/${productId}"/>'>
				<p class="mb-3">
					<span class=" border-right pr-4 mr-4">수량　</span>
					<input class="form-control text-center w-25" name="quantity" type="number" value="${product.quantity}" min="1">
					<!-- 임시 버튼 -->
					<button class="btn btn-light" type="submit">수량변경</button>
				</p>
			</form>
			<p class="mb-2"><span class="border-right pr-4 mr-4">배송비</span>
				<fmt:formatNumber value="${product.shippingFee}" pattern="#,###,###"/>원</p>
			<small class="text-muted">30,000원 이상 구매시 무료 / 제주 · 도서 지역 추가 5,000원</small>
		</div>
		
		<!-- 임시 -->
		<form method="post">
		<input name="type" type="hidden" value="product">
		<input name="productId" type="hidden" value="${product.productId}">
		<input name="quantity" type="hidden" value="${product.quantity}">
		<div class="totalPriceInfo bg-light">
			<p class="text-right">총 금액 <b class="pl-2 text-roboto">
				<fmt:formatNumber value="${product.getUnitPrice()}" pattern="#,###,###"/></b>원</p>
			<div class="row justify-content-around">
				<button type="submit" class="btn btn-green rounded-pill"
					onclick="javascript: form.action='/cart/insert/${productId}/${product.quantity}/product';">
					<small><i class="fas fa-shopping-cart pr-1"></i></small> 장바구니</button>
				<button type="submit" class="btn btn-orange rounded-pill"
					onclick="javascript: form.action='/shop/order';">
					<small> <i class="far fa-credit-card pr-1"></i></small> 결제하기</button>
			</div>
		</div>
		</form>
	</div>
</div>