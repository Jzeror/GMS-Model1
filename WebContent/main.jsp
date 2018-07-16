<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%!
 int a= 4,b=5,c=0;
int count =0;
%>
<% 
	c = a + b;
	count= MemberServiceImpl.getInstance().showCountList();
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
	<h3> 현재 회원 수 : </h3> <h3><%= count %></h3><br>
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
					<li><a href="jsp/login/user_login_form.jsp">사용자로그인 </a></li>
					<li><a href="jsp/login/admin_login_form.jsp">관리자로그인</a></li>
					<li><a href="jsp/join/join_form.jsp"> 사용자가입</a></li>
					<li><a href="jsp/update/update_form.jsp">비번바꾸기</a></li>
					<li><a href="jsp/delete/delete_form.jsp">계정삭제</a></li>
				</ul> 
			</td>
		</tr>
		<tr class="height-140">
			<td class="width-80pt" colspan="2"></td>
		</tr>
	</table>
</body>
</html>
