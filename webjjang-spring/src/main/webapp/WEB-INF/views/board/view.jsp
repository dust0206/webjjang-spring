<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Board :: 일반 게시판 글보기</title>
	<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<style>
</style>	
<script>
	$(function(){
		
		// 이벤트 처리
		// 글보기 이동 처리
		$(".dataRow").click(function() {
			let no = $(this).data("no");
// 			location = "view.do?no=" + no
			// alert(no)
			location = "view.do?no=" + no + "&inc=1"
		});
	});

</script>
	</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header"><h2>일반 게시판 글보기</h2></div>
		<div class="card-body">
				<div class="card dataRow" data-no="${vo.no }">
					<div class="card-header">
						<span class="float-right">조회수 : ${vo.hit }</span>
						<span class="float-left">[글번호] : ${vo.no }&nbsp;&nbsp;&nbsp; [글제목] : ${vo.title }</span>
					</div>
					<div class="card-body">
						<pre>${vo.content }</pre>
					</div>
					<div class="card-footer">
						<span class="float-right">
							<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/> 
						</span>
						[작성자] : ${vo.writer }
					</div>
				</div>
		</div>
		<div class="card-footer">
			<button class="btn btn-primary" id="updateBtn">수정</button>
			<!--  모달창을 열어서 비밀번호를 입력 받고 삭제하여 가는 처리 -->
			<button class="btn btn-danger" id="deleteBtn">글삭제</button>
			<button class="btn btn-warning cancelBtn" >취소</button>
		</div>
	</div>
	
	
	
</div>
</body>
</html>