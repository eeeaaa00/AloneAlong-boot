<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
<style type="text/css">
html {
	position: relative;
    min-height: 100%;
}
body {
    margin-bottom:200px;
}
.container{  
	position:relative;
    min-height:100%;
 }
footer {  
	width:100%;
	height:200px; 
	position:absolute; 
	bottom:0; 
}
p>a>i { color:gray; text-decoration: none;}
p>a>i:hover, p>a>i:focus { color:#29A65F; }

</style>
</head>
	<div class="modal fade" id="contactModal" tabindex="-1" role="dialog" aria-hidden="true">
	<form action='<c:url value="/contact"/>'>
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content pb-4">
				<div class="modal-header">
					<h5 class="modal-title">문의사항</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<textarea rows="8" name="contents" id="contents"
								placeholder="문의사항이 있으신 경우 의견을 보내주세요." required="" class="form-control"></textarea>
						</div>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-green rounded-pill w-25 pb-2">보내기</button>
				</div>
			</div>
		</div>
	</form>
</div>
	<footer class="py-5 bg-light">
      <div>
         <p class="contect text-dark text-center">
         	Contect &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;
         	<a class="mx-1" href="mailto:aloneAndAlong@gmail.com"><i class="far fa-envelope"></i></a>
         	<a class="mx-1" href="https://github.com/eeeaaa00/AloneAlong-boot"><i class="fab fa-github"></i></a>
         	<a class="mx-1" data-toggle="modal" data-target="#contactModal"><i class="far fa-comment-dots"></i></a>
         </p>
         <p class="text-dark m-0 text-center">2021 &copy; Alone & Along</p>
         <p class="text-dark text-center">DWU System Software Programming Project</p>
      </div>
   </footer>