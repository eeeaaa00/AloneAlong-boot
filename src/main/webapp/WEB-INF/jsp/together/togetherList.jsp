<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="py-3 text-center">
	<p>같이 먹기 제안하기 <a class="btn btn-primary" href="<c:url value='/together/togetherRegister' />" role="button">등록</a></p>
</div>

<!-- 같이밥 목록 -->
<div class="row mb-2">
	
	<c:forEach var="together" items="${togetherList}">
		<div class="col-md-6">
        	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/togetherInfo/${together.togetherId}' />'">
            	<div class="col p-4 d-flex flex-column position-static">
            		<!-- 태그 -->
                	<div class="row-md-6">
                		<!-- 수정해야함 -->
                		<span class="badge rounded-pill bg-primary">#서울</span> <!-- 지역 태그 ////////////////////////// 수정 필요 -->
                		<span class="badge rounded-pill bg-primary">#한식</span> <!-- 카테고리 태그 //////////////////////// 수정 필요 -->
                		<c:if test="${together.sex != '상관없음'}">
                		<span class="badge rounded-pill bg-primary">#<c:out value="${together.sex}"/></span>
                		</c:if>
                		<c:if test="${together.age != '상관없음'}">
                		<span class="badge rounded-pill bg-primary">#<c:out value="${together.age}"/></span>
                		</c:if>
                	</div >
                	<!-- 같이밥 정보 -->
                	<h3 class="mb-0"><c:out value="${together.togetherName}"/><strong class="d-inline-block mb-2 text-primary">(<c:out value="${together.getNumOfMem()}"/>/<c:out value="${together.headCount}"/>)</strong></h3>
                	<div class="mb-1 text-muted"><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></div>
                	<p class="card-text mb-auto">식당명 : <c:out value="${together.restaurant.resName}"/></p>
                	<p class="card-text mb-auto">메뉴 : <c:forEach var="togetherFood" items="${together.togetherFoodList}"><c:out value="${togetherFood.food.name}"/> </c:forEach></p>
                	<p class="card-text mb-auto">1인 <c:out value="${together.getPricePerPerson()}"/>원</p>
              	</div>
        	</div>
    	</div>
	</c:forEach>

    <!-- 예시용 시작 지점 ///////////////////////////////////////////////추후 삭제 예정 -->
    <div class="col-md-6">
    	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/togetherInfo/111' />'">
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

</div>