<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<button class="btn" id="plusProduct">
		<span>더보기</span>
	</button>
</body>
<script>
	$('#plusProduct').on('click', function() {
		var form = {
			name : "",
		}
		$.ajax({
			url : "requestObject",
			type : "POST",
			data : form,
			success : function(data) {
				$('#result').text(data);
			},
			error : function() {
				alert("simpleWithObject err");
			}
		});
	});
</script>
</html>