<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action='<c:url value="/shop"/>'>
	<c:forEach var="category" items="${pcList}" varStatus="status">
		<c:if test="${status.count eq pcId}">
			<button name="pcId" value="${status.count}"
			class="btn btn-green rounded-pill my-1 btn-block active">${category}</button>
		</c:if>
		<c:if test="${status.count ne pcId}">
			<button name="pcId" value="${status.count}"
				class="btn btn-green rounded-pill my-1 btn-block">${category}</button>
		</c:if>
	</c:forEach>
</form>