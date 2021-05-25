<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="row my-5 mx-5">
		<div class="col-md-12" style="width:100%;">
	      <div class="shadow-sm rounded-lg">
	        <!-- Tabs-->
	        <ul class="nav nav-tabs nav-fill" role="tablist">
	          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/eating/'/>${resId}">메뉴</a></li>
	          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active" href="<c:url value='/eating/${resId}/RestaurantReview' />">한줄평</a></li> <!-- mav.setViewName("/eating/RestaurantReview");로 연결 -->
	          <li class="nav-item"><a class="nav-link py-4 px-sm-4" >같밥 모집ing</a></li>
	        </ul>
	        <!-- 내용 -->
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
			<!-- 리뷰 목록 -->
			<div class="product-review mx-4 pb-4 mb-4 border-bottom">
				<div class="d-flex align-middle me-4 pe-2">
					<h6 class="green-roboto px-2">2</h6>
					<div class="star-rating green">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="far fa-star"></i>
						<i class="far fa-star"></i>
						<i class="far fa-star"></i>
					</div>
				</div>
				<div class="text-muted ml-2">
					<small>공지수 | 2021.04.06</small>
				</div>
				<div class="mx-4 my-2">
					<div class="my-3">
						걍 그래요...
					</div>
					<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green fas fa-thumbs-up"></i>
						<span class="green-roboto">3</span><small class="text-muted"> 명이 추천</small></div>
				</div>
			</div>
			<!-- 리뷰 목록 -->
			<div class="product-review mx-4 pb-4 mb-4 border-bottom">
				<div class="d-flex align-middle me-4 pe-2">
					<h6 class="green-roboto px-2">4</h6>
					<div class="star-rating green">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="far fa-star"></i>
					</div>
				</div>
				<div class="text-muted ml-2">
					<small>공지수 | 2021.04.06</small>
				</div>
				<div class="mx-4 my-2">
					<div class="my-3">
						싸고 필요한 만큼만 있어서 좋아요 맛있어요
					</div>
					<div class="bg-light rounded-pill mt-3 py-1 w-25 text-center" type="button"> <i class="green far fa-thumbs-up"></i>
						<span class="green-roboto">0</span><small class="text-muted"> 명이 추천</small></div>
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
	</div>
	</div>

	<!-- /.container -->

	<!-- Modal -->

	<!-- 리뷰 작성 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content pb-4">
				<div class="modal-header">
					<h5 class="modal-title">리뷰 작성</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="form">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<select name="rating" id="rating"
										class="custom-select focus-shadow-0">
										<option value="5">★★★★★ (5/5)</option>
										<option value="4">★★★★☆ (4/5)</option>
										<option value="3">★★★☆☆ (3/5)</option>
										<option value="2">★★☆☆☆ (2/5)</option>
										<option value="1">★☆☆☆☆ (1/5)</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<textarea rows="4" name="review" id="review"
								placeholder="리뷰를 작성하세요" required="" class="form-control"></textarea>
						</div>
					</form>
				</div>
				<div class="text-center">
					<button type="button" class="btn btn-orange rounded-pill w-25 pb-2">작성하기</button>
				</div>
			</div>
		</div>
	</div>