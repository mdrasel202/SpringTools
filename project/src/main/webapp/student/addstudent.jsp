<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body{text-align: center; margin-top:50px}
	label{width:110px; display: inline-block;}
	.bak{text-decoration: none;color: #fff;background: #2876e7;padding: 8px 14px;border-radius: 6px; margin: 0 5px;}
	.in{color: #fff;background: #2876e7;padding: 9px 14px;border-radius: 6px; margin: 0 5px; border: none;}
</style>
</head>
<body>
 		<form action="../student/StudentServlet" method="post">
                
                    <label for="">Name :</label>
                    <input type="text" name="name" required><br><br>
                
                    <label for="">Email :</label>
                    <input type="email" name="email" required><br><br>
                
                	<label>Phone Number :</label>
                	<input type="text" name="phone" required><br><br>
                	
                	<label>Address :</label>
                	<input type="text" name="address" required><br><br>
            
                    <input type="hidden" name="action" value="add"> <!-- Hidden field to indicate action -->
                    
                    
                    <button type="submit" class="in">Add Student</button>
                
                    <a href="/project" class="bak">Back</a>
        </form>    
</body>
</html>