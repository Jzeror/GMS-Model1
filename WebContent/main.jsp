<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%!
 int a= 4,b=5,c=0;
%>
<% 
	c = a + b;
	
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>main</title>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<%= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())%>
	<table id="main-tab-layout" class="margin-auto">
		<tr class="height-140">
			<td colspan="2"><img src="img/home/head.png"
				style="height: 135px; width: 100%" alt="" /></td>
		</tr>
		<tr id="main-tab-layout-tr">
			<td id="main-tab-layout-td" align="center"><img
				src="img/home/htm_20150216175457142.jpg" alt="" /></td>
			<td align="center">
				<ul>
					<li><a href="jsp/login/user_login.jsp">사용자로그인</a></li>
					<li><a href="jsp/login/admin_login_form.jsp">관리자로그인</a></li>
			<li><%=c %></li>
				</ul>
			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
