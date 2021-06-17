<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="foodOrder" items="${foodOrderList}">
	<div class="col-md-12">
		<div class="form-row float-right">
			<a href="<c:url value='/eating/${foodOrder.resId}/RestaurantReview' />">
				<button class="btn btn-sm btn-outline-success"
					id="advanced-set-submit">리뷰 작성</button>
			</a>
		</div>
		<div class="d-flex align-items-center">
			<a href="/detail-1"> <img src="data:image/jpeg;base64,${foodOrder.img64}" style="width: 100px; height: 100px;">
			</a>
			<div class="cart-title text-left ml-3">
				<a class="text-uppercase text-dark" href="/detail-1"> <strong>${foodOrder.resName}</strong></a> <br> 
				<small style="color: #f2864b;">예약종류 </small> &nbsp; <small style="color: #696969;"> ${foodOrder.reserveType}</small> <Br> 
				<small style="color: #f2864b;">예약시간 </small> &nbsp; <small style="color: #696969;"> ${foodOrder.visitDate}</small><br> 
				<small style="color: #f2864b;">결제금액 </small> &nbsp;<small style="color: #696969;"> ${foodOrder.totalPrice}원</small> <br> 
				<small style="color: #f2864b;">결제일시 </small> &nbsp;<small style="color: #696969;"> ${foodOrder.orderDate}</small>
			</div>
		</div>
		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab">
					<a role="button btn-lg" data-toggle="collapse" data-parent="#accordion"
						href="#collapse${foodOrder.orderId}" aria-expanded="false"> >>주문상세내역 </a>
				</div>
				<div id="collapse${foodOrder.orderId}" class="panel-collapse collapse" role="tabpanel">
					<div class="panel-body m-1 p-2">
					<c:forEach var="item" items="${foodOrder.orderedList}">
					${item.foodName} x ${item.quantity} = ${item.unitPrice}원<hr>
					</c:forEach>
					총합 : ${foodOrder.totalPrice}원
					</div>
				</div>
			</div>
		</div>
		<br>
		<hr>
</div>
</c:forEach>