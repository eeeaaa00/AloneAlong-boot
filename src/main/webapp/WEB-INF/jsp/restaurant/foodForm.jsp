<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
span{
	color: #FF0000;
	font-size: smaller;
}
</style> 
<script>
$(function () {
	   var $inputEle = $("#imgFile");
	   $inputEle.change(function() {
		   var f = this.files[0];
        var size = f.size || f.fileSize;
		   if(size > 500000)
		    {
		       alert("최대 파일 사이즈는 500kb입니다.");
		       $("#imgFile").val('');
		    }
	   })
	});
</script>
<div class="card m-3 p-3 text-center">
	<h1>Menu Info</h1><hr>
   <div align="center">
     <form:form modelAttribute="food" ENCTYPE="multipart/form-data" method="post">
		<p>
			<form:label path="name">메뉴 이름</form:label>
			<form:input path="name" value="${food.name}" />
			<form:errors path="name"/>
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
			<form:input id="imgFile" type="file" path="imgFile"/>
			<form:errors path="img64"/>
		</p>
		<p>
			<form:label path="maxPeopleNum">최대 주문가능 인원 수</form:label>
			<form:input path="maxPeopleNum" value="${food.maxPeopleNum}"/>
		</p>
		<p>
			<form:hidden path="img64" value="${food.img64}"/>
			<input class="btn btn-sm btn-outline-success" type="submit" value="메뉴 등록">
		</p>
	</form:form>
	</div>
</div>   