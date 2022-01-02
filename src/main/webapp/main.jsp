<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="main-container">
		<header>
			<div class="headline">
				<span class="listTitle">나의 해야할 일들</span>
				<button class="btnTodo" onclick="location.href='./TodoFormServlet'">새로운 TODO 등록</button>
			</div>
		</header>
		<section class="wholeTable">
			<c:forEach var="type" items="${tableTypes }">
				<div id="${type }">
					<div class="tableHeader">${type}</div>
					<c:forEach var="list" items="${setTodo }">
						<c:if test="${list.type eq type }">
							<div class="card">
								<h1 class="card-title">${list.title}</h1>
								<p class="card-desc">등록날짜:${list.regdate }, ${list.name }, 우선순위${list.sequence }</p>
								<c:if test="${list.type ne 'DONE' }">
									<button class="arrowBtn" onclick="changeStatus(${list.id}, this)">-></button>
								</c:if>
							</div>
						</c:if>
					</c:forEach>				
				</div>
			</c:forEach>
		</section>
	</div>
	<script src="js/script.js"></script>
</body>
</html>