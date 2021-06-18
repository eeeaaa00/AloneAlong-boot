<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
function test() {	// click event handler for <td> including price
	$("#quantity").val(21);
};
function changeQuantity(){
	var nowQuantity = $("#quantity").val();
	var totalPrice = ${product.productPrice} * nowQuantity;
	if (totalPrice < 30000) {
	  totalPrice += ${product.shippingFee};
	}
	totalPrice = String(totalPrice).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#totalPrice").text(totalPrice);
};
</script>
<form method="get">
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
		<div class="my-4 priceInfo" style="height: 110px;">
			<p class="row px-3 mb-3 d-flex align-items-center">
				<span class=" border-right pr-4 mr-4">수량　</span>
				<input class="form-control text-center w-25" onchange="changeQuantity()" name="quantity" id="quantity" type="number" value="${product.quantity}" min="1">
			</p>
			<p class="row px-3 mb-2"><span class="border-right pr-4 mr-4">배송비</span>
				<fmt:formatNumber value="${product.shippingFee}" pattern="#,###,###"/>원</p>
			<small class="text-muted">30,000원 이상 구매시 무료 / 제주 · 도서 지역 추가 5,000원</small>
		</div>
		
		<!-- 임시 -->
		<input name="type" type="hidden" value="product">
		<input name="productId" type="hidden" value="${productId}">
		<div class="totalPriceInfo bg-light">
			<p class="text-right">총 금액 <b class="pl-2 text-roboto">
				<span id="totalPrice"><fmt:formatNumber value="${product.getUnitPrice()}" pattern="#,###,###"/></span></b>원</p>
			<div class="row justify-content-around">
				<button type="submit" class="btn btn-green rounded-pill"
					onclick="javascript: form.action='/cart/insert/${productId}/product';">
					<small><i class="fas fa-shopping-cart pr-1"></i></small> 장바구니</button>
				<button type="submit" class="btn btn-orange rounded-pill"
					onclick="javascript: form.action='/shop/order';">
					<small> <i class="far fa-credit-card pr-1"></i></small> 결제하기</button>
			</div>
		</div>
	</div>
</div>
</form>