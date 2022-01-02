<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="container">
		<h2 class="writeTitle">할일 등록</h2>
		<form action="./TodoAddServlet" method="post">
			<div class="form-group">
				<label for="title">어떤일인가요?</label>
				<input style="width:285px" type="text" name="title" id="title" placeholder="swift 공부하기(24자까지)" maxlength='24' required />
			</div>
			<div class="form-group">
				<label for="name">누가 할일인가요?</label>
				<input type="text" name="name" id="name" placeholder="홍길동" required/>
			</div>
			<div class="form-group">
				<label for="sequence">우선순위를 선택하세요</label>
				<input type="radio" name="sequence" id="sequence" value="1"/> 1순위
				<input type="radio" name="sequence" id="sequence" value="2"/> 2순위
				<input type="radio" name="sequence" id="sequence" value="3"/> 3순위
			</div>
			<div class="btn-group">
				<button class="previous" onclick="location.href='./MainServlet'">< 이전</button>
				<button type="reset" class="float-right">내용지우기</button>
				<button type="submit" class="float-right">제출</button>
			</div>
		</form>
	</div>
</body>
</html>