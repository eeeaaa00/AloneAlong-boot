<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- for Icon -->
<script src="https://kit.fontawesome.com/cfb4151af4.js"></script>
<!-- 구글폰트링크 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&family=Roboto&display=swap" rel="stylesheet">
<title>togetherRegister</title>
</head>
<body>
<!-- header -->
<%@include file="../header.jsp" %>
   
<div class="container my-5 pb-5">
	<div class="py-5 text-center">
	<h4>같이 먹기 등록</h4>
    <p>주최자가 되어 같이 밥을 먹어보세요!</p>
</div>

<!-- 본문 시작 -->
<div class="row g-5">
	<!-- 글 작성하기 -->
	<div class="col-md-6 col-lg-7">
		<h5 class="mb-3"><span class="text-primary">상세 정보 작성</span></h5>
		<form class="needs-validation" novalidate>
			<div class="row g-3">
				<div class="col-10">
                	<label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" id="address" placeholder="삼겹살 같이 먹어요~" required>
                    <div class="invalid-feedback">제목을 입력해주세요.</div>
                </div>
                <div class="col-10">
                    <label for="headCount" class="form-label">인원</label>
                    <input type="number" class="form-control" id="headCount" placeholder="2" required>
                    <div class="invalid-feedback">인원수를 입력해주세요.</div>
                </div>
                <div class="col-md-5">
                    <label for="sex" class="form-label">성별</label>
                    <select id="age" name="age" class="custom-select">
                    	<option value="none">상관없음</option>
                      	<option value="female">여성만</option>
                      	<option value="male">남성만</option>
                    </select>
                    <div class="invalid-feedback">성별을 조건을 설정해주세요.</div>
                </div>
                <div class="col-md-5">
                    <label for="age" class="form-label">나이대</label>
                    <select id="age" name="age" class="custom-select">
                    	<option value="none">상관없음</option>
                      	<option value="10s">10대</option>
                      	<option value="20s">20대</option>
                      	<option value="30s">30대 </option>
                      	<option value="40s">40대</option>
                      	<option value="50s">50대이상</option>
                    </select>
                    <div class="invalid-feedback">나이대 조건을 설정해주세요.</div>
                </div>
                <div class="col-sm-5">
                    <label for="date" class="form-label">날짜</label>
                    <input type="date" class="form-control" id="date" placeholder="" value="" required>
                    <div class="invalid-feedback">날짜를 입력하세요.</div>
                </div>
                <div class="col-sm-5">
                    <label for="time" class="form-label">시간</label>
                    <input type="time" class="form-control" id="time" placeholder="" value="" required>
                    <div class="invalid-feedback">시간을 입력하세요.</div>
                </div>
                <div class="col-10">
                    <label for="description" class="form-label">주최자의 말<span class="text-muted">(옵션)</span></label>
                    <input type="text" class="form-control" id="description" placeholder="말없이 고기만 먹어도 괜찮아요~">
                </div>
			</div>
		</form>
	</div>

    <!-- 식당 선택 -->
    <div class="col-md-5 col-lg-5 order-md-last">
    	<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-primary">식당 선택</span></h5>
        	<div class="col-sm-12">
            	<input type="text" class="form-control" id="name" placeholder="ㅇㅇ고기" value="" required>
            	<div class="invalid-feedback">식당을 입력하세요.</div>
            </div>
	<!-- 메뉴 선택 -->
	<h5 class="d-flex justify-content-between align-items-center mb-3"><span class="text-primary">메뉴 선택</span>
    	<button type="button" class="btn btn-outline-primary">추가</button>
        <span class="badge bg-primary rounded-pill">3</span>
	</h5>
	<ul class="list-group mb-3">
		<li class="list-group-item d-flex justify-content-between lh-sm">
			<div>
				<h6 class="my-0">삽겹살 2인분</h6>
                <small class="text-muted">13000원 * 2인분</small>
            </div>
            <span class="text-muted">26000원</span>
		</li>
        <li class="list-group-item d-flex justify-content-between lh-sm">
        	<div>
        		<h6 class="my-0">물냉면 1개</h6>
                <small class="text-muted">5000원 * 1개</small>
            </div>
            <span class="text-muted">5000원</span>
		</li>
        <li class="list-group-item d-flex justify-content-between lh-sm">
        	<div>
				<h6 class="my-0">공기밥 2개</h6>
                <small class="text-muted">1000원 * 2개</small>
            </div>
            <span class="text-muted">2000원</span>
		</li>
		<li class="list-group-item d-flex justify-content-between bg-light">
			<strong><span>합계</span></strong>
            <strong>33000원</strong>
        </li>
		<li class="list-group-item d-flex justify-content-between bg-light">
			<div class="text-success">
            	<h6 class="my-0">1인</h6>
			</div>
        	<span class="text-success"><strong>16500원</strong></span>
		</li>
	</ul>
	</div>
</div>

<!--버튼 -->
<div class="py-5 text-right">
	<button class="w-40 btn btn-primary btn-lg" type="submit">등록하기</button>
</div>

<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="form-validation.js"></script>
		
</div>
   
<!-- Footer -->
<%@include file="../footer.jsp" %>
</body>
</html>