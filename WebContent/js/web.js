var modal, name = "", page = 0;

// var page = 0; // page of list student
// Load all student
$(document).ready(function(){
	reload();

	// Get the modal
	modal = $(".modal");

	// Get the <span> element that closes the modal
	// When the user clicks on <span> (x), close the modal
	$('.close').click(function() {
		modal.hide();
	});
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
		modal.show();
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
		modal.show();
	});
}

// Submit add student
function submitAdd() {
	let name   = $("input[name='name']").val();
	let gender = $("input[name='gender']:checked").val();
	let adDay  = $("input[name='adDay']").val();

	if(name == "" || gender == "" || adDay == null) {
		alert("Please fill all data before click add!");
		return;
	}

	$.get("add?name="+name+"&gender="+gender+"&admissionDay="+adDay, function(ketqua) {
		modal.hide();
    	if(ketqua == 0) {
			alert("Add student unsuccessful!");
			return;
    	}
		alert("Add student successful!");
		reload();
    });
}

// Submit edit student
function submitEdit() {
	let id     = $("input[name='id']").val();
	let name   = $("input[name='name']").val();
	let gender = $("input[name='gender']:checked").val();
	let adDay  = $("input[name='adDay']").val();

	if(id == "" || name == "" || gender == "" || adDay == null) {
		alert("Please fill all data before click set!");
		return;
	}

	$.get("edit?id="+id+"&name="+name+"&gender="+gender+"&admissionDay="+adDay, function(ketqua) {
		modal.hide();
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
	name = $("input[name='findName']").val();
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
