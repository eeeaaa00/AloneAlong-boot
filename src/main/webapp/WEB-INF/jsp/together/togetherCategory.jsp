<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 검색 필터 -->
<div class="col-md-2">
	<div class="row-md-2">
    	<select id="area" name="area" class="custom-select">
        	<option selected>모든 지역</option>
            <option value="seoul">서울특별시</option>
            <option value="busan">부산광역시</option>
            <option value="incheon">인천광역시</option>
            <option value="deagu">대구광역시</option>
            <option value="deageon">대전광역시</option>
            <option value="guangju">광주광역시</option>
            <option value="ulsan">울산광역시</option>
		</select>

		<input type="date" id="date" name="date" min="2021-05-01">

        <select id="kind" name="kind" class="custom-select">
            <option selected>모든 음식종류</option>
            <option value="korean">한식</option>
            <option value="western">양식</option>
            <option value="japanese">일식</option>
            <option value="chinese">중식</option>
            <option value="etc">기타</option>
        </select>

        <select id="price" name="price" class="custom-select">
            <option selected>모든 가격대</option>
            <option value="10000">1~10000원</option>
            <option value="15000">10001~15000원</option>
            <option value="20000">15001~20000원</option>
            <option value="25000">20001~25000원</option>
            <option value="30000">25001원~</option>
        </select>

        <select id="sex" name="sex" class="custom-select">
            <option selected>모든 성별</option>
            <option value="female">여성</option>
            <option value="male">남성</option>
        </select>

        <select id="age" name="age" class="custom-select">
            <option selected>모든 나이</option>
            <option value="10">10대</option>
            <option value="20">20대</option>
            <option value="30">30대</option>
            <option value="40">40대</option>
            <option value="50">50대이상</option>
        </select>
	</div>
</div>