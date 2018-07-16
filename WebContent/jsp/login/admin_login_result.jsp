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
		
	if(MemberServiceImpl.getInstance().login(m).getAge()!="999"){
	%>
	성공
		</form>
		<form action="../../main.jsp">
	<input type="submit" value ="메인으로 가기"/>
	</form>
	<%
	}else{
	%> 
	실패
		</form>
		<form action="../../main.jsp">
	<input type="submit" value ="메인으로 가기"/>
	</form>
		<%
	}
	%>
	

</body>
</html>