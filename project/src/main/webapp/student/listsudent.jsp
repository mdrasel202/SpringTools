<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
    import="isdb.StudentDAO, isdb.Student, java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        h1{    text-align: center;
          font-weight: 400;
          letter-spacing: 1px;}
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td, tr {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h1>List of Students</h1>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
    	<% 
           StudentDAO studentDAO = new StudentDAO();
           List<Student> students = studentDAO.getAllStudents();
           for (Student student : students) {
         %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getPhone() %></td>
                    <td><%= student.getAddress() %></td>
                    <td><a href="updatestudent.jsp?id=<%=student.getId() %>"
                        class="bt2">Update</a>
                        <form action="StudentServlet" method="post" style="display:inline;">
                           <input type="hidden" name="id" value="<%=student.getId()%>">
                           <input type="hidden" name="action" value="delete">
                           <button type="submit" 
                           onclick="return confirm('Are you  sure want to delete this student');">Delete</button>
                        </form>
                     </td>   
                </tr>
            <% } %>
    </tbody>

</table>
    <a href="/project" >Back to home</a>
</body>
</html>