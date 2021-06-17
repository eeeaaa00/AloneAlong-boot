<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script languae="javaScript">
$(document).ready(function() {
	<c:if test="${param.stockError == true}">
		$("#alertModal").modal("show");
	</c:if>
});
</script>
<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content pb-4">
			<div class="modal-header">
				<h5 class="modal-title">Error</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-center">현재 <span class="text-green">${product.productName}</span>의 재고수량은
				<span class="text-orange">${product.productStock}</span>개 입니다.</div>
		</div>
	</div>
</div>