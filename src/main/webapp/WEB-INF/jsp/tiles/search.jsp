<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row d-flex justify-content-center align-items-center">
	<div class="card align-middle"
		style="width: 100rem; border-radius: 20px;">
		<div class="card-body">
			<h3>
				검색어 <b style="color: #29A65F;">"${keyword}"</b>에 대한 검색 결과
			</h3>
			<c:choose>
			<c:when test="${totalCnt == -1}"> 
				<hr><h5>검색어를 입력해주세요.</h5>
			</c:when>
			<c:otherwise>
				<p>
					총 <b style="color: #29A65F;">${totalCnt}</b>개의 결과가 있습니다.
				</p>

				<c:if test="${totalCnt == '0'}">
					<hr>
					<h5>검색 결과가 없습니다.</h5>
				</c:if>
				<c:if test="${productCnt != '0'}">
					<hr>
					<h5>상품 검색 결과</h5>
					<br>
					<div class="row px-5 mb-lg-5 justify-content-between">
						<c:forEach items="${productList}" var="product" varStatus="idx">
							<div class="card shadow-sm">
								<div class="contents">
									<svg class="img"
										style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center"
										width="100%" height="150px"></svg>
									<div class="card-body">
										<div class="d-flex justify-content-between align-items-start">
											<h6 class="card-text text-left">
												<c:out value="${product.productName}" />
											</h6>
											<a type="button"
												href=<c:url value="/cart/insert/${product.productId}/1/list"/>
												class="btn btn-green btn-sm rounded-circle"> <i
												class="fas fa-shopping-cart"></i></a>
										</div>
										<p>
											<fmt:formatNumber value="${product.productPrice}"
												pattern="#,###,###" />
											원
										</p>
										<c:if test="${product.productStock == 0}">
											<small class="sold-out text-center rounded-pill">품절</small>
										</c:if>
									</div>
								</div>
								<div class="overlay" type="button"
									onClick="location.href='<c:url value='/shop/${product.productId}' />'"></div>
							</div>
						</c:forEach>
						<c:set var="productSize" value="${productList.size()}" />
						<c:if test="${(productSize % 3) != 0}"><div style="width:300px;"></div></c:if>
					</div>
				</c:if>
				<c:if test="${resCnt != '0'}">
					<hr>
					<h5>식당 검색 결과</h5>
					<br>
					<div class="row px-5 mb-lg-5 justify-content-between">
						<c:forEach items="${restaurantList}" var="res" varStatus="idx">
							<div class="card shadow-sm" type="button"
								onClick="location.href='<c:url value='/eating/' />${res.resId}'">
								<div class="contents">
									<img class="img ml-1 mt-1"
										src="data:image/jpeg;base64,${res.img64}"
										style="width: 260px; height: 150px; object-fit: cover;">

									<div class="card-body">
										<div class="d-flex justify-content-between align-items-start">
											<h5 class="card-text text-left">
												<c:out value="${res.resName}" />
												<br>
											</h5>
										</div>
										<p class="text-left">
											별점 : ${res.avgRating}<br> 주소 : ${res.resAddress}
										</p>
									</div>
								</div>

							</div>
						</c:forEach>
						<c:set var="restaurantSize" value="${restaurantList.size()}" />
						<c:if test="${(restaurantSize % 3) != 0}"><div style="width:300px;"></div></c:if>
					</div>


				</c:if>

				<c:if test="${togCnt != '0'}">
					<hr>
					<h5>함께먹기 검색 결과</h5>
					<br>
					<div class="row px-5 mb-lg-5 justify-content-between">
						<c:forEach items="${togetherList}" var="together">
							<div class="card shadow-sm" type="button"
								onClick="location.href='<c:url value='/together/${together.togetherId}' />'">
								<div class="card-body">
									<span class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${together.getAddressTag()}" /></span> <span
										class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${together.restaurant.categoryId}" /></span>
									<h3 class="mb-0">
										<c:out value="${together.togetherName}" />
										<strong class="text-success">(<c:out
												value="${together.togetherMemberList.size()}" />/<c:out
												value="${together.headCount}" />)
										</strong>
									</h3>
									<c:out value="${together.togetherDate}" />
									/
									<c:out value="${together.togetherTime}" />
									식당명 :
									<c:out value="${together.restaurant.resName}" />
									<br> 메뉴 :
									<c:forEach var="togetherFood"
										items="${together.togetherFoodList}">
										<c:out value="${togetherFood.food.name}" />
									</c:forEach>
									<br> 1인
									<c:out value="${together.price}" />
									원
								</div>
							</div>

						</c:forEach>
					</div>

				</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</html>