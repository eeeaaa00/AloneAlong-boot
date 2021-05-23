<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
b {color:#29A65F;}
.card:hover, .card:focus {  filter: brightness(90%); }
.card-body>p {color:#29A65F; margin-top:-5px;}
.card { width:270px; height: 270px;}
.overlay{ position: absolute; bottom: 0; left: 0; right: 0; top:0;}
.card-body>div>a{ z-index:1;}
.sold-out { background-color:gray; color:#FFFFFF; width:50px; padding: 2px 15px 2px 15px;}
</style>

<div class="row my-5 mx-5">
					<div class="col-md-12" height="100%;">
				      <div class="shadow-sm rounded-lg">
				        <!-- Tabs-->
				        <ul class="nav nav-tabs nav-fill" role="tablist">
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4 active" href="<c:url value='/eating/'/> ${restaurant.resId}">메뉴</a></li>
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" href="<c:url value='/eating/${restaurant.resId}/RestaurantReview' />">한줄평</a></li> <!-- mav.setViewName("/eating/RestaurantReview");로 연결 -->
				          <li class="nav-item"><a class="nav-link py-4 px-sm-4" >같밥 모집ing</a></li>
				        </ul>
				        <!-- General info tab-->
				        <div class="tab-content px-lg-3 py-5">
				        <div class="info-content px-4 pt-lg-3 pb-3 mb-5 border">
				        <button type = "button" onClick="location.href='<c:url value='/eating/${restaurant.resId}/adminFood' />'">메뉴 추가</button> <!-- 여기 r2라고 해놨으니 바꿔야해 -->
				        
				        <c:forEach var="food" items="${foodList}">     
							<div class="shadow-sm m-2">
				            <div class="row no-gutters">
				              <div class="col-4">
				                <img src="https://img-cf.kurly.com/shop/data/goods/1575003713758y0.jpg" width="100%" height="150px" />
				              </div>
				                <div class="card-body">
					                <div class="d-flex justify-content-between align-items-start py-2" >
									<h6 class="card-text text-left">${food.name}</h6>
									</div>
									<p>설명</p>
									<p>${food.price}원 </p>  
				              </div>
				              <div class="card-footer">
					            <button type = "button" onClick="location.href='<c:url value='/eating/${restaurant.resId}/addFoodToCart'><c:param name="foodId" value="${food.foodId}"/></c:url>'">담기</button></br> 
					       		  <!--<button type="submit">담기</button></br>	 -->  
					              <button type="button" >수정</button>
					              <button>삭제</button>
				              </div>
				              
				            </div>
				          </div>
						<!-- <li><a href="<c:url value='/eating/' />${res.resId}">${res.resName}</a></li> -->
					</c:forEach>
				          
						</div>
					</div>
				          
				            
				       </div>
				   </div>
				</div>