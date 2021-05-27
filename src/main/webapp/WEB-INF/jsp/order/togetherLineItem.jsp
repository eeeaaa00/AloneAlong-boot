<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="py-5">
		<h4>신청확인<strong class="d-inline-block mb-2 text-primary"></strong></h4>
	</div>

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
                	<span class="text-success"><strong><c:out value="${together.getPricePerPerson()}"/>원</strong></span>
            	</li>
			</ul>
		</div>
	</div>