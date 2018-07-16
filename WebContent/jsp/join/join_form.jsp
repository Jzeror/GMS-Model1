<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
memId, ssn, name, roll, teamId, password;
 -->
 
 <!doctype html>
 <html lang="en">
 <head>
 	<meta charset="UTF-8" />
 	<title>회원가입화면</title>
 </head>
 <body>
 	<form action="join_result.jsp">
 		아이디 : <input type="text" name="memid"/><br>
 		이름 : <input type="text" name="name" /><br>
 		비밀번호 : <input type="password" name="password" /><br>
 		주민등록번호(ex.940501-2) : <input type="text" name="ssn" />
 		<input type="submit" />
 	</form>
 </body>
 </html>