<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row my-5 mx-5">
	<div class="col-md-12" style="width:100%;">
		<div class="shadow-sm rounded-lg">
			<!-- Tabs-->
	        <ul class="nav nav-tabs nav-fill" role="tablist">
				<li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/eating/'/>${resId}">메뉴</a></li>
	          	<li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/eating/${resId}/RestaurantReview' />">한줄평</a></li> <!-- mav.setViewName("/eating/RestaurantReview");로 연결 -->
	          	<li class="nav-item"><a class="nav-link py-4 px-sm-4 active" href="<c:url value='/eating/${resId}/togetherList' />">같밥 모집ing</a></li>
	        </ul>
	        <!-- 내용 -->
	        <div class="review-content pb-3 mb-5 border">
	        	<c:forEach var="together" items="${togetherList}">
					<div class="col-md-6">
        				<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/together/${together.togetherId}' />'">
            				<div class="col p-4 d-flex flex-column position-static">
            					<!-- 태그 -->
                				<div class="row-md-6">
                					<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.getAddressTag()}"/></span>
                					<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.restaurant.categoryId}"/></span>
                					<c:if test="${together.sex != '상관없음'}">
                					<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.sex}"/></span>
                					</c:if>
                					<c:if test="${together.age != '상관없음'}">
                					<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.age}"/></span>
                					</c:if>
                				</div >
                				<!-- 같이밥 정보 -->
                				<h3 class="mb-0"><c:out value="${together.togetherName}"/><strong class="text-success">(<c:out value="${together.togetherMemberList.size()}"/>/<c:out value="${together.headCount}"/>)</strong></h3>
                				<div class="mb-1 text-muted"><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></div>
                				<p class="card-text mb-auto">식당명 : <c:out value="${together.restaurant.resName}"/></p>
                				<p class="card-text mb-auto">메뉴 : <c:forEach var="togetherFood" items="${together.togetherFoodList}"><c:out value="${togetherFood.food.name}"/> </c:forEach></p>
                				<p class="card-text mb-auto">1인 <c:out value="${together.price}"/>원</p>
              				</div>
        				</div>
    				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>