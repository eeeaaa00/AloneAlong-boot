<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>a{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>
   
   <div align="center">
     <form:form modelAttribute="food" >
		<p>
			<form:label path="name">메뉴 이름</form:label>
			<form:input path="name" />
		</p>
		<p>
			<form:label path="price">가격</form:label>
			<form:input path="price" />
		</p>
		<p>
			<form:label path="description">설명</form:label>
			<form:input path="description" />
		</p>
		<p>
			<form:label path="imgFile">이미지</form:label>
			<form:input type="file" path="imgFile" />
		</p>
		<p>
			<form:label path="maxPeopleNum">최대 주문가능 인원 수</form:label>
			<form:input path="maxPeopleNum" />
		</p>
		<p>
			<input type="submit" value="메뉴 등록">
		</p>
	</form:form>
	</div>
	