<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<title>togetherPay</title>
</head>
<body>
<!-- header -->
<%@include file="../tiles/header.jsp" %>

<div class="container my-5 pb-5">
	<div class="container col-md-10 mx-auto mb-3">
		<div class=" mb-3 pb-3 text-center"><h1>Order</h1></div>
		
		<!-- 신청확인 -->	
		<div class="py-5"><h4>신청확인<strong class="d-inline-block mb-2 text-primary"></strong></h4></div>
 		<div class="row g-5 pb-5 mb-5 border-bottom">
			<!-- 상세정보 -->
			<div class="col-md-7">
				<h5 class="mb-3"><span class="text-success">날짜 및 시간</span></h5>
            	<p><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></p>
            	<!-- 식당 정보 -->
            	<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-success">식당</span></h5>
            	<p>식당명 : <c:out value="${together.restaurant.resName}"/></p>
				<p>주소 : <c:out value="${together.restaurant.resAddress}"/></p>
			</div>

			<!-- 메뉴 정보 -->
			<div class="col-md-7 col-lg-5 order-md-last">
        		<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-success">메뉴</span></h5>
            	<ul class="list-group mb-3">
					<!-- 각 메뉴 수량 및 가격 -->
					<c:forEach var="togetherFood" items="${together.togetherFoodList}">
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div>
							<h6 class="my-0"><c:out value="${togetherFood.food.name}"/> <c:out value="${togetherFood.quantity}"/>개</h6>
							<small class="text-muted"><c:out value="${togetherFood.food.price}"/>원 * <c:out value="${togetherFood.quantity}"/>개</small>
                		</div>
                		<span class="text-muted"><c:out value="${togetherFood.getUnitTotalPrice()}"/>원</span>
					</li>
					</c:forEach>
			
					<!-- 합계 및 1인 가격 -->
            		<li class="list-group-item d-flex justify-content-between bg-light">
						<strong><span>합계</span></strong>
                		<strong><c:out value="${together.getTotalPrice()}"/>원</strong>
            		</li>
					<li class="list-group-item d-flex justify-content-between bg-light">
            			<div class="text-success">
                			<h6 class="my-0">1인</h6>
                		</div>
                		<span class="text-success"><strong><c:out value="${together.price}"/>원</strong></span>
            		</li>
				</ul>
			</div>
		</div>
    
    	<!-- 결제하기 -->
    	<form action="/togetherOrder/complete">
    		<input type="hidden" name="cardName" value="${cardName}">
    		<input type="hidden" name="cardNum" value="${cardNum}">
    		<input type="hidden" name="cardDate1" value="${cardDate1}">
    		<input type="hidden" name="cardDate2" value="${cardDate2}">
    		<input type="hidden" name="cardCVC" value="${cardCVC}">
    	
    		<div class="mb-5 pb-5 border-bottom pr-5">
			<h4 class="mx-2 mb-5">결제 정보</h4>
			<div class="row w-100 mx-2 mb-3 no-gutters">
				<label for="cardName" class="col-4 col-form-label">카드 이름</label>
				<div class="col-8">
					<select id="cardName" name="cardName" class="custom-select">
						<option value="농협">농협</option>
						<option value="국민">국민</option>
						<option value="신한">신한</option>
						<option value="우리">우리</option>
						<option value="기업">기업</option>
						<option value="SC제일">SC제일</option>
						<option value="카카오뱅크">카카오뱅크</option>
						<option value="새마을금고">새마을금고</option>
					</select>
				</div>
			</div>
			<div class="row w-100 mx-2 mb-3 no-gutters">
				<label for="cardNum" class="col-4 col-form-label">카드 번호</label>
				<div class="col-8">
					<input id="cardNum" name="cardNum" placeholder="카드 번호"
						class="form-control here" required="required" type="text">
				</div>
			</div>
			<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
				<label class="col-4 col-form-label">카드 정보</label>
					<div class="row col-8 no-gutters">
						<div class="col-6 input-group">
							<input name="cardDate1" placeholder="YY" class="form-control" maxlength="2" required type="text">
							<input name="cardDate2" placeholder="MM" class="form-control " maxlength="2" required type="text">
						</div>
						<div class="col-1"></div>
						<div class="col-5">
							<input name="cardCVC" placeholder="CVC" class="form-control" required type="text">
						</div>
					</div>
				</div>
			</div>
			<div class="row mx-5 mb-5 pb-5 justify-content-end">
			<div class="col-md-3 text-right align-self-end">
				합계 <span class="text-orange-roboto text-roboto pl-1"> <fmt:formatNumber
					value="${together.price}" pattern="#,###,###" /></span>원
			</div>
			<div class="col-md-6">
				<button type="submit" class="btn btn-orange btn-block rounded-pill py-3 my-1 mt-3 mx-3" >
					<small><i class="far fa-credit-card pr-1"></i></small> 결제하기
				</button>
			</div>
			</div>
    	</form>
    
	</div>
</div>
   
<!-- Footer -->
<%@include file="../footer.jsp" %>
</body>
</html>