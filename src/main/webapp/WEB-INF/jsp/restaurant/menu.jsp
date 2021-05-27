<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-2">
	<form action='<c:url value="/eating"/>'>
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown"
			aria-haspopup="true"><c:out value="${category1}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="category1" value="" type="submit"><small>전체</small></button>
				<button class="dropdown-item" name="category1" value="서울특별시" type="submit"><small>서울특별시</small></button>
				<button class="dropdown-item" name="category1" value="인천광역시" type="submit"><small>인천광역시</small></button>
				<button class="dropdown-item" name="category1" value="대구광역시" type="submit"><small>대구광역시</small></button>
				<button class="dropdown-item" name="category1" value="대전광역시" type="submit"><small>대전광역시</small></button>
				<button class="dropdown-item" name="category1" value="부산광역시" type="submit"><small>부산광역시</small></button>
				<button class="dropdown-item" name="category1" value="울산광역시" type="submit"><small>울산광역시</small></button>
				<button class="dropdown-item" name="category1" value="광주광역시" type="submit"><small>광주광역시</small></button>
			</div>
		</div>	
		<input type="hidden" name="category2" value="${category2}">
	</form>
	<form action='<c:url value="/eating"/>'>
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown"
			aria-haspopup="true"><c:out value="${category2}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="category2" value="" type="submit"><small>전체</small></button>
				<button class="dropdown-item" name="category2" value="한식" type="submit"><small>한식</small></button>
				<button class="dropdown-item" name="category2" value="분식" type="submit"><small>분식</small></button>
				<button class="dropdown-item" name="category2" value="양식" type="submit"><small>양식</small></button>
				<button class="dropdown-item" name="category2" value="중식" type="submit"><small>양식</small></button>
			</div>
		</div>
		<input type="hidden" name="category1" value="${category1}">
	</form>

</div>