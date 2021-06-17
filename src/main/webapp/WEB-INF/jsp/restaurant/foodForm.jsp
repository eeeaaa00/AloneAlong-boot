<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="card m-3 p-3 text-center">
	<h1>Menu Info</h1><hr>
   <div align="center">
     <form:form modelAttribute="food" ENCTYPE="multipart/form-data" method="post">
		<p>
			<form:label path="name">메뉴 이름</form:label>
			<form:input path="name" value="${food.name}" />
		</p>
		<p>
			<form:label path="price">가격</form:label>
			<form:input path="price" value="${food.price}" />
		</p>
		<p>
			<form:label path="description">설명</form:label>
			<form:input path="description" value="${food.description}"/>
		</p>
		<p>
			<form:label path="imgFile">이미지</form:label>
			<form:input type="file" path="imgFile" value="${food.imgFile}"/>
		</p>
		<p>
			<form:label path="maxPeopleNum">최대 주문가능 인원 수</form:label>
			<form:input path="maxPeopleNum" value="${food.maxPeopleNum}"/>
		</p>
		<p>
			<input class="btn btn-sm btn-outline-success" type="submit" value="메뉴 등록">
		</p>
	</form:form>
	</div>
</div>   