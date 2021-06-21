<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row my-5 mx-5">
	<div class="col-md-12" height="100%;">
		<div class="shadow-sm rounded-lg">
			<!-- Tabs-->
			<ul class="nav nav-tabs nav-fill" role="tablist">
				<li class="nav-item"><a class="nav-link py-4 px-sm-4 active">상세 정보</a></li>
				<li class="nav-item"><a class="nav-link py-4 px-sm-4"
					href="<c:url value='/shop/${productId}/review?quantity=${product.quantity}' />">상품 리뷰</a></li>
			</ul>
			<div class="info-content px-4 pt-lg-3 pb-3 mb-5 border">
				<div class="tab-content px-lg-3 py-5">
					<!-- General info tab-->
					<img class="rounded" style="width: 100%;" alt="productInfo"
					src="<c:url value='/images/${product.productId}-contents.jpg'/>" />
				</div>
			</div>
		</div>
	</div>
</div>