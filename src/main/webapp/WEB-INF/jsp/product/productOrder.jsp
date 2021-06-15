<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- for Icon -->
<script src="https://kit.fontawesome.com/cfb4151af4.js"></script>
<!-- 구글폰트링크 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&family=Roboto&display=swap" rel="stylesheet">
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
.btn-orange { background-color:#FFFFFF; color:#F27024; border-color :#F27024; }
.btn-orange:hover, .btn-orange:focus {  color:#FFFFFF; background-color:#F27024; }
.totalPrice {  font-family: 'Roboto', serif; color:#F27024; }
</style>
</head>
<body>
   <tiles:insertAttribute name="header" />
	
	<!-- Page Content -->
	<div class="container my-5 pb-5">
	    <div class="container col-md-10 mx-auto mb-3">
		<div class=" mb-3 pb-3 text-center">
			<h1>Order</h1></div>
			<!-- 주문 정보 -->
			<!-- 주문 목록 -->
			<form:form modelAttribute="productOrderForm" action="/shop/order/confirm" class="needs-validation" novalidate="">
			<tiles:insertAttribute name="lineItem" /> <!-- 주문 목록 -->
			<tiles:insertAttribute name="orderInfo" /> <!-- 주문 정보 -->
			<tiles:insertAttribute name="shipInfo" /> <!-- 배송 정보 -->
			<tiles:insertAttribute name="paymentInfo" /> <!-- 결제 정보 -->	
			</form:form>
		</div>
	</div>
	<!-- /.container -->
	<!-- Modal -->
    <tiles:insertAttribute name="footer" />
</body>
</html>