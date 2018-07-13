<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>joinresult</title>
</head>
<body>
	<%
	
	MemberBean mm=new MemberBean();
	mm.setMemId(request.getParameter("memid"));
	mm.setName(request.getParameter("name"));
	mm.setPassword(request.getParameter("password"));
	mm.setSsn(request.getParameter("ssn"));
	if(MemberServiceImpl.getInstance().showOneList(mm))
	{ %>
	
	가입되셨습니다
	<form action="../login/admin_login_form.jsp">
	<input type="submit" value ="로그인하러 가기"/>
	</form>
	
	
	<% }else{ %>중복된 아이디<%} %>
	
</body>
</html>