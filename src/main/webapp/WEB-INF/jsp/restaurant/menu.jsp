<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-2">
	<a href="<c:url value='/eating' />" class="btn btn-outline-success rounded-pill my-1 btn-block active">지역</a>
		<a href="#" class="dropdown-menu active" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#"><small>서울특별시</small></a>
					<a class="dropdown-item" href="#"><small>인천광역시</small></a>
					<a class="dropdown-item" href="#"><small>대구광역시</small></a>
					<a class="dropdown-item" href="#"><small>대전광역시</small></a>
					<a class="dropdown-item" href="#"><small>부산광역시</small></a>
					<a class="dropdown-item" href="#"><small>울산광역시</small></a>
					<a class="dropdown-item" href="#"><small>광주광역시</small></a>
		</a>
	<a href="#" class="btn btn-outline-success rounded-pill my-1 btn-block">분류</a>
		<a href="#" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#"><small>분식</small></a>
					<a class="dropdown-item" href="#"><small>한식</small></a>
					<a class="dropdown-item" href="#"><small>양식</small></a>
		</a>
</div>