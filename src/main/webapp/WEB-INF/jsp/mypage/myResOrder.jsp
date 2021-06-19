<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:forEach var="foodOrder" items="${foodOrderList}">
<script>
$(function(){
	$("#cancel${foodOrder.orderId}").click(function() {
		$("#cancelModal").modal("show");
		$("#cancelOrder").attr("href","<c:url value='/eating/order/delete'><c:param name="orderId" value='${foodOrder.orderId}'/></c:url>");
	});
	$("#review${foodOrder.resId}").click(function() {
		$("#reviewModal").modal("show");
		$("#reviewOrder").attr("action","<c:url value="/eating/${foodOrder.resId}/writeReview"/>");
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
				<a id="cancelOrder" type="button" class="btn btn-orange rounded-pill mx-2 py-2 px-3">취소하기</a>
				
			</div>
		</div>
	</div>
</div>
<!-- 리뷰 작성 -->
<div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-hidden="true">
	<form id="reviewOrder" class="form" >
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content pb-4">
				<div class="modal-header">
					<h5 class="modal-title">리뷰 작성</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<select name="rating" id="rating"
									class="custom-select focus-shadow-0">
									<option value="5">★★★★★</option>
									<option value="4">★★★★☆</option>
									<option value="3">★★★☆☆</option>
									<option value="2">★★☆☆☆</option>
									<option value="1">★☆☆☆☆</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<textarea rows="4" name="review" id="review" maxlength=80
							placeholder="수정이 불가하오니 신중히 리뷰를 작성하세요.(80자)" required="" class="form-control"></textarea>
					</div>
				
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-orange rounded-pill w-25 pb-2" >작성하기</button>
			</div>
		</div>
	</div>
	</form>
</div>
	<div class="col-md-12">
		<div class="form-col float-right">
			<a id="review${foodOrder.resId}">
				<button class="btn btn-sm btn-outline-success mb-1" data-toggle="modal" data-target="#exampleModal"
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

