<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else { 
                addr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById("resAddress").value = extraAddr;
            
            } else {
                document.getElementById("resAddress").value = '';
            }
            var addArray=addr.split(' ');
            switch(addArray[0]){
            case '서울':
            	document.getElementById("resArea").options[1].selected = true;
            	break;
            case '경기':
            	document.getElementById("resArea").options[2].selected = true;
            	break;
            case '인천':
            	document.getElementById("resArea").options[3].selected = true;
            	break;
            case '대구':
            	document.getElementById("resArea").options[4].selected = true;
            	break;
            case '대전':
            	document.getElementById("resArea").options[5].selected = true;
            	break;
            case '부산':
            	document.getElementById("resArea").options[6].selected = true;
            	break;
            case '울산':
            	document.getElementById("resArea").options[7].selected = true;
            	break;
            case '광주':
            	document.getElementById("resArea").options[8].selected = true;
            	break;
            
            }
            document.getElementById("resAddress").value = addr + " ";
            document.getElementById("resAddress").focus();
        }
    }).open();
}
</script>
<style>
span{
	color: #FF0000;
	font-size: smaller;
}
</style> 
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
<div class="col-md-12 mb-3 text-center">
   
   <div style="text-align: left;">
     <form:form modelAttribute="restaurant" ENCTYPE="multipart/form-data">
		<div class="form-group d-flex align-items-center row">
			<form:label class="col-4" path="resName">식당 이름</form:label> 
			<div class="col-4">
			<form:input class="form-control" path="resName" value="${res.resName}" maxlength="15"/>
			<form:errors class="errors1" path="resName"/>
			</div>
		</div>
		
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> 
			<form:label path="categoryId">분류</form:label></div>
			<div class="col-4">
			<form:select class="form-control" path="categoryId" >
				<option value="">--- 선택하세요 ---</option>
				<option value="한식">한식</option>
				<option value="일식">일식</option>
				<option value="중식">중식</option>
				<option value="양식">양식</option>
				<option value="기타">기타</option>
			</form:select>
			<form:errors path="categoryId"/>
			</div>
		</div>
		
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> 
			<form:label path="resArea">지역</form:label></div>
			<div class="col-4">
			<form:select class="form-control" path="resArea">
				<form:option value="">--- 선택하세요 ---</form:option>
				<form:option value="서울특별시">서울특별시</form:option>
				<form:option value="경기도">경기도</form:option>
				<form:option value="인천광역시">인천광역시</form:option>
				<form:option value="대구광역시">대구광역시</form:option>
				<form:option value="대전광역시">대전광역시</form:option>
				<form:option value="부산광역시">부산광역시</form:option>
				<form:option value="울산광역시">울산광역시</form:option>
				<form:option value="광주광역시">광주광역시</form:option>
			</form:select>
			<form:errors path="resArea"/>
			</div>
			<button type="button" class="btn btn-orange" onClick="sample6_execDaumPostcode()">주소 찾기</button>
		</div>
		
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"><form:label path="resAddress">주소</form:label></div>
			<div class="col-8">
			<form:input class="form-control w-100" path="resAddress" value="${res.resAddress}" maxlength="20"/>
			<form:errors path="resAddress"/>
			</div>
		</div>
		
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> <form:label path="imgFile">이미지</form:label></div>
			<div class="col-8">
			<form:input id="imgFile" class="form-control-file w-100" type="file" path="imgFile" accept=".jpg, .jpeg, .png"/>
			<form:errors path="img64"/>
			</div>
		</div>
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> <form:label path="resPhone">번호</form:label></div>
			<div class="col-8">
			<form:input class="form-control w-100" path="resPhone" value="${res.resPhone}" placeholder="00(0)-000(0)-0000" maxlength="15"/>
			<form:errors path="resPhone"/>
			</div>
		</div>
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> 
			<form:label path="resDescription">소개</form:label></div>
			<div class="col-8">
			<form:textarea class="form-control w-100" path="resDescription" maxlength="80"></form:textarea>
			</div>
		</div>
		
		<div class="form-group d-flex align-items-center row">
			<div class="col-4"> 
			<form:label path="isTogetherOk" >같밥모집 허용여부</form:label></div>
			<div class="m-3 custom-control custom-checkbox">
				<form:checkbox path="isTogetherOk" class="custom-control-input" id="isTogetherOk"/>
			<label class="custom-control-label" for="isTogetherOk">허용</label>
			</div>
		</div>
		<p>
			<form:hidden path="img64" value="${res.imgFile}"/>
		</p>
		<div class="text-center">
			<c:if test="${empty res.resId}">
				<input type="hidden" id="status" name="status" value="insert">
				<input class="btn px-5 btn-lg btn-outline-success" type="submit" value="식당 등록" style="align:left;">
			</c:if>
			<c:if test="${!empty res.resId}">
				<input type="hidden" id="status" name="status" value="update">
				<input type="hidden" id="resId" name="resId" value="${res.resId}">
				<input class="btn px-5 btn-lg btn-outline-info" type="submit" value="식당 업데이트" style="align:left;">
			</c:if>
		</div>
	</form:form>
	</div>
</div>  