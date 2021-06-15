<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-12">
	<form:form modelAttribute="paymentForm" method="post">
		<div class="row w-100 mx-2 mb-3 no-gutters">
			<label for="cardname" class="col-4 col-form-label">카드 이름</label>
			<div class="col-8">
				<form:select class="custom-select" path="payment.card_name" items="${bank}"
					required="required" />
			</div>
		</div>
		<div class="row w-100 mx-2 mb-3 no-gutters">
			<label for="cardNum" class="col-4 col-form-label">카드 번호</label>
			<div class="col-8">
				<form:input type="text" class="form-control here"
					placeholder="카드 번호" path="payment.card_num"
					required="required" />
			</div>
		</div>
		<div class="row w-100 mx-2 mb-3 justify-content-between no-gutters">
			<label class="col-4 col-form-label">카드 정보</label>
			<div class="row col-8 no-gutters">
				<div class="col-6 input-group">
					<form:input type="text" class="form-control here"
					placeholder="유효기간 (MM/YY)" path="payment.card_date"
					required="required" />
				</div>
				<div class="col-1"></div>
				<div class="col-5">
					<form:input type="text" class="form-control here"
					placeholder="CVC" path="payment.card_cvc"
					required="required" />
				</div>
				<form:input type="hidden" class="form-control here"
					placeholder="CVC" path="payment.id"
					value="${userSession.user.id}" /> 
			</div>
		</div>

		<div class="form-group row">
			<div class="offset-4 col-8">
				<button name="submit" type="submit"
					class="btn btn-success btn-lg active">카드 등록</button>
			</div>
		</div>
	</form:form>
</div>