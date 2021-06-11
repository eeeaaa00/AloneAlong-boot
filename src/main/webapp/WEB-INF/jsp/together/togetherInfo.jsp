<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<div class="py-5 text-center">
	<h4><strong><c:out value="${together.togetherName}"/></strong><strong class="text-success">(<c:out value="${together.togetherMemberList.size()}"/>/<c:out value="${together.headCount}"/>)</strong></h4>
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
    <p><c:out value="${together.togetherDes}"/></p>

    <!-- 사진 -->
    <div class="row-md-6">
		<svg class="img" style="background-image: url('https://post-phinf.pstatic.net/MjAyMDAzMDNfMTcg/MDAxNTgzMTkwNjA3ODQ5.kUXPHqGJ2xPDSu_3FiEoFC3kY9QyQ_g9CziCGrFSDuEg.LpCfOTbc5qth9d-GKzGv9jwj2VKhcqmPHp5cp1KJYEsg.JPEG/IM_food02.jpg?type=w1200');
								background-size: cover; background-position:center; width:100%; height:200px;"></svg>
	</div>
</div>

<div class="row g-5">
	<!-- 같이밥 상세정보 -->
	<div class="col-md-7">
    	<h5 class="mb-3"><span class="text-success">날짜 및 시간</span></h5>
        <p><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></p>
		<h5 class="mb-3"><span class="text-success">멤버</span></h5>
		<c:forEach var="togetherMember" items="${together.togetherMemberList}">
			<c:choose>
				<c:when test="${togetherMember.isHost eq 1}"><p><c:out value="${togetherMember.user.name}"/> <span class="badge bg-warning text-dark">주최자</span></p></c:when>
				<c:when test="${togetherMember.isHost eq 0}"><p><c:out value="${togetherMember.user.name}"/></p></c:when>
			</c:choose>
		</c:forEach>
		<h5 class="mb-3"><span class="text-success">조건</span></h5>
		<p>성별 : <c:out value="${together.sex}"/></p>
		<p>나이 : <c:out value="${together.age}"/></p>
	</div>

	<!-- 식당 및 메뉴 정보 -->
	<div class="col-md-7 col-lg-5 order-md-last">
		<!-- 식당 정보 -->
		<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-success">식당</span></h5>
		<p>식당명 : <c:out value="${together.restaurant.resName}"/></p>
		<p>주소 : <c:out value="${together.restaurant.resAddress}"/></p>

		<!-- 메뉴 정보 -->
		<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-success">메뉴</span></h5>
		<ul class="list-group mb-3">
			<!-- 각 메뉴 수량 및 가격 -->
			<c:forEach var="togetherFood" items="${together.togetherFoodList}">
			<li class="list-group-item d-flex justify-content-between lh-sm">
				<div>
					<h6 class="my-0"><c:out value="${togetherFood.food.name}"/> <c:out value="${togetherFood.quantity}"/>개</h6>
					<small class="text-muted"><c:out value="${togetherFood.food.price}"/>원 * <c:out value="${togetherFood.quantity}"/>개</small>
                </div>
                <span class="text-muted"><c:out value="${togetherFood.getUnitTotalPrice()}"/>원</span>
			</li>
			</c:forEach>
			
			<!-- 합계 및 1인 가격 -->
            <li class="list-group-item d-flex justify-content-between bg-light">
				<strong><span>합계</span></strong>
                <strong><c:out value="${together.getTotalPrice()}"/>원</strong>
            </li>
			<li class="list-group-item d-flex justify-content-between bg-light">
            	<div class="text-success">
                	<h6 class="my-0">1인</h6>
                </div>
                <span class="text-success"><strong><c:out value="${together.getPricePerPerson()}"/>원</strong></span>
            </li>
		</ul>
	</div>
</div>

<!-- 신청하기 버튼 -->
<div class="py-5 text-right">
	<a type="button" class="w-40 btn btn-lg btn-success" href="<c:url value='/togetherOrder' />">신청하기</a>
</div>