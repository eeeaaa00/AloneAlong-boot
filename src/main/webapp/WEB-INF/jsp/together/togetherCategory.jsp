<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-2">
	<form action='<c:url value="/together"/>'>
		<c:if test="${age != ''}"><input type="hidden" name="date" value="${date}"></c:if>
		<c:if test="${kind != 'all'}"><input type="hidden" name="kind" value="${kind}"></c:if>
		<c:if test="${price != '99999'}"><input type="hidden" name="price" value="${price}"></c:if>
		<c:if test="${sex != 'all'}"><input type="hidden" name="sex" value="${sex}"></c:if>
		<c:if test="${age != 'all'}"><input type="hidden" name="age" value="${age}"></c:if>
	
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${areaName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="area" value="all" type="submit">모든 지역</button>
				<button class="dropdown-item" name="area" value="seoul" type="submit">서울특별시</button>
				<button class="dropdown-item" name="area" value="busan" type="submit">부산광역시</button>
				<button class="dropdown-item" name="area" value="incheon" type="submit">인천광역시</button>
				<button class="dropdown-item" name="area" value="deagu" type="submit">대구광역시</button>
				<button class="dropdown-item" name="area" value="deageon" type="submit">대전광역시</button>
				<button class="dropdown-item" name="area" value="guangju" type="submit">광주광역시</button>
				<button class="dropdown-item" name="area" value="ulsan" type="submit">울산광역시</button>
			</div>
		</div>
	</form>
	
  	<form action='<c:url value="/together"/>'>
  		<c:if test="${area != 'all'}"><input type="hidden" name="area" value="${area}"></c:if>
  		<c:if test="${kind != 'all'}"><input type="hidden" name="kind" value="${kind}"></c:if>
		<c:if test="${price != '99999'}"><input type="hidden" name="price" value="${price}"></c:if>
		<c:if test="${sex != 'all'}"><input type="hidden" name="sex" value="${sex}"></c:if>
		<c:if test="${age != 'all'}"><input type="hidden" name="age" value="${age}"></c:if>
		
    	<input type="date" class="btn btn-outline-success rounded-pill my-1 btn-block" name="date" onchange='this.form.submit()' value="${date}" min="2021-06-01">
  	</form>
	
	<form action='<c:url value="/together"/>'>
		<c:if test="${area != 'all'}"><input type="hidden" name="area" value="${area}"></c:if>
		<c:if test="${age != ''}"><input type="hidden" name="date" value="${date}"></c:if>
		<c:if test="${price != '99999'}"><input type="hidden" name="price" value="${price}"></c:if>
		<c:if test="${sex != 'all'}"><input type="hidden" name="sex" value="${sex}"></c:if>
		<c:if test="${age != 'all'}"><input type="hidden" name="age" value="${age}"></c:if>
		
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${kindName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="kind" value="all" type="submit">모든 음식종류</button>
				<button class="dropdown-item" name="kind" value="korean" type="submit">한식</button>
				<button class="dropdown-item" name="kind" value="western" type="submit">양식</button>
				<button class="dropdown-item" name="kind" value="japanese" type="submit">일식</button>
				<button class="dropdown-item" name="kind" value="chinese" type="submit">중식</button>
				<button class="dropdown-item" name="kind" value="etc" type="submit">기타</button>
			</div>
		</div>
	</form>
	
	<form action='<c:url value="/together"/>'>
		<c:if test="${area != 'all'}"><input type="hidden" name="area" value="${area}"></c:if>
		<c:if test="${age != ''}"><input type="hidden" name="date" value="${date}"></c:if>
		<c:if test="${kind != 'all'}"><input type="hidden" name="kind" value="${kind}"></c:if>
		<c:if test="${sex != 'all'}"><input type="hidden" name="sex" value="${sex}"></c:if>
		<c:if test="${age != 'all'}"><input type="hidden" name="age" value="${age}"></c:if>
	
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${priceName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="price" value="99999" type="submit">모든 가격대</button>
				<button class="dropdown-item" name="price" value="10000" type="submit">10000원 미만</button>
				<button class="dropdown-item" name="price" value="15000" type="submit">15000원 미만</button>
				<button class="dropdown-item" name="price" value="20000" type="submit">20000원 미만</button>
				<button class="dropdown-item" name="price" value="25000" type="submit">25000원 미만</button>
				<button class="dropdown-item" name="price" value="30000" type="submit">30000원 미만</button>
			</div>
		</div>
	</form>
	
	<form action='<c:url value="/together"/>'>
		<c:if test="${area != 'all'}"><input type="hidden" name="area" value="${area}"></c:if>
		<c:if test="${age != ''}"><input type="hidden" name="date" value="${date}"></c:if>
		<c:if test="${kind != 'all'}"><input type="hidden" name="kind" value="${kind}"></c:if>
		<c:if test="${price != '99999'}"><input type="hidden" name="price" value="${price}"></c:if>
		<c:if test="${age != 'all'}"><input type="hidden" name="age" value="${age}"></c:if>
	
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${sexName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="sex" value="all" type="submit">모든 성별</button>
				<button class="dropdown-item" name="sex" value="female" type="submit">여성</button>
				<button class="dropdown-item" name="sex" value="male" type="submit">남성</button>
			</div>
		</div>
	</form>
	
	<form action='<c:url value="/together"/>'>
		<c:if test="${area != 'all'}"><input type="hidden" name="area" value="${area}"></c:if>
		<c:if test="${age != ''}"><input type="hidden" name="date" value="${date}"></c:if>
		<c:if test="${kind != 'all'}"><input type="hidden" name="kind" value="${kind}"></c:if>
		<c:if test="${price != '99999'}"><input type="hidden" name="price" value="${price}"></c:if>
		<c:if test="${sex != 'all'}"><input type="hidden" name="sex" value="${sex}"></c:if>
	
		<div class="dropdown">
			<button class="btn btn-outline-success rounded-pill my-1 btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"><c:out value="${ageName}"/></button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" name="age" value="all" type="submit">모든 나이</button>
				<button class="dropdown-item" name="age" value="10" type="submit">10대</button>
				<button class="dropdown-item" name="age" value="20" type="submit">20대</button>
				<button class="dropdown-item" name="age" value="30" type="submit">30대</button>
				<button class="dropdown-item" name="age" value="40" type="submit">40대</button>
				<button class="dropdown-item" name="age" value="50" type="submit">50대이상</button>
			</div>
		</div>
	</form>	
</div>

