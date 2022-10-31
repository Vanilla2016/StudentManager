<%@ page import="com.wds.beans.Student" %>
<%
	Student [] students = null;
%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>

    <div id="core" style="align-content: center;">
    <% if (request.getAttribute("studentTable") == null){ %>
    <div id="instruct" style="text-align: center; color: black; align-content: center;">
	    Please browse to the required Students file using the Choose File option below.
	    Then choose the type of sort you wish performed on the extracted list.
    </div> 
    
    <form method="POST" enctype="multipart/form-data" action="fileupload.do"> 
	  File to upload: <input type="file" name="upfile"><br/>
	  <!-- Notes about the file: <input type="text" name="note"><br/> -->
	  <br/>
	  <input type="submit" value="Press"> to upload the file!
	</form>
	<%} %>
    <p " style="text-align: center; color: green; align-content: center;">${successMessage}</p>
    
	<% if (request.getAttribute("studentTable") != null){ %>
	<table style="margin: 2px; padding: 6px; text-align: center; border: 2px; align-items: center; width: 25%">
	<%  
		students = (Student[])request.getAttribute("studentTable");
		for (Student student  : students) {
			if (student !=null){
	%>
		<tr>
			<td><%=student.getName() %></td>
			<td><%=student.getScore() %></td>
		</tr>	

		<% }
			}%>
	</table>

	<form method="POST" action="sort.do">
		<% request.setAttribute("studentTable", students); %>
		<input type="radio" id="bubble" name="sort_type" value="bubble" checked="checked">
		<label for="bubble">Bubble Sort</label><br>
		<button  type="submit"  style="height: 50px; width: 100px">Choose Sort Option and Click to Sort</button>
	</form>
	
	<form action="http://localhost:8080">
    	<input type="submit" value="Go Back to Start" />
	</form>	
	<% } %>
</body>
</html>