<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>board :: 일반게시판 글등록</title>
	</head>
<body>
	<h2>일반게시판 글등록</h2>
	<form action="write.do" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input name="title" >
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input name="writer" >
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" >
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="pw2" >
				</td>
			</tr>
			<tr>
				
				<td colspan="2">
					<button>글등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>