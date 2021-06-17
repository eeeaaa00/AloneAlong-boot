<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="container-fluid">
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<!-- 하나의 item입니다. data-parent 설청과 href 설정만 제대로 하면 문제없이 작동합니다. -->
			<div class="panel panel-default">
				<div class="panel-heading" role="tab">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse1" aria-expanded="false"> 
						아이템 이름
						 </a>
				</div>
				<div id="collapse1" class="panel-collapse collapse" role="tabpanel">
					<div class="panel-body">
						<div class="form-row float-right">
							<a href="<c:url value='/shopping/apple/review' />">
								<button class="btn btn-sm btn-outline-success"
									id="advanced-set-submit">리뷰 작성</button>
							</a>
						</div>
						<div class="d-flex align-items-center">
							<a href="/detail-1"> <svg class="img rounded-lg"
									style="background-image: url('https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg'); background-size: cover; background-position: center; width: 100px; height: 100px;"></svg>
							</a>
							<div class="cart-title text-left ml-3">
								<a class="text-uppercase text-dark" href="/detail-1"> <strong>유기농
										사과 3개입</strong></a> <br> <small style="color: #f2864b;">주문번호 </small>
								&nbsp; <small style="color: #696969;"> 2016546548</small> <Br>
								<small style="color: #f2864b;">주문수량 </small> &nbsp; <small
									style="color: #696969;"> 1개</small><br> <small
									style="color: #f2864b;">결제금액 </small> &nbsp;<small
									style="color: #696969;"> 8500원</small> <br> <small
									style="color: #f2864b;">주문상태 </small> &nbsp;<small
									style="color: #696969;"> 배송완료</small>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- -->
			<!-- 하나의 item입니다. -->
			<div class="panel panel-default">
				<div class="panel-heading" role="tab">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse2" aria-expanded="false"> Item #2 </a>
				</div>
				<div id="collapse2" class="panel-collapse collapse" role="tabpanel">
					<div class="panel-body">Hello world2</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse3" aria-expanded="false"> Item #3 </a>
				</div>
				<div id="collapse3" class="panel-collapse collapse" role="tabpanel">
					<div class="panel-body">Hello world3</div>
				</div>
			</div>
		</div>
	</div>
</div>