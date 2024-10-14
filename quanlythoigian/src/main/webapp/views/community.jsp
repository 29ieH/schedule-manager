<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session = request.getSession(false);
	String userName = (String)session.getAttribute("userName");
	if(session!=null&&userName!=null){
%>
<body>
	<body  style="background-color: black;">
		<div class="web">
			<div class="width-1280">
			</div>
		</div>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>