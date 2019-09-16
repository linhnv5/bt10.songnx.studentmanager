<%@page import="topica.linhnv5.studentmanager.model.StudentDB"%>
<%@page import="topica.linhnv5.studentmanager.utils.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="topica.linhnv5.studentmanager.model.*"  %>  

<%
	// add or edit
	String idStr; int id = -1;
	if((idStr = request.getParameter("id")) != null) {
		try {
			id = Integer.parseInt(idStr);
		} catch(Exception e) {
		}
	}
	if(id == -1) {
%>
Name: <input type="text" name="name"/><br/>
Gender: <input type="radio" name="gender" value="1" checked="checked"/>Male <input type="radio" name="gender" value="0"/>Female<br/>
Admission Day: <input type="date" name="adDay"/><br/>
<button onclick="submitAdd();">Add</button>
<%
	} else {
		Student student = StudentDB.gI().getStudentByID(id);
		if(student == null) {
%>
Student with id=<%=id%> not exists!
<%
		} else {
%>
<input type="hidden" name="id" value="<%=id%>"/>
Name: <input type="text" name="name" value="<%=student.getName()%>"/><br/>
Gender: <input type="radio" name="gender" value="1"<%=student.getGender() == 1 ? " checked=checked" : ""%>/>Male
		<input type="radio" name="gender" value="0"<%=student.getGender() == 0 ? " checked=checked" : ""%>/>Female<br/>
Admission Day: <input type="date" name="adDay" value="<%=student.getAdmissionDayStr1()%>"/><br/>
<button onclick="submitEdit();">Set</button>
<%
		}
	}
%>
