<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<div class="py-5 text-center">
	
	<!-- 설명문 -->
	<c:if test="${isUserNull eq true}"> 
		<c:if test="${isHost eq true}"> <!-- 호스트 여부 -->
			<c:if test="${isPaid eq false}"> <!-- 결제 안됨 -->
				<div class="row align-items-center">
      				<div class="col-2"></div>
      				<div class="col-8">
        				<div class="alert alert-warning alert-dismissible fade show" role="alert">
  							<strong>아직 결제되지 않았습니다!</strong> 결제를 해주세요.
    						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    					</div>
      				</div>
      				<div class="col-2"></div>
    			</div>
			</c:if>
			<c:if test="${isPaid eq true}"> <!-- 결제됨 -->
				<div class="row align-items-center">
      				<div class="col-2"></div>
      				<div class="col-8">
        				<div class="alert alert-warning alert-dismissible fade show" role="alert">
  							<strong>수정 및 삭제 불가!</strong> 이미 결제 되었습니다.
    						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    					</div>
      				</div>
      				<div class="col-2"></div>
    			</div>
			</c:if>
		</c:if>
	</c:if>

	<br>
	<br>

	<h4><strong><c:out value="${together.togetherName}"/></strong><strong class="text-success">(<c:out value="${together.togetherMemberList.size()}"/>/<c:out value="${together.headCount}"/>)</strong></h4>
	<br>
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
    <br>
    <p><c:out value="${together.togetherDes}"/></p>
	<br>
	<br>
    <!-- 사진 -->
    <div class="row-md-6">
		<img src="data:image/jpeg;base64,${together.restaurant.img64}" style="width:900px; height:300px; object-fit: cover;" />
	</div>
</div>
<br>
<br>
<div class="row g-5">
	<!-- 같이밥 상세정보 -->
	<div class="col-md-7">
    	<h5 class="mb-3"><span class="text-success">날짜 및 시간</span></h5>
        <p><c:out value="${together.togetherDate}"/> / <c:out value="${together.togetherTime}"/></p>
        <br>
		<h5 class="mb-3"><span class="text-success">멤버</span></h5>
		<c:forEach var="togetherMember" items="${together.togetherMemberList}">
			<c:choose>
				<c:when test="${togetherMember.isHost eq 1}"><p><c:out value="${togetherMember.user.nickname}"/> <span class="badge bg-warning text-dark">주최자</span></p></c:when>
				<c:when test="${togetherMember.isHost eq 0}"><p><c:out value="${togetherMember.user.nickname}"/></p></c:when>
			</c:choose>
		</c:forEach>
		<br>
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
		<br>
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
<br>
<br>
<br>
<hr>

<!-- 신청하기 버튼 -->
<div class="py-5 text-right">
	<c:if test="${isUserNull eq false}"> <!-- 로그인 여부 -->
		<a type="button" class="w-40 btn btn-lg btn-success" href="<c:url value='/togetherOrder' />">신청하기</a>
	</c:if>
	<c:if test="${isUserNull eq true}"> 
		<c:if test="${isHost eq true}"> <!-- 호스트 여부 -->
			<c:if test="${isPaid eq false}"> <!-- 결제 여부 -->
				<a type="button" class="w-40 btn btn-lg btn-warning" href="<c:url value='/togetherOrder' />"><small><i class="far fa-credit-card pr-1"></i></small> 결제하기</a>
				<c:if test="${ifEditPossible eq true}"> <!-- 수정 가능 여부 -->
					<a type="button" class="w-40 btn btn-lg btn-success" href="<c:url value='/togetherUpdate/${together.togetherId}' />">수정하기</a>
					<a type="button" class="w-40 btn btn-lg btn-success" href="<c:url value='/togetherRegister/delete/${together.togetherId}' />">삭제하기</a>
				</c:if>
				<c:if test="${ifEditPossible eq false}">
					<button class="btn btn-green rounded-pill" onclick="javascript:btn('모집 중인 인원이 1명일 때만 가능합니다.' )">수정하기</button>
        			<button class="btn btn-green rounded-pill" onclick="javascript:btn('모집 중인 인원이 1명일 때만 가능합니다.' )">삭제하기</button>
				</c:if>
				
			</c:if>
			<c:if test="${isPaid eq true}">
				
			</c:if>
		</c:if>
		<c:if test="${isHost eq false}">
			<c:if test="${alreadyApply eq true}"> <!-- 이미 신청 여부 -->
				<button class="w-40 btn btn-lg btn-success" onclick="javascript:btn('이미 신청한 함께 먹기 입니다.' )">신청하기</button>
			</c:if>
			<c:if test="${alreadyApply eq false}">
				<c:if test="${ifCanApply eq true}"> <!-- 신청 조건 맞는지 여부 -->
					<a type="button" class="w-40 btn btn-lg btn-success" href="<c:url value='/togetherOrder' />">신청하기</a>
				</c:if>
				<c:if test="${ifCanApply eq false}">
					<button class="w-40 btn btn-lg btn-success" onclick="javascript:btn('성별 조건이 맞지 않습니다.' )">신청하기</button>
				</c:if>
			</c:if>
		</c:if>
	</c:if>
</div>

<script> 
function btn(message){ 
	alert(message); 
} 
</script>