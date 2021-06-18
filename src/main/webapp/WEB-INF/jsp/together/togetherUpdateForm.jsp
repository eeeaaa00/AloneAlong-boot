<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title>togetherRegister</title>
</head>
<body>
<!-- header -->
<%@include file="../tiles/header.jsp" %>

<div class="container my-5 pb-5">
	<div class="container col-md-10 mx-auto mb-3">
		<!--상단 -->
		<div class="py-5 text-center">
			<h3>함께 먹기 수정</h3>
			<p>주최자가 되어 같이 밥을 먹어보세요!</p>
		</div>
		
		<!-- 식당 선택 -->
    	<h4 class="mb-3"><span class="text-success">STEP 1. 식당 선택</span></h4>
    	<!-- 검색창 -->
    	<div class="row g-5">
    		<div class="col-md-6">
				<form class="d-flex" action='<c:url value="/togetherUpdate/searchRestaurant"/>'>
          			<input class="form-control me-2" name="keywords" type="search" value="${keywords}" placeholder="식당명을 입력하세요" aria-label="Search">
          			<button class="btn btn-outline-success" type="submit"><i class="fas fa-search"></i></button>
        		</form>
      		</div>
      		<div class="col-md-6"></div>
    	</div>
      	<br>
		<!-- 검색 결과 출력 -->
		<div class="row mb-2">
			<c:forEach var="restaurant" items="${restaurantList}">
				<c:if test="${restaurant.isTogetherOk() eq true}">
				<div class="col-md-6">
					<div class="card mb-3">
          				<div class="row g-0">
            				<div class="col-md-4 align-self-center">
              					<svg class="img" style="background-image: url('https://post-phinf.pstatic.net/MjAyMDAzMDNfMTcg/MDAxNTgzMTkwNjA3ODQ5.kUXPHqGJ2xPDSu_3FiEoFC3kY9QyQ_g9CziCGrFSDuEg.LpCfOTbc5qth9d-GKzGv9jwj2VKhcqmPHp5cp1KJYEsg.JPEG/IM_food02.jpg?type=w1200');
  									background-size: cover; background-position:center; width:120px; height:90px;"></svg>
            				</div>
            				<div class="col-md-5 align-self-center">
              					<h6 class="card-title"><a href="<c:url value='/eating/' />${restaurant.resId}"><c:out value="${restaurant.resName}"/></a></h6>
                				<p class="card-text"><small class="text-muted"><c:out value="${restaurant.resAddress}"/></small></p>
            				</div>
            				<div class="col-md-3 align-self-center">
            					<form action='<c:url value="/togetherUpdate/searchMenu"/>'>
            						<button class="btn btn-sm btn-success" name="resId" value="${restaurant.resId}" type="submit" >선택</button>
            					</form>
            				</div>
          				</div>
        			</div>
				</div>
				</c:if>
			</c:forEach>
		</div>
		
    	<hr>

    	<!-- 메뉴 선택 시작 -->
    	<h4 class="mb-3"><span class="text-success">STEP 2. 메뉴 선택</span></h4>
    	<!-- 메뉴 리스트 -->
    	<div class="row mb-2">
      		<c:forEach var="food" items="${foodList}">
      			<div class="col-md-6">
      				<div class="card mb-3">
          				<div class="row g-0">
            				<div class="col-md-4 align-self-center">
              					<svg class="img" style="background-image: url('https://post-phinf.pstatic.net/MjAyMDAzMDNfMTcg/MDAxNTgzMTkwNjA3ODQ5.kUXPHqGJ2xPDSu_3FiEoFC3kY9QyQ_g9CziCGrFSDuEg.LpCfOTbc5qth9d-GKzGv9jwj2VKhcqmPHp5cp1KJYEsg.JPEG/IM_food02.jpg?type=w1200');
  									background-size: cover; background-position:center; width:120px; height:90px;"></svg>
            				</div>
            				<div class="col-md-5 align-self-center">
              					<h6 class="card-title"><c:out value="${food.name}"/></h6>
                				<p class="card-text"><small class="text-muted"><c:out value="${food.price}"/>원</small></p>
            				</div>
            				<div class="col-md-3 align-self-center">
            					<form class="form" action='<c:url value="/togetherUpdate/${selectedRes.resId}/addFoodToCart"/>'>
            					<input type="hidden" name="foodId" value="${food.foodId}">
									<span class="input-group-btn"><button class="btn btn-sm btn-success" type="submit">담기</button></span>
								</form>
            				</div>
          				</div>
        			</div>
      			</div>
        	</c:forEach>
		</div>
		
		<!-- 음식 카트 -->
		<div class="row g-5">
      		<div class="col-md-12">
        		<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text">음식 카트</span></h5>
        		<ul class="list-group mb-3">
  					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div class="col-md-4">음식</div>
						<div class="d-none d-md-block col">
							<div class="row">
								<div class="col-md-4">가격</div>
								<div class="col-md-4">수량</div>
								<div class="col-md-4">총액</div>
							</div>
						</div>
  					</li>
					<!-- 음식 -->
					<c:forEach var="foodCartItem" items="${foodCart}">
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div class="col-md-4">${foodCartItem.food.name}</div>
						<div class="d-none d-md-block col">
						<div class="align-items-center row">
							<div class="col-md-4">${foodCartItem.food.price}원</div>
							<div class="col-md-4 text-center">
								<form class="form" action='<c:url value="/togetherUpdate/${selectedRes.resId}/updateFoodCartItem"/>'>
									<input type="hidden" name="foodId" value="${foodCartItem.food.foodId}">
									<div class="input-group">
										<input class="form-control text-center rounded" name="quantity" type="number" value="${foodCartItem.quantity}" min="1">
										<span class="input-group-btn"><button class="btn" type="submit"><i class="text-orange fas fa-check"></i></button></span>
									</div>
								</form>
							</div>
							<div class="col-md-2">
								<div class="row">
									<div class="text-right text-md-center col-6 col-md-12">${foodCartItem.getUnitPrice()}원</div>
								</div>
							</div>
							<form class="form" action='<c:url value="/togetherUpdate/${selectedRes.resId}/deleteFoodCartItem"/>'>
								<input type="hidden" name="foodId" value="${foodCartItem.food.foodId}">
								<div class="d-none d-md-block text-center col-2">
									<span class="btn cart-remove text-green" ><button class="btn" type="submit"><i class="delete fa fa-times"></i></button></span>
								</div>
							</form>
						</div>
						</div>
  					</li>
  					</c:forEach>
					<!-- 합계 -->
  					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="col-md-4"><strong><span>합계</span></strong></div>
						<div class="d-none d-md-block col">
							<div class="row">
								<div class="col-md-4"></div>
								<div class="col-md-4"></div>
								<div class="col-md-4"><strong>${totalPrice}원</strong></div>
							</div>
						</div>
  		        	</li>
  				</ul>
      		</div>
		</div>

		<hr>
		
		<!-- 글 작성하기 -->
    	<h4 class="mb-3"><span class="text-success">STEP 3. 상세 정보 작성</span></h4>
		<form>
			<input type="hidden" name="resId" value="${selectedRes.resId}">
			<div class="row g-3">
				<div class="col-md-10">
					<label for="title">제목</label>
					<input type="text" class="form-control" name="name" value="${together.togetherName}" placeholder="" required>
				</div>
				<div class="col-md-10">
					<label for="headCount">인원</label>
					<input type="number" class="form-control" name="headCount" value="${together.headCount}" min="2" placeholder="" required>
				</div>
				<div class="col-md-5">
  					<label for="sex">성별</label>
  					<select class="custom-select" name="sex">
    					<option value="상관없음">상관없음</option>
      					<option value="여성">여성</option>
      					<option value="남성">남성</option>
  					</select>
				</div>
				<div class="col-md-5">
  					<label for="age">나이대</label>
  					<select class="custom-select" name="age">
    					<option value="상관없음">상관없음</option>
      					<option value="10대">10대</option>
      					<option value="20대">20대</option>
      					<option value="30대">30대 </option>
      					<option value="40대">40대</option>
      					<option value="50대">50대이상</option>
  					</select>
				</div>
				<div class="col-sm-5">
  					<label for="date">날짜</label>
  					<input type="date" class="form-control" name="date" value="${together.togetherDate}" placeholder="" value="" required>
				</div>
				<div class="col-sm-5">
  					<label for="time">시간</label>
  					<input type="time" class="form-control" name="time" value="${together.togetherTime}" placeholder="" value="" required>
				</div>
				<div class="col-10">
  					<label for="description">주최자의 말</label>
  					<input type="text" class="form-control" name="description" value="${together.togetherDes}" placeholder="" required>
				</div>
			</div>

			<!--버튼 -->
			<div class="py-5 text-right">
				<button class="w-40 btn btn-lg btn-success" type="submit" formaction="/togetherUpdate/${together.togetherId}/complete">수정하기</button>
			</div>
		</form>

	</div>
</div>

<!-- Footer -->
<%@include file="../footer.jsp" %>
</body>
</html>