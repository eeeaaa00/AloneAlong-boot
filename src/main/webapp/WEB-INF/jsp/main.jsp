<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
b {
	color: #29A65F;
}

h4 {
	margin: 10px;
	margin-bottom: 20px;
}

.card:hover, .card:focus {
	filter: brightness(90%);
}

.card-body>p {
	color: #29A65F;
}

#card {
	width: 270px;
	height: 270px;
}

#tog {
	width: 950px;
	height: 300px;
	margin-bottom: 50px;
}

.overlay {
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	top: 0;
}

.swiper-slide {
	text-align: left;
	margin: 0px;
	align-items: center;
	justify-content: center;
	align-items: center;
}

#tog2 {
	margin-top: 25px;	
	margin-bottom: 30px;
}

#swiper-slide-1 {
	text-align: left;
	margin: 0px;
	margin-bottom: 50px;
	align-items: center;
	justify-content: center;
	align-items: center;
}

.sold-out {
	background-color: gray;
	color: #FFFFFF;
	width: 50px;
	padding: 2px 15px 2px 15px;
}
</style>
<h3>
	<c:choose>
		<c:when test="${!empty userSession.user}">
	${userSession.user.name}님</c:when>
		<c:otherwise>당신</c:otherwise>
	</c:choose>
	의 <b style="color: orange">홀로서기</b>를 위한 <b>Alone&Along</b>의 맞춤 서비스 추천
</h3>
<br>
<!-- 추천 기능 -->
<hr>
<div class="swiper-container">
	<h4>
		1인 가구를 위한 소량 상품 추천
	</h4>
	<div class="swiper-wrapper">
		<c:forEach items="${productList}" var="product" varStatus="idx"
			begin="1" end="6">
			<div class="swiper-slide">
				<div class="row px-5 mb-lg-5 justify-content-between">
					<input type="hidden" name="pcId" value="${param.pcId}" /> <input
						type="hidden" name="sortType" value="${param.sortType}" /> <input
						name="productId" type="hidden" value="${product.productId}" />
					<div class="card shadow-sm" id="card">
						<div class="contents">
							<svg class="img"
								style="background-image: url('../images/${pcId}-${product.productId}.png'); background-size: cover; background-position: center"
								width="100%" height="150px"></svg>
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-start">
									<h6 class="card-text text-left mb-2">
										<c:out value="${product.productName}" />
									</h6>
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
							onClick="location.href='<c:url value='/shop/${product.productId}' />'">
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="swiper-button-next"></div>
	<!-- 네비게이션 -->
	<div class="swiper-pagination"></div>
	<!-- 페이징 -->
</div>
<hr>
<div class="swiper-container">
	<h4>
		혼밥을 편안하게! 별점이 높은 식당을 둘러보세요.
	</h4>
	<div class="swiper-wrapper">
		<c:forEach var="res" items="${restaurantList}" begin="1" end="6">
			<div class="swiper-slide">
				<div class="row px-5 mb-lg-5 justify-content-between">
					<div class="card shadow-sm" type="button" id="card"
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
				</div>
			</div>
			<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
		</c:forEach>
	</div>
	<div class="swiper-button-next"></div>
	<!-- 네비게이션 -->
	<div class="swiper-pagination"></div>
	<!-- 페이징 -->
