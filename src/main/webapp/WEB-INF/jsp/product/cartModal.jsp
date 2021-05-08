<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script languae="javaScript">
$(document).ready(function() {
	<c:if test="${insertCart == true}">
		$("#cartModal").modal("show");
	</c:if>
});
</script>

<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content py-5">
			<div class="modal-body text-center pb-4">
				<h6>상품이 장바구니에 담겼습니다.</h6>
				<h6>장바구니로 이동하시겠습니까?</h6>
			</div>
			<div class="row mx-5 mb-2 justify-content-center">
				<a type="button" class="btn btn-green rounded-pill mx-2 py-2 px-3" href="<c:url value='/shop/${productId}' />">쇼핑 계속하기</a>
				<a type="button" class="btn btn-orange rounded-pill mx-2 py-2 px-3" href="<c:url value='/shopping/cart' />" >장바구니 보기</a>
			</div>
		</div>
	</div>
</div>