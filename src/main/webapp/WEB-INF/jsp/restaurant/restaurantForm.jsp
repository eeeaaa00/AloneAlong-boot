<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<script>
$(document).ready(function() {
    $('select[id="resArea"] option:contains("${res.area}")').attr("selected",true);
    $('select[id="categoryId"] option:contains("${res.categoryId}")').attr("selected",true);
    $('textarea[id="resDescription"]').text("${res.resDescription}");

    
    var check = ${res.isTogetherOk};
    console.log('check', check);
    $('input:checkbox[name="isTogetherOk"]').each(function(index, element){
        $(this).next('label').addClass("ui-state-active");
        $(this).next('label').attr('aria-pressed', true);
        $(this).attr('checked', check);
      });
    console.log('check', check);
});

</script> 
<div class=" mb-3 p-3 text-center">
   
   <div style="text-align: left; margin-left : 15px;">
     <form:form modelAttribute="restaurant" ENCTYPE="multipart/form-data" method="post">
		<p>
			<form:label path="resName">식당 이름</form:label>
			<form:input path="resName" value="${res.resName}"/>
		</p>
		<p>
			<form:label path="resAddress">주소</form:label>
			<form:input path="resAddress" value="${res.resAddress}"/>
		</p>
		<p>
			<form:label path="imgFile">이미지</form:label>
			<form:input type="file" path="imgFile" value="${res.imgFile}"/>
		</p>
		<p>
			<form:label path="resPhone">번호</form:label>
			<form:input path="resPhone" value="${res.resPhone}"/>
		</p>
		<p>
			<form:label path="resDescription">소개</form:label>
			<form:textarea path="resDescription"></form:textarea>
		</p>
		
		<p>	
			<form:label path="resArea">지역</form:label>
			<form:select path="resArea" >
				<option value="">--- 선택하세요 ---</option>
				<option value="서울특별시">서울특별시</option>
				<option value="인천광역시">인천광역시</option>
				<option value="대구광역시">대구광역시</option>
				<option value="대전광역시">대전광역시</option>
				<option value="부산광역시">부산광역시</option>
				<option value="울산광역시">울산광역시</option>
				<option value="광주광역시">광주광역시</option>
			</form:select>
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
			<form:label path="isTogetherOk" >같밥모집 허용여부</form:label>
			<form:checkbox path="isTogetherOk"/>


			
		</p>
		<p>
			<c:if test="${empty res.resId}">
				<input type="hidden" id="status" name="status" value="insert">
				<input class="btn btn-sm btn-outline-success" type="submit" value="식당 등록" style="align:left;">
			</c:if>
			<c:if test="${!empty res.resId}">
				<input type="hidden" id="status" name="status" value="update">
				<input type="hidden" id="resId" name="resId" value="${res.resId}">
				<input class="btn btn-sm btn-outline-success" type="submit" value="식당 업데이트" style="align:left;">
			</c:if>
		</p>
	</form:form>
	</div>
	</div>   