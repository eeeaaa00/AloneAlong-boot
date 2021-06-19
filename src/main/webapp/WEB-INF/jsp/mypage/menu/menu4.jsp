<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-2">
	<a href="<c:url value='/mypage' />"
		class="btn btn-outline-success rounded-pill my-1 btn-block">정보
		변경</a> <a href="<c:url value='/myCredit' />"
		class="btn btn-outline-success rounded-pill my-1 btn-block">결제 관리</a> <a href="<c:url value='/myOrder' />"
		class="btn btn-outline-success rounded-pill my-1 btn-block">구매 내역</a>
	<a href="<c:url value='/myResOrder' />" class="btn btn-outline-success rounded-pill my-1 btn-block   active">식당
		예약</a> <a href="<c:url value='/myTogetherOrder' />"
		class="btn btn-outline-success rounded-pill my-1 btn-block">함께먹기 예약</a>
	
	<%if(session.getAttribute("businum") != null) {%>
		<hr>	
		<a href="<c:url value='/eating/adminRes' />" class="btn btn-outline-info rounded-pill my-1 btn-block">식당 관리</a>
	<% } %>
</div>
