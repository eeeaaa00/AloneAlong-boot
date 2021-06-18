<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>a{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>

<!-- 물품 목록 -->
<div class="row px-5 mb-lg-5 justify-content-between">
<c:forEach items="${productList.pageList}" var="product" varStatus="idx">
<c:if test="${idx.index % 3 == 0}">
</div>
<div class="row px-5 mb-lg-5 justify-content-between">
</c:if>
	<input type="hidden" name="pcId" value="${param.pcId}"/>
	<input type="hidden" name="sortType" value="${param.sortType}"/>
	<input name="productId" type="hidden" value="${product.productId}"/>
	<div class="card shadow-sm rounded">
		<div class="contents">
		<svg class="img" style="background-image: url('data:image/jpeg;base64,${product.img64}'); background-size: cover; background-position: center"
										width="100%" height="150px"></svg>
			<div class="card-body">
				<div class="d-flex justify-content-between align-items-start">
					<h6 class="card-text text-left"><c:out value="${product.productName}"/></h6>
					<a type="button" href=<c:url value="/cart/insert/${product.productId}/1/list"/> class="btn btn-green btn-sm rounded-circle">
						<i class="fas fa-shopping-cart"></i></a>
				</div>
				<p><fmt:formatNumber value="${product.productPrice}" pattern="#,###,###"/>원</p>
				<c:if test="${product.productStock == 0}">					
					<small class="sold-out text-center rounded-pill">품절</small>
				</c:if>
			</div>
		</div>
		<div class="overlay" type="button"
			onClick="location.href='<c:url value='/shop/${product.productId}' />'"></div>
	</div>
</c:forEach>
<c:set var="pageListSize" value="${productList.pageList.size()}" />
<c:if test="${(pageListSize % 3) != 0}"><div style="width:268px;"></div></c:if>
</div>
<!-- /.물품목록 -->

<div class="row my-xl-5 justify-content-center">
	<div class="paginate mb-xl-5 btn-toolbar" role="toolbar">
		 <c:if test="${page == 1}">
		 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-left"></i></button>
		 </c:if>
		 <c:if test="${page != 1}">
		 	 <button type="button" class="btn" onClick="location.href='<c:url value='/shop?pcId=${pcId}&page=${page - 1}&sortType=${param.sortType}' />'">
		 	 	<i class="fas fa-chevron-left"></i></button>
		 </c:if>
		 <c:forEach var="pageNum" begin="${startPage}" end="${startPage + 5}" varStatus="status">
			 <c:if test="${pageNum == page}">
		 		<div class="btn-group"><button type="button" class="btn active rounded-circle" 
		 			onClick="location.href='<c:url value='/shop?pcId=${pcId}&page=${pageNum}&sortType=${param.sortType}' />'">${pageNum}</button></div>
			 </c:if>
			 <c:if test="${pageNum != page && pageNum <= lastPage}">
		 		<div class="btn-group"><button type="button" class="btn rounded-circle"
		 			onClick="location.href='<c:url value='/shop?pcId=${pcId}&page=${pageNum}&sortType=${param.sortType}' />'">${pageNum}</button></div>
			 </c:if>
		 </c:forEach>
		 <c:if test="${page == lastPage}">
		 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-right"></i></button>
		 </c:if>
		 <c:if test="${page != lastPage}">
		 	 <button type="button" class="btn" onClick="location.href='<c:url value='/shop?pcId=${pcId}&page=${page + 1}&sortType=${param.sortType}' />'">
		 	 	<i class="fas fa-chevron-right"></i></button>
		 </c:if>
	</div>
</div>