<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
div.shipInfo{
	display:none;
}
</style>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10 bg-light rounded-lg py-3">
		<div class="cart">
			<div class="cart-header text-center mb-3 pb-3 border-bottom">
				<div class="row">
					<div class="col-md-7">상품</div>
					<div class="d-none d-md-block col">
						<div class="row">
							<div class="col-md-3">가격</div>
							<div class="col-md-3">수량</div>
							<div class="col-md-3">총액</div>
						</div>
					</div>
				</div>
			</div>
			<div class="cart-body">
				<!-- 아이템 1 -->
				<c:forEach items="${foodCart}" var="item" varStatus="idx">
					<div class="cart-item mb-3">
						<div
							class=" d-flex align-items-center text-center text-md-center row">
							<div class="col-12 col-md-7">
								<div class="d-flex align-items-center">
									<a href="/detail-1"> <svg class="img rounded-lg"
											style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg>
									</a>
									<div class="cart-title text-left ml-3">
										<a class="text-uppercase text-dark" href="/detail-1"> <strong>${item.food.name}</strong></a>
									</div>
								</div>
							</div>
							<div class="mt-4 mt-md-0 col-md-5">
								<div class="align-items-center row">
									<div class="col-md-3"> ${item.food.price}원 </div>
									<div class="col-md-3 text-center"> ${item.quantity} </div>
									<div class="col-md-3"> ${item.food.price * item.quantity}원 </div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<div class="row align-items-end mt-3 mb-5">
	<div class="col-md-1"></div>
	<div class="row d-flex align-items-center justify-content-end col-md-10 border-bottom pb-2">
		<span class="px-3">합계</span><h4 class="totalPrice">${totalPrice}</h4><span class="px-1">원</span></div>
</div>
