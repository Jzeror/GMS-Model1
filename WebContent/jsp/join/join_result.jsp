<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>joinresult</title>
</head>
<body>
	<%! String memid,name,password =""; %>>
	<%
	MemberBean mm=new MemberBean();
	mm.setMemId(request.getParameter("memid"));
	mm.setName(request.getParameter("name"));
	mm.setPassword(request.getParameter("password"));
	if(MemberServiceImpl.getInstance().showOneList(mm))
	{%>성공<%}else{ %>중복된 아이디<%} %>
	
</body>
</html>