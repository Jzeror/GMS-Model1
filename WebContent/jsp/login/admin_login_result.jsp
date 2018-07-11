<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="service.*"%>
<%@ page import="domain.*"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<%
		
		MemberBean m = new MemberBean();
		m.setMemId(request.getParameter("adminid"));
		m.setPassword(request.getParameter("adminpass"));
		m = MemberServiceImpl.getInstance().login(m);
	if(m.getName()==null){
	%>안됨<%
	}else{
		%> 
			회원이름 : <%= m.getName()%> <br />
			회원아이디 : <%= m.getMemId() %>
		<%
	}
	%>
	

</body>
</html>