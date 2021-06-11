<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row my-5 mx-5">
	<div class="col-md-12">
      <div class="shadow-sm rounded-lg">
        <!-- Tabs-->
        <ul class="nav nav-tabs nav-fill nav-justified" role="tablist">
          <li><a class="nav-link py-4 px-sm-4 active" href="#home" data-toggle="tab">메뉴</a></li>
          <li><a class="nav-link py-4 px-sm-4" href="#profile" data-toggle="tab">한줄평</a></li> <!-- mav.setViewName("/eating/RestaurantReview");로 연결 -->
          <li><a class="nav-link py-4 px-sm-4 " href="#messages" data-toggle="tab">같밥 모집ing</a></li>
        </ul>

	<!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
	<!-- 태그는 div이고 class는 tab-content로 설정한다. -->
	<div class="tab-content px-lg-3 py-5">
		<!-- 각 탭이 선택되면 보여지는 내용이다. 태그는 div이고 클래스는 tab-pane이다. -->
		<!-- active 클래스는 현재 선택되어 있는 탭 영역이다. -->
		<div class="tab-pane fade active in" id="home">
			 <div class="info-content px-4 pt-lg-3 pb-3 mb-5 border">
			        <button type = "button" onClick="location.href='<c:url value='/eating/${restaurant.resId}/adminFood' />'">메뉴 추가</button> <!-- 여기 r2라고 해놨으니 바꿔야해 -->
			        
			        <c:forEach var="food" items="${foodList}">     
						<div class="shadow-sm m-2">
			            <div class="row no-gutters">
			              <div class="col-4">
			                <img src="https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg" width="100%" height="150px" />
			              </div>
			                <div class="card-body">
				                <div class="d-flex justify-content-between align-items-start py-2" >
								<h6 class="card-text text-left">${food.name}</h6>
								</div>
								<p>설명</p>
								<p>${food.price}원 </p>  
			              </div>
			              <div class="card-footer">
				            <button type = "button" onClick="location.href='<c:url value='/eating/${restaurant.resId}/addFoodToCart'><c:param name="foodId" value="${food.foodId}"/></c:url>'">담기</button></br> 
				       		  <!--<button type="submit">담기</button></br>	 -->  
				              <button type="button" >수정</button>
				              <button>삭제</button>
			              </div>
			              
			            </div>
			          </div>
					<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
				</c:forEach>
			</div>
		</div>
		<!-- id는 고유한 이름으로 설정하고 tab의 href와 연결되어야 한다. -->
		<div class="tab-pane fade" id="profile">
			<div class="review-content pb-3 mb-5 border">
	          <!-- 상단 리뷰 통계 -->
	          <div class="bg-light py-5">
	          	<div class="row align-items-center">
	          		<div class="col-md-1"></div>
	          		<div class="col-md-3 text-center">
	          			<h4><i class="green fas fa-comment-dots"></i></h4>
	          			<h4 class="green pb-1">리뷰 수</h4>
	          			<h4><b class="orange">56</b><small> 개</small></h4>
	          		</div>
	          		<div class="col-md-4 text-center align-items-center">
	          			<h4><i class="far green fa-star"></i></h4>
	          			<h4 class="green pb-1">평균 평점</h4>
	          			<h4><b class="orange">3.6</b><small> 점</small></h4>
	          		</div>
	          		<div class="col-md-3 text-center align-items-center">
	          			<h4><i class="green fas fa-signal"></i></h4>
	          			<h4 class="green pb-1">최다 평점</h4>
	          			<h4><b class="orange">4</b><small> 점</small></h4>
	          		</div>
	          		<div class="col-md-1"></div>
	          	</div>
	          </div>

			  <div class="px-5 pt-lg-5">
			   <!-- 상단 -->
				<div class="d-flex justify-content-between pb-4 px-4 border-bottom mb-4">
				
				<!-- 드롭다운 -->
				<div class="dropdown">
					<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true">최신순</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#"><small>좋아요순</small></a>
							<a class="dropdown-item" href="#"><small>높은 평점순</small></a>
							<a class="dropdown-item" href="#"><small>낮은 평점순</small></a>
						</div>
				</div>
				<!-- 리뷰 작성 -->
				<button type="button" class="btn btn-sm btn-orange rounded-pill px-3"
					data-toggle="modal" data-target="#exampleModal"><i class="far fa-edit"></i> 작성하기</button>
			</div>

			<!-- 리뷰 목록 -->
			<div class="product-review mx-4 pb-4 mb-4 border-bottom">
				<div class="d-flex align-middle me-4 pe-2">
					<h6 class="green-roboto px-2">5</h6>
					<div class="star-rating green">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
					</div>
				</div>
				<div class="text-muted ml-2">
					<small>공지수 | 2021.04.06</small>
				</div>
				<div class="mx-4 my-2">
					<div class="my-3">
						첫구매도 맛이 달콤달콤 새콤새콤해서 너무맛있게 먹어서 두번째로시키게되었는데요<br>배송은 역시나
						빨랐어요 새벽에 받자마자 열어보았는데 사과냄새향수가있나할정도였어요😚
					</div>
					<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green far fa-thumbs-up"></i>
						<span class="green-roboto">25</span><small class="text-muted"> 명이 추천</small></div>
				</div>
			</div>


			<!-- 페이지네이션 -->
			<div class="row my-xl-5 justify-content-center">
				<div class="paginate mb-xl-2 btn-toolbar" role="toolbar">
					<button type="button" class="btn"> <i class="fas fa-chevron-left"></i></button>
					<div class="btn-group"><button type="button" class="btn active rounded-circle">1</button></div>
					<div class="btn-group"><button type="button" class="btn rounded-circle">2</button></div>
					<div class="btn-group"><button type="button" class="btn rounded-circle">3</button></div>
					<div class="btn-group"><button type="button" class="btn rounded-circle">4</button></div>
					<div class="btn-group"><button type="button" class="btn rounded-circle">5</button></div>
					<button type="button" class="btn"><i class="fas fa-chevron-right"></i></button>
				</div>
			</div>
		</div>
		</div>
		</div>
		<!-- fade 클래스는 선택적인 사항으로 트랜지션(transition)효과가 있다.
		<!-- in 클래스는 fade 클래스를 선언하여 트랜지션효과를 사용할 때 in은 active와 선택되어 있는 탭 영역의 설정이다. -->
		<div class="tab-pane fade" id="messages">Messages 메뉴</div>
		
	</div>
</div>

</div>
</div>