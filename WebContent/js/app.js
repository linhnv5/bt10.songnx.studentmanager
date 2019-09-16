var modal, name = "", page = 0;

// var page = 0; // page of list student
// Load all student
$(document).ready(function(){
	reload();

	// Get the modal
	modal = $("#myModal");
});

// Reload page
function reload() {
	if (name == "")
		$('#studentView').load('getall?page='+page);
	else
		$('#studentView').load('getall?name='+name+'&page='+page);
}

// Add Student
function addStudent() {
	$('#hiddenView').load('studentedit.jsp', function() {
		$("#myModal").modal('show');
	});
}

// Delete Student
function deleteStudent(id) {
	$.get("delete?id="+id, function(ketqua) {
    	if(ketqua == 0) {
			alert("Delete student unsuccessful!");
			return;
    	}
		alert("Delete student successful!");
		reload();
	});
}

// Edit Student
function editStudent(id) {
	$('#hiddenView').load('studentedit.jsp?id='+id, function() {
		modal.modal('show');
	});
}

// Submit add student
function submitAdd() {
	let vname  = $("input[name='name']").val();
	let birth  = $("input[name='birth']").val();
	let gender = $("input[name='gender']:checked").val();
	let adDay  = $("input[name='adDay']").val();

	if(vname == "" || birth == "" || gender == "" || adDay == null) {
		alert("Please fill all data before click add!");
		return;
	}

	$.get("add?name="+vname+"&birth="+birth+"&gender="+gender+"&admissionDay="+adDay, function(ketqua) {
		modal.modal('hide');
    	if(ketqua == 0) {
			alert("Add student unsuccessful!");
			return;
    	}
		alert("Add student successful!");
		name = "";
		reload();
    });
}

// Submit edit student
function submitEdit() {
	let id     = $("input[name='id']").val();
	let vname  = $("input[name='name']").val();
	let birth  = $("input[name='birth']").val();
	let gender = $("input[name='gender']:checked").val();
	let adDay  = $("input[name='adDay']").val();

	if(id == "" || vname == "" || birth == "" || gender == "" || adDay == null) {
		alert("Please fill all data before click set!");
		return;
	}

	$.get("edit?id="+id+"&name="+vname+"&birth="+birth+"&gender="+gender+"&admissionDay="+adDay, function(ketqua) {
		modal.modal('hide');
		if(ketqua == 0) {
			alert("Edit student unsuccessful!");
			return;
    	}
		alert("Edit student successful!");
		reload();
    });
}

// Find by name
function findStudent() {
	vname = $("input[name='findName']").val();
	if (vname == null || vname == "") {
		alert ("Please enter the name to find!");
		return;
	}
	name = vname;
	reload();
}

// Back to student list
function studentList() {
	name = "";
	reload();
}

// Prev page
function prevPage() {
	if(page > 0)
		page--;
	reload();
}

// Next page
function nextPage() {
	page++;
	reload();
}

// Go to page
function toPage(p) {
	page = p;
	reload();
}
