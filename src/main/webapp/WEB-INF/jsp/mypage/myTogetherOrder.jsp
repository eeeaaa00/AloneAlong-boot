<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="togetherOrder" items="${orderList}">
<div class="col-md-12">
	<div class="form-row float-right">
		<a href="<c:url value='/shopping/apple/review' />"><button class="btn btn-sm btn-outline-success" id="advanced-set-submit">리뷰 작성</button></a>
	</div>
	<div class="d-flex align-items-center">
		<a href="/together/${togetherOrder.together.togetherId}"> <svg class="img rounded-lg" style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg></a>
		<div class="cart-title text-left ml-3">
			<a class="text-uppercase text-dark" href="/together/${togetherOrder.together.togetherId}"> <strong><c:out value="${togetherOrder.together.togetherName}"/></strong></a><br> 
			<small style="color: #f2864b;">주문번호 </small>&nbsp;
			<small style="color: #696969;"> <c:out value="${togetherOrder.orderId}"/></small> <Br> 
			<small style="color: #f2864b;">예약 날짜/시간 </small> &nbsp; 
			<small style="color: #696969;"> <c:out value="${togetherOrder.together.togetherDate}"/> / <c:out value="${togetherOrder.together.togetherTime}"/></small><br> 
			<small style="color: #f2864b;">결제금액 </small> &nbsp;
			<small style="color: #696969;"> <c:out value="${togetherOrder.together.price}"/>원</small><br>
			<small style="color: #f2864b;">주문상태 </small> &nbsp;
			<small style="color: #696969;"> 결제완료</small>
			<small style="color: #f2864b;">모집상태 </small> &nbsp;
			<c:if test="${togetherOrder.together.state eq 1}">
				<small style="color: #696969;"> 모집완료</small>
			</c:if>
			<c:if test="${togetherOrder.together.state eq 0}">
				<small style="color: #696969;"> 모집중</small>
			</c:if>
		</div>
	</div>
	<br>
	<hr>
</div>
</c:forEach>