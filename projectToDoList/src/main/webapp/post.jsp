<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center">���� ���</h1>
	<div align = "center" style ="padding-left : 10px">
		
		<form action="/TodoSet" method="POST">
		<div style = " margin-top : 20px;">
			����ΰ���?<br>
			<input type="text" name="title" placeholder="swift �����ϱ�(24�ڱ���)" >
		</div>
		<div style = " margin-top : 20px;">
			���� �����ΰ���?<br>
			<input type="text" name="name" placeholder="ȫ�浿" >
		</div>
		<div style = " margin-top : 20px;">
			�켱������ �����ϼ���<br>
			<input type="radio" name = "sequence" value ="1">1���� 
			<input type="radio" name = "sequence" value ="2">2���� 
			<input type="radio" name = "sequence" value ="3">3����
		</div>
		<div style = " margin-top : 20px;">
			<button>����</button>
			<input type="submit" value="����">
			<button>���������</button>
		</div>
		</form>
	</div>
</body>
</html>