<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
b {color:#29A65F;}

.swiper-container {
}
.swiper-slide {
	text-align:left;
 	margin: 5px;
	align-items:center;
	justify-content:center;
}
</style>

<div class="py-3 text-center">
	<p>함께 먹기 제안하기 <a type="button" class="btn btn-sm btn-outline-success" href="<c:url value='/togetherRegister' />"><small> <i class="fas fa-utensils"></i></small> 등록</a></p>
</div>

<!-- 추천 기능 -->
<c:if test="${userSession != null}">
<div class="swiper-container">
	<p><b><c:out value="${user.name}"/></b>님을 위한 함께 먹기 추천</p>
	<div class="swiper-wrapper">
		<c:forEach var="recommand" items="${recommandList}">
			<div class="swiper-slide">
				<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/together/${recommand.togetherId}' />'">
            		<div class="col p-4 d-flex flex-column position-static">
            			<!-- 태그 -->
                		<div class="row-md-6">
                			<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${recommand.getAddressTag()}"/></span>
                			<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${recommand.restaurant.categoryId}"/></span>
                			<c:if test="${recommand.sex != '상관없음'}">
                			<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${recommand.sex}"/></span>
                			</c:if>
                			<c:if test="${recommand.age != '상관없음'}">
                			<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${recommand.age}"/></span>
                			</c:if>
                		</div >
                		<!-- 같이밥 정보 -->
                		<h3 class="mb-0"><c:out value="${recommand.togetherName}"/><strong class="text-success">(<c:out value="${recommand.togetherMemberList.size()}"/>/<c:out value="${recommand.headCount}"/>)</strong></h3>
                		<div class="mb-1 text-muted"><c:out value="${recommand.togetherDate}"/> / <c:out value="${recommand.togetherTime}"/></div>
                		<p class="card-text mb-auto">식당명 : <c:out value="${recommand.restaurant.resName}"/></p>
                		<p class="card-text mb-auto">메뉴 : <c:forEach var="togetherFood" items="${recommand.togetherFoodList}"><c:out value="${togetherFood.food.name}"/> </c:forEach></p>
                		<p class="card-text mb-auto">1인 <c:out value="${recommand.price}"/>원</p>
              		</div>
        		</div>
			</div>
		</c:forEach>
	</div>
	<div class="swiper-button-next"></div> <!-- 네비게이션 -->
	<div class="swiper-pagination"></div> <!-- 페이징 -->
</div>
</c:if>

총 <b>${togetherList.size()}</b>개의 함께 먹기가 있습니다.

<!-- 같이밥 목록 -->
<div class="row mb-2">
	
	<c:forEach var="together" items="${togetherList}">
		<div class="col-md-6">
        	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/together/${together.togetherId}' />'">
            	<div class="col p-4 d-flex flex-column position-static">
            		<!-- 태그 -->
                	<div class="row-md-6">
                		<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.getAddressTag()}"/></span>
                		<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.restaurant.categoryId}"/></span>
                		<c:if test="${together.sex != '상관없음'}">
                		<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.sex}"/></span>
                		</c:if>
                		<c:if test="${together.age != '상관없음'}">
                		<span class="badge rounded-pill bg-warning text-dark">#<c:out value="${together.age}"/></span>
                		</c:if>
                	</div >
                	<!-- 같이밥 정보 -->
                	<h3 class="mb-0"><c:out value="${together.togetherName}"/><strong class="text-success">(<c:out value="${together.togetherMemberList.size()}"/>/<c:out value="${together.headCount}"/>)</strong></h3>
                	<div class="mb-1 text-muted"><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></div>
                	<p class="card-text mb-auto">식당명 : <c:out value="${together.restaurant.resName}"/></p>
                	<p class="card-text mb-auto">메뉴 : <c:forEach var="togetherFood" items="${together.togetherFoodList}"><c:out value="${togetherFood.food.name}"/> </c:forEach></p>
                	<p class="card-text mb-auto">1인 <c:out value="${together.price}"/>원</p>
              	</div>
        	</div>
    	</div>
	</c:forEach>

    <!-- 예시용 시작 지점 ///////////////////////////////////////////////추후 삭제 예정 -->
    <div class="col-md-6">
    	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        	<div class="col p-4 d-flex flex-column position-static">
            	<div class="row-md-6">
                	<span class="badge rounded-pill bg-primary">#서울</span>
                 	<span class="badge rounded-pill bg-primary">#한식</span>
                	<span class="badge rounded-pill bg-primary">#여성</span>
                	<span class="badge rounded-pill bg-primary">#20대</span>
                </div>
                <h3 class="mb-0">삼겹살 같이 먹어요<strong class="d-inline-block mb-2 text-primary">(1/2)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ식당</p>
                <p class="card-text mb-auto">메뉴 : 삼겹살, 물냉면, 공기밥</p>
                <p class="card-text mb-auto">1인 16500원</p>
        	</div>
    	</div>
	</div>

    <div class="col-md-6">
    	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        	<div class="col p-4 d-flex flex-column position-static">
            	<div class="row-md-6">
                	<span class="badge rounded-pill bg-primary">#서울</span>
                  	<span class="badge rounded-pill bg-primary">#한식</span>
                  	<span class="badge rounded-pill bg-primary">#남성</span>
                  	<span class="badge rounded-pill bg-primary">#30대</span>
                </div>
                <h3 class="mb-0">소주에 곱창 드실 분<strong class="d-inline-block mb-2 text-primary">(1/2)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ곱창</p>
                <p class="card-text mb-auto">메뉴 : 곱창, 볶음밥, 소주</p>
                <p class="card-text mb-auto">1인 22200원</p>
            </div>
		</div>
	</div>

    <div class="col-md-6">
    	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        	<div class="col p-4 d-flex flex-column position-static">
            	<div class="row-md-6">
                	<span class="badge rounded-pill bg-primary">#경기</span>
                  	<span class="badge rounded-pill bg-primary">#양식</span>
                </div>
                <h3 class="mb-0">치맥해요<strong class="d-inline-block mb-2 text-primary">(1/4)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ치킨</p>
                <p class="card-text mb-auto">메뉴 : 후라이드치킨, 마늘치킨, 생맥주</p>
                <p class="card-text mb-auto">1인 15000원</p>
			</div>
		</div>
	</div>

    <div class="col-md-6">
    	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        	<div class="col p-4 d-flex flex-column position-static">
            	<div class="row-md-6">
                	<span class="badge rounded-pill bg-primary">#부산</span>
                  	<span class="badge rounded-pill bg-primary">#한식</span>
                </div>
                <h3 class="mb-0">비오는 날엔 파전에 막걸리<strong class="d-inline-block mb-2 text-primary">(1/3)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ주막</p>
                <p class="card-text mb-auto">메뉴 : 해물파전, 모둠전, 막걸리</p>
                <p class="card-text mb-auto">1인 15000원</p>
			</div>
		</div>
	</div>
	<!-- 예시용 끝 -->

<!-- script -->	
<script>
new Swiper('.swiper-container', {
	slidesPerView : 2, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 38, // 슬라이드간 간격
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

</div>