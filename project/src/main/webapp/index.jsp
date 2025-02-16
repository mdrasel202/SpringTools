<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{width: 100%; text-align: center; margin-top: 100px;}
	h2{font-size: 30px; letter-spacing: 1px; font-weight: 400;}
	.bt{text-decoration: none;color: #000;background: #2876e7;padding: 8px 10px;border-radius: 6px; margin: 0 5px;}
	.bt:hover{background:#7b86e1;}
	.bt1{text-decoration: none;color: #000;background: #17a50e;padding: 8px 10px;border-radius: 6px; margin: 0 5px;}
	.bt1:hover{background:#17ed5e; color:#fff;}
	.bt2{text-decoration: none;color: #000;background: #ffca33;padding: 8px 10px;border-radius: 6px; margin: 0 5px;}
	.bt2:hover{background:#eebf38;}
</style>
</head>
<body> 
        <h2>Welcome to the Student Management System</h2>
        <a href="student/addstudent.jsp" class="bt">Add student</a>
        <a href="student/listsudent.jsp" class="bt1">List All Students</a>
        <a href="student/updatestudent.jsp" class="bt2">Update Student</a>
</body>
</html>