<%@page import="topica.linhnv5.studentmanager.utils.DateUtil"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- import -->
<%@page import="topica.linhnv5.studentmanager.model.*, java.util.*"  %>  

<%!
	final int PAGE_MAX = 5;

	int pageNum = 0;
%>

<%
	// Get request name
	String name = request.getParameter("name");

	// Get request page
	try {
		pageNum = Integer.parseInt(request.getParameter("page"));
	} catch(Exception e) {
	}

	// Get all student
	List<Student> list = StudentDB.gI().getStudentByName(name);

	// Get max page
	int pageNumMax = list.size() / PAGE_MAX + (list.size() % PAGE_MAX == 0 ? 0 : 1); 

	// Check if out of list
	if (pageNum >= pageNumMax)
		pageNum = pageNumMax-1;

	// if have enough PAGE_MAX elements then sub PAGE_MAX elements to list
	list = pageNum < pageNumMax-1 ? list.subList(pageNum*PAGE_MAX, (pageNum+1)*PAGE_MAX) : list.subList(pageNum*PAGE_MAX, list.size());
%>
<table border="1">
<%
	if (name != null) {
%>
    <thead>  
        <tr>
			<th colspan="5">Result for <%=name%></th>
        </tr>  
    </thead>  
<%
		}
%>
    <thead>  
        <tr>  
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Admission Day</th>
            <th>Action</th>
        </tr>  
    </thead>  
    <tbody>  
    	<%
	    	// print to client
        	for (Student student : list) {
        %>
            <tr>  
                <td><%=student.getIddb()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getGenderStr()%></td>
                <td><%=student.getAdmissionDayStr2()%></td>
                <td>
                    <a href="javascript:editStudent(<%=student.getIddb()%>);">Edit</a>  
                    <a href="javascript:deleteStudent(<%=student.getIddb()%>);">Delete</a>  
                </td>
            </tr>  
        <%
	        }
    	%>
    </tbody>  
</table>

<%
	// Print pagination to client
	if (pageNumMax > 1) {
%>
<div class="pagination">
<%
		if (pageNum > 0) {
%>
    <a href="javascript:prevPage();">&laquo;</a>
<%
		}
		for (int i = 0; i < pageNumMax; i++) {
			if (i == pageNum) {
%>
	<a class="active" href="#"><%=i%></a>
<%
			} else {
%>
	<a href="javascript:toPage(<%=i%>);"><%=i%></a>
<%
			}
		}
		if (pageNum < pageNumMax-1) {
%>

	<a href="javascript:nextPage();">&raquo;</a>
<%
		}
%>
</div>
<%
	}
%>
