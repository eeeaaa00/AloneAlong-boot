<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action='<c:url value="/shop"/>'>
<div class="row mx-3">
	<div class="col-md-5">
		<h2 style="text-color: #29A65F;">과일</h2>
		총 <b><c:out value="${productList.size()}"/></b>개의 상품이 있습니다.
	</div>
	<div class="col-md-5"></div>
	<div class="col-md-2"></div>
</div>
<div class="mx-5 my-3 text-right">
	<div class="dropdown">
		<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
			aria-haspopup="true"><c:out value="${sortTypeName}"/></button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<button class="dropdown-item" name="sortType" value="new" type="submit"><small>최신순</small></button>
			<button class="dropdown-item" name="sortType" value="past" type="submit"><small>과거순</small></button>
			<button class="dropdown-item" name="sortType" value="sales" type="submit"><small>인기순</small></button>
			<button class="dropdown-item" name="sortType" value="lowPrice" type="submit"><small>낮은 가격순</small></button>
			</div>
	</div>
</div>
</form>