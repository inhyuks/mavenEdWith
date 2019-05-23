<%@page import="com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
<h2>Hello World!</h2>
<c:forEach items="${item}" var="item">
<c:set var="member" scope="request" value="${item.name }"/>
${member } <br>
</c:forEach>
</body>
</html>
