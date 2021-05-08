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

    <title>함께 먹기</title>
  </head>
  <body>
    <!-- header -->
    <%@include file="../header.jsp" %>
   
   
   <div class="container">
        
        <div class="container mt-4">
		<div class="row">
			<!-- 검색 필터 -->
			<div class="col-md-2">

        <div class="row-md-2">
          <select class="form-select" aria-label="area">
            <option selected>모든 지역</option>
            <option value="1">경기</option>
            <option value="2">서울</option>
            <option value="3">부산</option>
            <option value="4">경남</option>
            <option value="5">인천</option>
            <option value="6">경북</option>
            <option value="7">대구</option>
            <option value="8">충남</option>
            <option value="9">전남</option>
            <option value="10">전북</option>
            <option value="11">충북</option>
            <option value="12">강원</option>
            <option value="13">대전</option>
            <option value="14">광주</option>
            <option value="15">울산</option>
            <option value="16">제주</option>
            <option value="17">세종</option>
          </select>
          </p>
          <select class="form-select" aria-label="date">
            <option selected>모든 날짜</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
          </p>
          <select class="form-select" aria-label="kind">
            <option selected>모든 음식종류</option>
            <option value="1">한식</option>
            <option value="2">양식</option>
            <option value="3">일식</option>
            <option value="4">중식</option>
            <option value="5">기타</option>
          </select>
          </p>
          <select class="form-select" aria-label="price">
            <option selected>모든 가격대</option>
            <option value="1">0~10000원</option>
            <option value="2">10000~15000원</option>
            <option value="3">15000~20000원</option>
            <option value="4">20000~25000원</option>
            <option value="5">25000원~</option>
          </select>
          </p>
          <select class="form-select" aria-label="sex">
            <option selected>모든 성별</option>
            <option value="1">여성</option>
            <option value="2">남성</option>
          </select>
          </p>
          <select class="form-select" aria-label="age">
            <option selected>모든 나이</option>
            <option value="1">10대</option>
            <option value="2">20대</option>
            <option value="3">30대</option>
            <option value="4">40대</option>
            <option value="5">50대이상</option>
          </select>

        </div>


      </div>

		<!-- 본 내용 -->
		<div class="col-md-10 my-1">
        <div class="py-3 text-center">
          <p>같이 먹기 제안하기 <a class="btn btn-primary" href="<c:url value='/together/togetherRegister' />" role="button">등록</a></p>
        </div>

        <!-- 같이밥목록 -->
        <div class="row mb-2">
          <div class="col-md-6">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" type="button" onClick="location.href='<c:url value='/together/111' />'">
              <div class="col p-4 d-flex flex-column position-static">
                <div class="row-md-6">
                  <span class="badge rounded-pill bg-primary">#서울</span>
                  <span class="badge rounded-pill bg-primary">#한식</span>
                  <span class="badge rounded-pill bg-primary">#여성</span>
                  <span class="badge rounded-pill bg-primary">#20대</span>
                </div >
                <h3 class="mb-0">삼겹살 같이 먹어요<strong class="d-inline-block mb-2 text-primary">(1/2)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ식당</p>
                <p class="card-text mb-auto">메뉴 : 삼겹살, 물냉면, 공기밥</p>
                <p class="card-text mb-auto">1인 16500원</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
              <div class="col p-4 d-flex flex-column position-static">
                <div class="row-md-6">
                  <span class="badge rounded-pill bg-primary">#서울</span>
                  <span class="badge rounded-pill bg-primary">#한식</span>
                  <span class="badge rounded-pill bg-primary">#남성</span>
                  <span class="badge rounded-pill bg-primary">#30대</span>
                </div>
                <h3 class="mb-0">소주에 곱창 드실 분<strong class="d-inline-block mb-2 text-primary">(1/2)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ곱창</p>
                <p class="card-text mb-auto">메뉴 : 곱창, 볶음밥, 소주</p>
                <p class="card-text mb-auto">1인 22200원</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
              <div class="col p-4 d-flex flex-column position-static">
                <div class="row-md-6">
                  <span class="badge rounded-pill bg-primary">#경기</span>
                  <span class="badge rounded-pill bg-primary">#양식</span>
                </div>
                <h3 class="mb-0">치맥해요<strong class="d-inline-block mb-2 text-primary">(1/4)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ치킨</p>
                <p class="card-text mb-auto">메뉴 : 후라이드치킨, 마늘치킨, 생맥주</p>
                <p class="card-text mb-auto">1인 15000원</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
              <div class="col p-4 d-flex flex-column position-static">
                <div class="row-md-6">
                  <span class="badge rounded-pill bg-primary">#부산</span>
                  <span class="badge rounded-pill bg-primary">#한식</span>
                </div>
                <h3 class="mb-0">비오는 날엔 파전에 막걸리<strong class="d-inline-block mb-2 text-primary">(1/3)</strong></h3>
                <div class="mb-1 text-muted">2020년 4월 5 / 오후 7시</div>
                <p class="card-text mb-auto">ㅇㅇ주막</p>
                <p class="card-text mb-auto">메뉴 : 해물파전, 모둠전, 막걸리</p>
                <p class="card-text mb-auto">1인 15000원</p>
              </div>
            </div>
          </div>
			</div>
		</div>
		</div>
    	</div>
    </div>
   
    <!-- Footer -->
    <%@include file="../footer.jsp" %>
  </body>
</html>