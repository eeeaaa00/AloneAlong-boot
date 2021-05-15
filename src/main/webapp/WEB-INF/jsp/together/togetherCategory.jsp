<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 검색 필터 -->
<div class="col-md-2">
	<div class="row-md-2">
    	<select id="area" name="area" class="custom-select">
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

		<input type="date" /> <!-- 크롬에서는 보임 -->

        <select id="kind" name="kind" class="custom-select">
            <option selected>모든 음식종류</option>
            <option value="1">한식</option>
            <option value="2">양식</option>
            <option value="3">일식</option>
            <option value="4">중식</option>
            <option value="5">기타</option>
        </select>

        <select id="price" name="price" class="custom-select">
            <option selected>모든 가격대</option>
            <option value="1">0~10000원</option>
            <option value="2">10000~15000원</option>
            <option value="3">15000~20000원</option>
            <option value="4">20000~25000원</option>
            <option value="5">25000원~</option>
        </select>

        <select id="sex" name="sex" class="custom-select">
            <option selected>모든 성별</option>
            <option value="1">여성</option>
            <option value="2">남성</option>
        </select>

        <select id="age" name="age" class="custom-select">
            <option selected>모든 나이</option>
            <option value="1">10대</option>
            <option value="2">20대</option>
            <option value="3">30대</option>
            <option value="4">40대</option>
            <option value="5">50대이상</option>
        </select>
	</div>
</div>