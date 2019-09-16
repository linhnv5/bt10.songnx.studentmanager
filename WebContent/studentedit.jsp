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
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">Student Add</h4>
</div>

<div class="modal-body">
<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Name</label>
		<div class="col-md-7">
			<input type="text" name="name"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">YearOfBirth</label>
		<div class="col-md-7">
			<input type="number" name="birth"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Gender</label>
		<div class="col-md-7">
			<input type="radio" name="gender" value="1" checked="checked"/>Male <input type="radio" name="gender" value="0"/>Female
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Admission Day</label>
		<div class="col-md-7">
			<input type="date" name="adDay"/>
		</div>
	</div>
</div>

<button class="btn btn-info btn-md" onclick="submitAdd();">Add</button>
</div>
<%
	} else {
		Student student = StudentDB.gI().getStudentByID(id);
%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">Edit Student #<%=id%></h4>
</div>

<div class="modal-body">
<%
		if(student == null) {
%>
Student with id=<%=id%> not exists!
<%
		} else {
%>
<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Name</label>
		<div class="col-md-7">
			<input type="text" name="name" value="<%=student.getName()%>"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">YearOfBirth</label>
		<div class="col-md-7">
			<input type="number" name="birth" value="<%=student.getYearOfBirth()%>"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Gender</label>
		<div class="col-md-7">
			<input type="radio" name="gender" value="1"<%=student.getGender() == 1 ? " checked=checked" : ""%>/>Male
			<input type="radio" name="gender" value="0"<%=student.getGender() == 0 ? " checked=checked" : ""%>/>Female<br/>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label class="col-md-3 control-lable">Admission Day</label>
		<div class="col-md-7">
			<input type="date" name="adDay" value="<%=student.getAdmissionDayStr1()%>"/><br/>
		</div>
	</div>
</div>

<button class="btn btn-info btn-md" onclick="submitEdit();">Set</button>

<%
		}
%>

</div>

<%
	}
%>

<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>
