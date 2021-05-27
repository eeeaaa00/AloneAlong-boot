<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <div class="row d-flex justify-content-center align-items-center">
	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-body">
      <form action='<c:url value="/loginTest"/>' class="form-signin" method="POST" onSubmit="logincall();return false">
      	<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">로그인</h2>
			<br>
		</div>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" name="id" class="form-control" placeholder="ID" required autofocus><BR>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pw" class="form-control" placeholder="Password" required><br>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 기억하기
          </label>
        </div>
        <br>
        <button id="btn-Yes" class="btn btn-success btn-block" type="submit">로 그 인</button>
         <button id="btn-Yes" class="btn btn-outline-success btn-block" type="submit">가 입</button>
      </form>
      
		</div>
	</div>
</div>
</html>