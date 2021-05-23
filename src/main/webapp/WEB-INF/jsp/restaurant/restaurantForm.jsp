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
     <form:form modelAttribute="restaurant" >
		<p>
			<form:label path="resName">식당 이름</form:label>
			<form:input path="resName" />
		</p>
		<p>
			<form:label path="resAddress">주소</form:label>
			<form:input path="resAddress" />
		</p>
		<p>
			<form:label path="resPhone">번호</form:label>
			<form:input path="resPhone"/>
		</p>
		<p>
			<form:label path="resDescription">번호</form:label>
			<form:textarea path="resDescription" />
		</p>
		<p>
			<form:label path="categoryId">분류</form:label>
			<form:select path="categoryId" >
				<option value="">--- 선택하세요 ---</option>
				<option value="한식">한식</option>
				<option value="일식">일식</option>
				<option value="중식">중식</option>
				<option value="양식">양식</option>
				<option value="기타">기타</option>
			</form:select>
		</p>
		<p>
			<form:label path="isTogetherOk">같밥모집 허용여부</form:label>
			<form:checkbox path="isTogetherOk"  />
		</p>
		<p>
			<input type="submit" value="식당 등록">
		</p>
	</form:form>
	</div>
	