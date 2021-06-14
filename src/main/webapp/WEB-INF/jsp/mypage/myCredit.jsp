<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<form>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">카드 이름</label>
			<div class="col-8">
				<select id="select" name="select" class="custom-select">
					<option value="NH">농협</option>
					<option value="KM">국민</option>
					<option value="SH">신한</option>
					<option value="WE">우리</option>
					<option value="IBK">기업</option>
					<option value="SC">SC제일</option>
					<option value="KK">카카오뱅크</option>
					<option value="NT">새마을금고</option>

				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="username" class="col-4 col-form-label">카드 번호</label>
			<div class="col-8">
				<input id="nickname" name="nickname" placeholder="카드 번호"
					class="form-control here" required="required" type="text">
			</div>
		</div>
		<div class="form-group row">
			<label for="lastname" class="col-4 col-form-label">카드 유효기간</label>
			<div class="col-8">
				<div class="row">
					<div class="col-xs-4 col-md-4">
						<input id="year" name="year" placeholder="년"
							class="form-control here" required="required" type="text">
					</div>
					<div class="col-xs-4 col-md-4">
						<input id="month" name="month" placeholder="월"
							class="form-control here" required="required" type="text">
					</div>
					<div class="col-xs-4 col-md-4">
						<input id="day" name="day" placeholder="일"
							class="form-control here" required="required" type="text">
					</div>
				</div>


			</div>
		</div>
		<div class="form-group row">
			<div class="offset-4 col-8">
				<button name="submit" type="submit"
					class="btn btn-success btn-lg active">카드 등록</button>
			</div>
		</div>
	</form>
</div>