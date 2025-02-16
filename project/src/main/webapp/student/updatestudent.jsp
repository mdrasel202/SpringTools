<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
     import = "isdb.StudentDAO, isdb.Student" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% 
   	  int id = Integer.parseInt(request.getParameter("id"));	
      StudentDAO studentDAO = new StudentDAO();
      Student student = studentDAO.getStudentsById(id);
   	  	
   %>
   
   <h2>Update Student</h2>
   
   <form action="StudentServlet " method="post">
   
   					<input type="hidden" name="id" value="<%= student.getId() %>" >
                
                    <label for="">Name :</label>
                    <input type="text" name="name" value="<%= student.getName() %>" required><br><br>
                
                    <label for="">Email :</label>
                    <input type="email" name="email" value="<%= student.getEmail() %>" required><br><br>
                
                	<label>Phone Number :</label>
                	<input type="text" name="phone" value="<%= student.getPhone() %>" required><br><br>
                	
                	<label>Address :</label>
                	<input type="text" name="address" value="<%= student.getAddress() %>" required><br><br>
            
                    <input type="hidden" name="action" value="update"> <!-- Hidden field to indicate action -->
                    
                    
                    <button type="submit" class="in">Update Student</button>
                
                    <a href="/project" class="bak">Cancel</a>
        </form>    
</body>
</html>