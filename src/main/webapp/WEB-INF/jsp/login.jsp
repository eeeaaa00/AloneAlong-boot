<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- for Icon -->
<script src="https://kit.fontawesome.com/cfb4151af4.js"></script>
<!-- 구글폰트링크 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serilogin.jspf+KR:wght@300&family=Roboto&display=swap"
	rel="stylesheet">

<title>로그인</title>
<style>
body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
	}
</style>
</head>

 <body>

	<!-- header -->
	<%@include file="header.jsp"%>
	<br><br>
    <div class="row d-flex justify-content-center align-items-center h-100">
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

	
  </body>

	<!-- Footer -->
	<%@include file="footer.jsp"%>
</body>
</html>