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

    <title>함께 먹기 결제</title>
  </head>
  <body>
    <!-- header -->
    <%@include file="../header.jsp" %>

    <div class="container">
        <div class="py-5">
          <h4>신청확인<strong class="d-inline-block mb-2 text-primary"></strong></h4>
        </div>

        <div class="row g-5">
          <!-- 상세정보 -->
          <div class="col-md-7">
            <h5 class="mb-3"><span class="text-primary">날짜 및 시간</span></h5>
            <p>2021년 4월 5일 / 오후 7시</p>
            <!-- 식당 정보 -->
            <h5 class="d-flex justify-content-between align-items-center mb-3">
              <span class="text-primary">식당</span>
            </h5>
            <p>ㅇㅇ고기</p>
            <p>서울특별시 ㅇㅇ구 ㅇㅇ동 ㅇㅇ로</p>
          </div>

          <!-- 메뉴 정보 -->
          <div class="col-md-7 col-lg-5 order-md-last">

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

        <hr class="my-4">

        <!-- 결제하기 -->
        <h4 class="mb-3">결제하기</h4>

          <div class="my-3">
            <div class="form-check">
              <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked required>
              <label class="form-check-label" for="credit">Credit card</label>
            </div>
            <div class="form-check">
              <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required>
              <label class="form-check-label" for="debit">Debit card</label>
            </div>
            <div class="form-check">
              <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
              <label class="form-check-label" for="paypal">PayPal</label>
            </div>
          </div>

          <div class="row gy-3">
            <div class="col-md-6">
              <label for="cc-name" class="form-label">Name on card</label>
              <input type="text" class="form-control" id="cc-name" placeholder="" required>
              <small class="text-muted">Full name as displayed on card</small>
              <div class="invalid-feedback">
                Name on card is required
              </div>
            </div>

            <div class="col-md-6">
              <label for="cc-number" class="form-label">Credit card number</label>
              <input type="text" class="form-control" id="cc-number" placeholder="" required>
              <div class="invalid-feedback">
                Credit card number is required
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-expiration" class="form-label">Expiration</label>
              <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
              <div class="invalid-feedback">
                Expiration date required
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-cvv" class="form-label">CVV</label>
              <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
              <div class="invalid-feedback">
                Security code required
              </div>
            </div>
          </div>

        <!-- 결제버튼 -->
        <div class="py-5 text-right">
          <button class="w-40 btn btn-primary btn-lg" type="submit">결제하기</button>
        </div>
    </div>
   
    <!-- Footer -->
    <%@include file="../footer.jsp" %>
  </body>
</html>