</div>
<hr>
<c:choose>
	<c:when test="${!empty recommandList}">
		<div class="swiper-container" id="tog">
			<h4>
				혼밥하기 외로운 날,  ${user.name}님을 위한 함께 먹기 추천
			</h4>
			<div class="swiper-wrapper" id="tog2">
				<c:forEach var="recommand" items="${recommandList}">
					<div class="swiper-slide" id="swiper-slide-1">
						<div class="card shadow-sm rounded" type="button"
							onClick="location.href='<c:url value='/together/${recommand.togetherId}' />'">
							<div class="col p-4 d-flex flex-column position-static"
								id="cardT">
								<!-- 태그 -->
								<div class="row-md-6">
									<span class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${recommand.getAddressTag()}" /></span> <span
										class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${recommand.restaurant.categoryId}" /></span>
									<c:if test="${recommand.sex != '상관없음'}">
										<span class="badge rounded-pill bg-warning text-dark">#<c:out
												value="${recommand.sex}" /></span>
									</c:if>
									<c:if test="${recommand.age != '상관없음'}">
										<span class="badge rounded-pill bg-warning text-dark">#<c:out
												value="${recommand.age}" /></span>
									</c:if>
								</div>
								<!-- 같이밥 정보 -->
								<h3 class="mb-0">
									<c:out value="${recommand.togetherName}" />
									<strong class="text-success">(<c:out
											value="${recommand.togetherMemberList.size()}" />/<c:out
											value="${recommand.headCount}" />)
									</strong>
								</h3>
								<div class="mb-1 text-muted">
									<c:out value="${recommand.togetherDate}" />
									/
									<c:out value="${recommand.togetherTime}" />
								</div>
								<p class="card-text mb-auto">
									식당명 :
									<c:out value="${recommand.restaurant.resName}" />
								</p>
								<p class="card-text mb-auto">
									메뉴 :
									<c:forEach var="togetherFood"
										items="${recommand.togetherFoodList}">
										<c:out value="${togetherFood.food.name}" />
									</c:forEach>
								</p>
								<p class="card-text mb-auto">
									1인
									<c:out value="${recommand.price}" />
									원
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="swiper-button-next"></div>
			<!-- 네비게이션 -->
			<div class="swiper-pagination"></div>
			<!-- 페이징 -->
		</div>
	</c:when>
	<c:otherwise>
		<div class="swiper-container" id="tog">
			<h4>
				혼밥하기 외로운 날, 함께 먹기 해보는 건 어떠세요?
			</h4>
			<div class="swiper-wrapper" id="tog2">
				<c:forEach var="together" items="${togetherList}" begin="1" end="6">
					<div class="swiper-slide" id="swiper-slide-1">
						<div class="card shadow-sm rounded" type="button"
							onClick="location.href='<c:url value='/together/${recommand.togetherId}' />'">
							<div class="col p-4 d-flex flex-column position-static"
								id="cardT">
								<!-- 태그 -->
								<div class="row-md-6">
									<span class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${together.getAddressTag()}" /></span> <span
										class="badge rounded-pill bg-warning text-dark">#<c:out
											value="${together.restaurant.categoryId}" /></span>
									<c:if test="${together.sex != '상관없음'}">
										<span class="badge rounded-pill bg-warning text-dark">#<c:out
												value="${together.sex}" /></span>
									</c:if>
									<c:if test="${together.age != '상관없음'}">
										<span class="badge rounded-pill bg-warning text-dark">#<c:out
												value="${together.age}" /></span>
									</c:if>
								</div>
								<!-- 같이밥 정보 -->
								<h3 class="mb-0">
									<c:out value="${together.togetherName}" />
									<strong class="text-success">(<c:out
											value="${together.togetherMemberList.size()}" />/<c:out
											value="${together.headCount}" />)
									</strong>
								</h3>
								<div class="mb-1 text-muted">
									<c:out value="${together.togetherDate}" />
									/
									<c:out value="${together.togetherTime}" />
								</div>
								<p class="card-text mb-auto">
									식당명 :
									<c:out value="${together.restaurant.resName}" />
								</p>
								<p class="card-text mb-auto">
									메뉴 :
									<c:forEach var="togetherFood"
										items="${together.togetherFoodList}">
										<c:out value="${togetherFood.food.name}" />
									</c:forEach>
								</p>
								<p class="card-text mb-auto">
									1인
									<c:out value="${together.price}" />
									원
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="swiper-button-next"></div>
			<!-- 네비게이션 -->
			<div class="swiper-pagination"></div>
			<!-- 페이징 -->
		</div>
	</c:otherwise>
</c:choose>

<Br>
<!-- script -->
<script>
new Swiper('.swiper-container', {
	slidesPerView : 3, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 38, // 슬라이드간 간격
	slidesPerGroup : 3, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	loopFillGroupWithBlank : true,
	loop : true, // 무한 반복
	autoHeight : true,
	pagination : { // 페이징
 		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
	},
});

new Swiper('#tog', {
	slidesPerView : 2, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 40, // 슬라이드간 간격
	slidesPerGroup : 2, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	loopFillGroupWithBlank : true,
	loop : true, // 무한 반복

	pagination : { // 페이징
 		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
	},
});
</script>
