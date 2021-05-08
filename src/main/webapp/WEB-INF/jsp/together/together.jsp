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

    <title>함께 먹기 상세</title>
  </head>
  <body>
    <!-- header -->
    <%@include file="../header.jsp" %>
   
   	<div class="container">
      <main>
        <div class="py-5 text-center">
          <h4>삽겹살 같이 먹어요<strong class="d-inline-block mb-2 text-primary">(1/2)</strong></h4>
          <!-- 테그 -->
          <div class="row-md-6">
            <span class="badge rounded-pill bg-primary">#서울</span>
            <span class="badge rounded-pill bg-primary">#한식</span>
            <span class="badge rounded-pill bg-primary">#여성</span>
            <span class="badge rounded-pill bg-primary">#20대</span>
          </div>
          <p>말없이 고기만 먹어도 괜찮아요~</p>

          <!-- 사진 -->
          <div class="row-md-6">
						<svg class="img" style="background-image: url('https://post-phinf.pstatic.net/MjAyMDAzMDNfMTcg/MDAxNTgzMTkwNjA3ODQ5.kUXPHqGJ2xPDSu_3FiEoFC3kY9QyQ_g9CziCGrFSDuEg.LpCfOTbc5qth9d-GKzGv9jwj2VKhcqmPHp5cp1KJYEsg.JPEG/IM_food02.jpg?type=w1200');
								background-size: cover; background-position:center; width:100%; height:200px;"></svg>
					</div>
        </div>

        <div class="row g-5">
          <!-- 상세정보 -->
          <div class="col-md-7">
            <h5 class="mb-3"><span class="text-primary">날짜 및 시간</span></h5>
            <p>2021년 4월 5일 / 오후 7시</p>
            <h5 class="mb-3"><span class="text-primary">주최자</span></h5>
            <p>고기좋아 님</p>
            <h5 class="mb-3"><span class="text-primary">멤버</span></h5>
            <p>아직없음</p>
            <h5 class="mb-3"><span class="text-primary">조건</span></h5>
            <p>여성 / 20대</p>
          </div>

          <!-- 식당 및 메뉴 정보 -->
          <div class="col-md-7 col-lg-5 order-md-last">
            <!-- 식당 정보 -->
            <h5 class="d-flex justify-content-between align-items-center mb-3">
              <span class="text-primary">식당</span>
            </h5>
            <p>ㅇㅇ고기</p>
            <p>서울특별시 ㅇㅇ구 ㅇㅇ동 ㅇㅇ로</p>

            <!-- 메뉴 정보 -->
            <h5 class="d-flex justify-content-between align-items-center mb-3">
              <span class="text-primary">메뉴</span>
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

        <!-- 신청하기 -->
        <div class="py-5 text-right">
          <button class="w-40 btn btn-primary btn-lg" type="submit" onClick="location.href='<c:url value='/together/togetherPay' />'">신청하기</button>
        </div>

      </main>
    </div>  
   
    <!-- Footer -->
    <%@include file="../footer.jsp" %>
  </body>
</html>