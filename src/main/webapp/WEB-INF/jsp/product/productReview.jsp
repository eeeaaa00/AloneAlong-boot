<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.btn-recommend { background-color:#f8f9fa; }
.btn-recommend:hover, .btn-recommend:focus, .btn-recommend.active
	{  color:#F27024; border-color:#F27024; }
</style>
<script type="text/javascript">
$(document).on("click", ".open-updateModal", function () {
     var reviewId = $(this).data('id');
     var reviewContents = $(this).data('contents');
     $(".modal-body #reviewId").val(reviewId);
     $(".modal-body #reviewContents").val(reviewContents);
});
$(document).on("click", ".open-deleteModal", function () {
    var reviewId = $(this).data('id');
    $(".modal-body #reviewId").val(reviewId);
});
</script>

<div class="row my-5 mx-5">
	<div class="col-md-12" style="width:100%;">
      <div class="shadow-sm rounded-lg">
        <!-- Tabs-->
        <ul class="nav nav-tabs nav-fill" role="tablist">
          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/shop/${productId}?quantity=${product.quantity}' />" >상세 정보</a></li>
          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active">상품 리뷰</a></li>
        </ul>
        
        <!-- 내용 -->
        <div class="review-content pb-3 mb-5 border">
          <!-- 상단 리뷰 통계 -->
          <div class="bg-light py-5">
          	<div class="row align-items-center">
          		<div class="col-md-1"></div>
          		<div class="col-md-3 text-center">
          			<h4><i class="text-green fas fa-comment-dots"></i></h4>
          			<h4 class="text-green pb-1">리뷰 수</h4>
          			<h4><b class="text-orange-roboto">${numOfReviews}</b><small> 개</small></h4>
          		</div>
          		<div class="col-md-4 text-center align-items-center">
          			<h4><i class="far text-green fa-star"></i></h4>
          			<h4 class="text-green pb-1">평균 평점</h4>
          			<h4><b class="text-orange-roboto"><fmt:formatNumber value="${averageOfReviews}" pattern="#.#" /></b><small> 점</small></h4>
          		</div>
          		<div class="col-md-3 text-center align-items-center">
          			<h4><i class="text-green fas fa-signal"></i></h4>
          			<h4 class="text-green pb-1">최다 평점</h4>
          			<h4><b class="text-orange-roboto">${mostRatingOfReviews}</b><small> 점</small></h4>
          		</div>
          		<div class="col-md-1"></div>
          	</div>
          </div>

		  <div class="px-5 pt-lg-5">
          	<!-- 상단 -->
			<div class="d-flex justify-content-between pb-4 px-4 border-bottom mb-4">
			
				<!-- 드롭다운 -->
				<form action='<c:url value="/shop/${productId}/review"/>'>
				<input type="hidden" name="quantity" value="${product.quantity}"/>
				<div class="dropdown">
					<button class="btn btn-sm dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true"><c:out value="${sortTypeName}"/></button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<button class="dropdown-item" name="sortType" value="new" type="submit"><small>최신순</small></button>
						<button class="dropdown-item" name="sortType" value="recommend" type="submit"><small>추천순</small></button>
						<button class="dropdown-item" name="sortType" value="highRating" type="submit"><small>높은 평점순</small></button>
						<button class="dropdown-item" name="sortType" value="lowRating" type="submit"><small>낮은 평점순</small></button>
						</div>
				</div>
				</form>
				
				<!-- 리뷰 작성 -->
				<c:if test="${isPurchaser == true}">
				<button type="button" class="btn btn-sm btn-orange rounded-pill px-3"
				data-toggle="modal" data-target="#insertModal"><i class="far fa-edit"></i> 작성하기</button>
				</c:if>
          	</div>

			<!-- 리뷰 목록 -->
			<c:if test="${numOfReviews == 0}">
				<div class="text-center my-5 py-5">등록된 리뷰가 없습니다.</div>
			</c:if>
			<c:forEach items="${reviewList}" var="review" varStatus="idx">
			<div class="product-review pb-4 mb-4 border-bottom">
				<div class="d-flex align-middle col-md-6">
					<h6 class="text-green-roboto px-2">${review.rating}</h6>
					<div class="star-rating text-green">
						<c:forEach begin="1" end="${review.rating}">
							<i class="fas fa-star"></i>
						</c:forEach>
						<c:forEach begin="${review.rating + 1}" end="5">
							<i class="far fa-star"></i>
						</c:forEach>
					</div>
				</div>
				<div class="text-muted mx-2 row">
					<div class="col-md-6">
						<small>${review.nickname} | <fmt:formatDate value="${review.reviewDate}" pattern="yyyy.MM.dd"/></small>
					</div>
					<c:if test="${review.userId eq userId}">
					<div class="col-md-6 text-right">
						<a class="textbtn-gray open-updateModal" data-contents="${review.reviewContents}" data-id="${review.reviewId}" data-toggle="modal" data-target="#updateModal" ><small><i class="fas fa-pen mx-2"></i></small></a>
						<a class="textbtn-gray open-deleteModal" data-id="${review.reviewId}" data-toggle="modal" data-target="#deleteModal" ><small><i class="far fa-trash-alt"></i></small></a>
					</div>
					</c:if>
				</div>
				<div class="mx-4 my-2">
					<div class="my-3 mx-2">
						<c:out value="${review.reviewContents}"/>
					</div>
					<a class="btn btn-sm btn-recommend rounded-pill mt-3 py-1 w-25 text-center text-green-roboto"
						href='<c:url value="/shop/${productId}/review/recommend/${review.reviewId}"/>'>
						<c:if test="${review.checkRecommend eq false}">
						<i class="far fa-thumbs-up"></i>
						</c:if>
						<c:if test="${review.checkRecommend eq true}">
						<i class="fas fa-thumbs-up"></i>
						</c:if>
						${review.recommend}<small class="text-gray"> 명이 추천</small>
					</a>
				</div>
			</div>
			</c:forEach>
		  </div>
		  <!-- 페이지네이션 -->
		  <c:if test="${reviewList.size() > 0}">
		  <div class="row my-xl-5 justify-content-center">
			<div class="paginate mb-xl-5 btn-toolbar" role="toolbar">
				 <c:if test="${page <= 5}">
				 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-left"></i></button>
				 </c:if>
				 <c:if test="${page > 5}">
				 	 <button type="button" class="btn" onClick="location.href='<c:url value='/shop/${pcId}/review?quantity=${quantity}&page=${startPage - 5}&sortType=${param.sortType}' />'">
				 	 	<i class="fas fa-chevron-left"></i></button>
				 </c:if>
				 <c:forEach var="pageNum" begin="${startPage}" end="${startPage + 4}" varStatus="status">
					 <c:if test="${pageNum == page}">
				 		<div class="btn-group"><button type="button" class="btn active rounded-circle" 
				 			onClick="location.href='<c:url value='/shop/${pcId}/review?quantity=${quantity}&page=${pageNum}&sortType=${param.sortType}' />'">${pageNum}</button></div>
					 </c:if>
					 <c:if test="${pageNum != page && pageNum <= lastPage}">
				 		<div class="btn-group"><button type="button" class="btn rounded-circle"
				 			onClick="location.href='<c:url value='/shop/${pcId}/review?quantity=${quantity}&page=${pageNum}&sortType=${param.sortType}' />'">${pageNum}</button></div>
					 </c:if>
				 </c:forEach>
				 <c:if test="${startPage == (lastPage - lastPage % 5 + 1)}">
				 	 <button type="button" class="btn" disabled><i class="fas fa-chevron-right"></i></button>
				 </c:if>
				 <c:if test="${startPage != (lastPage - lastPage % 5 + 1)}">
				 	 <button type="button" class="btn" onClick="location.href='<c:url value='/shop/${pcId}/review?quantity=${quantity}&page=${startpage + 6}&sortType=${param.sortType}' />'">
				 	 	<i class="fas fa-chevron-right"></i></button>
				 </c:if>
			</div>
		  </div>
		  </c:if>
        </div>
      </div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<form action='<c:url value="/shop/review/delete"/>'>
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content py-5">
			<div class="modal-body text-center pb-4">
				<h6>정말 삭제하시겠습니까?</h6>
				<input type="hidden" name="productId" id="productId" value="${productId}"/>
				<input type="hidden" name="reviewId" id="reviewId" value=""/>
			</div>
			<div class="row mx-5 mb-2 justify-content-center">
				<a type="button" class="btn btn-green rounded-pill mx-2 py-2 px-3"
					data-dismiss="modal">취소</a>
				<button type="submit" class="btn btn-orange rounded-pill mx-2 py-2 px-3">삭제</button>
			</div>
		</div>
	</div>
	</form>
</div>
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<form
		action='<c:url value="/shop/review/update"/>'>
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content pb-4">
				<div class="modal-header">
					<h5 class="modal-title">리뷰 수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<select name="rating" class="custom-select focus-shadow-0">
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
						<textarea rows="4" name="contents" id="reviewContents" required=""
							class="form-control" maxlength="300">${review.reviewContents}</textarea>
					</div>
					<input type="hidden" name="productId" id="productId" value="${productId}"/>
					<input type="hidden" name="reviewId" id="reviewId" value=""/>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-orange rounded-pill w-25 pb-2">수정하기</button>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-hidden="true">
	<form action='<c:url value="/shop/review/insert"/>'>
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
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<select name="rating" class="custom-select focus-shadow-0">
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
							<textarea rows="4" name="contents" id="review"
								placeholder="리뷰를 작성하세요" required="" class="form-control"  maxlength="300"></textarea>
						</div>
					<input type="hidden" name="productId" id="productId" value="${productId}"/>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-orange rounded-pill w-25 pb-2">작성하기</button>
				</div>
			</div>
		</div>
	</form>
</div>