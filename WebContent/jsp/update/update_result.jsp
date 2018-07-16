<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>update_result</title>
</head>
<body>
	<%
	MemberBean member= new MemberBean();
	member.setMemId(request.getParameter("id"));
	member.setPassword(request.getParameter("oldpass")+"/"+request.getParameter("newpass"));
	MemberServiceImpl.getInstance().modifyMember(member);
	%>
		</form>
		<form action="../../main.jsp">
	<input type="submit" value ="메인으로 가기"/>
	</form>
</body>
</html>