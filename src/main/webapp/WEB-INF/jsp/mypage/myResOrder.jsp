<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:forEach var="foodOrder" items="${foodOrderList}">
<script>
$(function(){
	$("#cancel${foodOrder.orderId}").click(function() {
		$("#cancelModal").modal("show");
	});

});

$(document).ready(function() {
	
	var visitDate = "${foodOrder.visitDate}";
	visitDate = visitDate.split(",");
	console.log("date", visitDate[0]);
	var date = new Date();
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();
	
	if (month < 10) month = "0" + month;
	if (day < 10) day = "0" + day;
	
	var today = year + "-" + month + "-" + day;  
	console.log("today", today);
	
	if(visitDate <= today){
		$("#cancel${foodOrder.orderId}").css("visibility", "hidden");
	}
});
</script>
<!-- modal -->
<div class="modal fade" id="cancelModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content py-5">
			<div class="modal-body text-center pb-4">
				<h6>정말로 예약을 취소하시겠습니까?</h6>
				<a style="color:red;">※당일 예약 및 당일 취소는 불가능합니다.</a>
			</div>
			<div class="row mx-5 mb-2 justify-content-center">
			<a type="button" class="btn btn-green rounded-pill mx-2 py-2 px-3" data-dismiss="modal">돌아가기</a>
				<a type="button" class="btn btn-orange rounded-pill mx-2 py-2 px-3" 
				href="<c:url value='/eating/order/delete'><c:param name="orderId" value='${foodOrder.orderId}'/></c:url>" >취소하기</a>
				
			</div>
		</div>
	</div>
</div>
	<div class="col-md-12">
		<div class="form-col float-right">
			<a href="<c:url value='/eating/${foodOrder.resId}/RestaurantReview' />">
				<button class="btn btn-sm btn-outline-success mb-1"
					id="advanced-set-submit">리뷰 작성</button>
			</a>
			<br>
			<a id="cancel${foodOrder.orderId}" >
				<button class="btn btn-sm btn-outline-warning"
					id="advanced-set-submit">예약 취소</button>
			</a>
		</div>
		<div class="form-row float-right">
			
		</div>
		<div class="d-flex align-items-center">
			<a href="/eating/${foodOrder.resId}"> <img src="data:image/jpeg;base64,${foodOrder.img64}" style="width: 100px; height: 100px; object-fit: cover;">
			</a>
			<div class="cart-title text-left ml-3">
				<a class="text-uppercase text-dark" href="/eating/${foodOrder.resId}"> <strong>${foodOrder.resName}</strong></a> <br> 
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
						href="#collapse${foodOrder.orderId}" aria-expanded="false"><small style="color: #f2864b;">>>주문상세내역</small></a>
				</div>
				<div id="collapse${foodOrder.orderId}" class="panel-collapse collapse" role="tabpanel">
					<div class="panel-body m-1 round-pill" style="font-size:smaller;">
					<hr>
					<c:forEach var="item" items="${foodOrder.orderedList}">
					${item.foodName} x ${item.quantity} = ${item.unitPrice}원<br>
					</c:forEach>
					<hr>
					총합 : ${foodOrder.totalPrice}원
					<hr>
					</div>
				</div>
			</div>
		</div>
		<br>
		<hr>
</div>
</c:forEach>

