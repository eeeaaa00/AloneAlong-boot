<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row d-flex justify-content-center align-items-center">
	<div class="card align-middle"
		style="width: 20rem; border-radius: 20px;">
		<div class="card-body">

			<div class="card-title" style="margin-top: 30px;">
				<h2 class="card-title text-center" style="color: #113366;">로그인
					완료</h2>
				<h5 class="card-title text-center" style="color: #113366;">${userSession.user.name}님,
					환영합니다!</h5>
				<br>
			</div>

			<br>
		</div>
	</div>
</div>
</html>