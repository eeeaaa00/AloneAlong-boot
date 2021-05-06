<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row mx-3">
	<div class="col-md-5">
		<h2 style="text-color: #29A65F;">과일</h2>
		총 <b>30</b>개의 상품이 있습니다.
	</div>
	<div class="col-md-5"></div>
	<div class="col-md-2"></div>
</div>
<div class="mx-5 my-3 text-right">
	<div class="dropdown">
		<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
			aria-haspopup="true">최신순</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="#"><small>과거순</small></a> <a
				class="dropdown-item" href="#"><small>인기순</small></a> <a
				class="dropdown-item" href="#"><small>낮은 가격순</small></a>
		</div>
	</div>
</div>