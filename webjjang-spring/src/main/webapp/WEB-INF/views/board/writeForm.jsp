<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>board :: 일반게시판 글등록</title>
	</head>
<body>
	<div class="container">
		<h2>일반게시판 글등록</h2>
		<form action="write.do" method="post">
			<div class="form-group">
				<label for="title">제목</label>
				<input class="form-control" name="title" id="title" required="required">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" name="content" id="content"  required="required" rows="7"></textarea>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input class="form-control" name="writer" id="writer"  required="required">
			</div>
			<div class="form-group">
				<label for="pw">비밀번호</label>
				<input type="password" class="form-control"  name="pw" id="pw" required="required">
			</div>
			<div class="form-group">
				<label for="pw2">비밀번호 확인</label>
				<input type="password" class="form-control"  name="pw2" id="pw2" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">글등록</button>
				<button type="reset" class="btn btn-warning">새로입력</button>
				<button type="button" class="btn btn-success cancelBtn">취소</button>
			</div>
		</form>
	</div>
</body>
</html>