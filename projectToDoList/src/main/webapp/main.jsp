<%@page
	import="com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="style.css" />
<body>
	<div id="container">
		<div align="right">
			<button onclick = "location.href = '/webapiexam/TodoPost'">새로운 TODO 등록</button>
		</div>
	</div>
	
	<div style="float: left; margin: 5px; width: 25%;">
		TODO
		<c:forEach items="${item}" var="item">
			<div style="float: left; margin: 5px 0px 5px;">
				<c:if test="${item.type eq 'TODO'}">
					${item.title } <br>
					등록날짜 : ${item.regdate }${name },우선순위1<br>
					<button onclick = "location.href = '/webapiexam/TodoPut?id=${item.id}&type=${item.type}'">-></button>
				</c:if>
			</div>
		</c:forEach>
	</div>
	
	<div style="float: left; margin: 5px; width: 25%;">
		DOING
		<c:forEach items="${item}" var="item">
			<div style="float: left; margin: 5px 0px 5px;">
				<c:if test="${item.type eq 'DOING'}">
					${item.title } <br>
					등록날짜 : ${item.regdate }${name },우선순위1<br>
					<button onclick = "location.href = '/webapiexam/TodoPut?id=${item.id}&type=${item.type}'">-></button>
				</c:if>
			</div>
		</c:forEach>
	</div>
	
	<div style="float: left; margin: 5px; width: 25%;">
		DONE
		<c:forEach items="${item}" var="item">
			<div style="float: left; margin: 5px 0px 5px;">
				<c:if test="${item.type eq 'DONE'}">
					${item.title } <br>
					등록날짜 : ${item.regdate }${name },우선순위1<br>
				</c:if>
			</div>
		</c:forEach>
	</div>
</body>
</html>
