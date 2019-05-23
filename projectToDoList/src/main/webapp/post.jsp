<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center">할일 등록</h1>
	<div align = "center" style ="padding-left : 10px">
		
		<form action="/TodoSet" method="POST">
		<div style = " margin-top : 20px;">
			어떤일인가요?<br>
			<input type="text" name="title" placeholder="swift 공부하기(24자까지)" >
		</div>
		<div style = " margin-top : 20px;">
			누가 할일인가요?<br>
			<input type="text" name="name" placeholder="홍길동" >
		</div>
		<div style = " margin-top : 20px;">
			우선순위를 선택하세요<br>
			<input type="radio" name = "sequence" value ="1">1순위 
			<input type="radio" name = "sequence" value ="2">2순위 
			<input type="radio" name = "sequence" value ="3">3순위
		</div>
		<div style = " margin-top : 20px;">
			<button>이전</button>
			<input type="submit" value="제출">
			<button>내용지우기</button>
		</div>
		</form>
	</div>
</body>
</html>