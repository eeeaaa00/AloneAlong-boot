<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>a{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>

	<!-- 상단 설명 -->
	<div class="row mx-3">
		<div class="col-md-5">
			<h2 style="text-color: #29A65F;">식당</h2>
			총 <b>${restaurantCount}</b>개의 식당이 있습니다.
		</div>
		<div class="col-md-5"></div>
		<div class="col-md-2"></div>
	</div>
	<div class="mx-5 my-3 text-right">
	<form action='<c:url value="/eating"/>'>
		<div class="dropdown">
			<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
			aria-haspopup="true"><c:out value="${sortTypeName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="sortType" value="new" type="submit"><small>최신 등록순</small></button>
				<button class="dropdown-item" name="sortType" value="review" type="submit"><small>리뷰 많은순</small></button>
				<button class="dropdown-item" name="sortType" value="rating" type="submit"><small>별점 높은순</small></button>
			</div>
		</div>
		<input type="hidden" name="category1" value="${category1}">
		<input type="hidden" name="category2" value="${category2}">
	</form>
		<!-- <button onClick="location.href='<c:url value='/eating/adminRes' />'">임시 식당등록버튼(마이페이지)</button> -->
	</div>
	
	
	<!-- 물품 목록 -->
	<div class="row px-5 mb-lg-3 pr-5 justify-content-md-between">
		<c:forEach var="res" items="${restaurantList}" varStatus="idx">
			<c:if test="${idx.index % 3 == 0}">
				</div>
				<div class="row px-5 mb-lg-3 justify-content-between">
			</c:if>
			<div class="card shadow-sm mb-4" type="button" onClick="location.href='<c:url value='/eating/' />${res.resId}'"> 
				<img class="img ml-1 mt-1" src="data:image/jpeg;base64,${res.img64}"
					style="width:260px; height:150px; object-fit:cover;">
				<div class="card-body">
					<div class="d-flex justify-content-between align-items-start">
						<h6 class="card-text text-left mb-3">${res.resName}</h6>
						</div>
					<p class="mb-1">별점 : ${res.avgRating}</p>
					<p>주소 : ${res.resAddress} </p>
				</div>
			</div>
			<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
		</c:forEach>
	<!-- /.물품목록 -->
		<c:set var="pageListSize" value="${restaurantList.size()}" />
		<c:if test="${(pageListSize % 3) != 0}"><div style="width:268px;"></div></c:if>			
	</div>
	<div class="row my-xl-5 justify-content-center">
	<div class="paginate mb-xl-5 btn-toolbar" role="toolbar">
		 <c:if test="${page == 1}">
		 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-left"></i></button>
		 </c:if>
		 <c:if test="${page != 1}">
		 	 <button type="button" class="btn" onClick="location.href='<c:url value='/eating?page=${page - 1}&sortType=${param.sortType}&category1=${param.category1}&category2=${param.category2}' />'">
		 	 	<i class="fas fa-chevron-left"></i></button>
		 </c:if>
		 <c:forEach var="pageNum" begin="${startPage}" end="${startPage + 5}" varStatus="status">
			 <c:if test="${pageNum == page}">
		 		<div class="btn-group"><button type="button" class="btn active rounded-circle" 
		 			onClick="location.href='<c:url value='/eating?page=${pageNum}&sortType=${param.sortType}&category1=${param.category1}&category2=${param.category2}' />'">${pageNum}</button></div>
			 </c:if>
			 <c:if test="${pageNum != page && pageNum <= lastPage}">
		 		<div class="btn-group"><button type="button" class="btn rounded-circle"
		 			onClick="location.href='<c:url value='/eating?page=${pageNum}&sortType=${param.sortType}&category1=${param.category1}&category2=${param.category2}' />'">${pageNum}</button></div>
			 </c:if>
		 </c:forEach>
		 <c:if test="${page == lastPage}">
		 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-right"></i></button>
		 </c:if>
		 <c:if test="${page != lastPage}">
		 	 <button type="button" class="btn" onClick="location.href='<c:url value='/eating?page=${page + 1}&sortType=${param.sortType}&category1=${param.category1}&category2=${param.category2}' />'">
		 	 	<i class="fas fa-chevron-right"></i></button>
		 </c:if>
	</div>
</div>