<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action='<c:url value="/together"/>'>

<!-- 검색 필터 -->
	<div class="col-md-2">
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${areaName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="area" value="none" type="submit">모든 지역</button>
				<button class="dropdown-item" name="area" value="seoul" type="submit">서울특별시</button>
				<button class="dropdown-item" name="area" value="busan" type="submit">부산광역시</button>
				<button class="dropdown-item" name="area" value="incheon" type="submit">인천광역시</button>
				<button class="dropdown-item" name="area" value="deagu" type="submit">대구광역시</button>
				<button class="dropdown-item" name="area" value="deageon" type="submit">대전광역시</button>
				<button class="dropdown-item" name="area" value="guangju" type="submit">광주광역시</button>
				<button class="dropdown-item" name="area" value="ulsan" type="submit">울산광역시</button>
			</div>
		</div>
	
		<!-- 날짜 -->
		<!-- <input type="date" id="date" name="date" min="2021-05-01">  -->
		
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${kindName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="kind" value="none" type="submit">모든 음식종류</button>
				<button class="dropdown-item" name="kind" value="korean" type="submit">한식</button>
				<button class="dropdown-item" name="kind" value="western" type="submit">양식</button>
				<button class="dropdown-item" name="kind" value="japanese" type="submit">일식</button>
				<button class="dropdown-item" name="kind" value="chinese" type="submit">중식</button>
				<button class="dropdown-item" name="kind" value="etc" type="submit">기타</button>
			</div>
		</div>

        <div class="dropdown">
			<button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${priceName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="price" value="99999" type="submit">모든 가격대</button>
				<button class="dropdown-item" name="price" value="10000" type="submit">10000원 미만</button>
				<button class="dropdown-item" name="price" value="15000" type="submit">15000원 미만</button>
				<button class="dropdown-item" name="price" value="20000" type="submit">20000원 미만</button>
				<button class="dropdown-item" name="price" value="25000" type="submit">25000원 미만</button>
				<button class="dropdown-item" name="price" value="30000" type="submit">30000원 미만</button>
			</div>
		</div>

  		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${sexName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="sex" value="none" type="submit">모든 성별</button>
				<button class="dropdown-item" name="sex" value="female" type="submit">여성</button>
				<button class="dropdown-item" name="sex" value="male" type="submit">남성</button>
			</div>
		</div>
		
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${ageName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="age" value="none" type="submit">모든 나이</button>
				<button class="dropdown-item" name="age" value="10" type="submit">10대</button>
				<button class="dropdown-item" name="age" value="20" type="submit">20대</button>
				<button class="dropdown-item" name="age" value="30" type="submit">30대</button>
				<button class="dropdown-item" name="age" value="40" type="submit">40대</button>
				<button class="dropdown-item" name="age" value="50" type="submit">50대이상</button>
			</div>
		</div>
	</div>
</form>