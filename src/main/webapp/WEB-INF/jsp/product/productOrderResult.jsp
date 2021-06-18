<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card align-middle"
	style="width: 50rem; border-radius: 20px;">
	<div class="card-body">
		<br>
		<h1>
			<i class="fa fa-check-circle-o" aria-hidden="true"  style="color:green"></i>
		</h1>
		<h4  style="color:green">결제 완료</h4>
		<hr>
		<br>
		<h5>감사합니다. </h5>
		<h5>
		${userSession.user.name}님의	상품 결제가 완료되었습니다.
		</h5>
		<br>
		<div class="row justify-content-around px-5 py-3">
			<h5>
				<button type="submit" class="btn btn-lg btn-green rounded-pill"onClick="location.href='<c:url value='/' />'">
					<i class="fa fa-home" aria-hidden="true"></i> 홈
				</button>
			</h5>
			<h5>
				<button type="submit" class="btn btn-lg btn-orange  rounded-pill"onClick="location.href='<c:url value='/myOrder' />'">
					<i class="fa fa-share" aria-hidden="true"></i> 구매내역
				</button>
			</h5>
		</div>
	</div>
</div>