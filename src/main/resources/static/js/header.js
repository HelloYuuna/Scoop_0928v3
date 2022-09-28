
	// DropDown
	function newWorkspaceFormOpen() {
		window.open('newWorkspace', 'New Workspace', 'left=400,top=200,width=600,height=315,menubar=no') // http://localhost:8888/spring6/member/join : join 대신에 idcheck
	}
	function addFunction() {
	  document.getElementById("dropdown").classList.toggle("show");
	}
	function myFunction() {
	  document.getElementById("myDropdown").classList.toggle("show");
	}
	function seeMoreFunction() {
	  document.getElementById("seeMoreDropdown").classList.toggle("show");
	}
	
	window.onclick = function(event) {
	  if (!event.target.matches('.dropbtn')) {
	    var dropdowns = document.getElementsByClassName("dropdown-content");
	    var i;
	    for (i = 0; i < dropdowns.length; i++) {
	      var openDropdown = dropdowns[i];
	      if (openDropdown.classList.contains('show')) {
	        openDropdown.classList.remove('show');
	      }
	    }
	  }
	}
	
	
	$(document).ready(function() {
		$('#newWorkspace_submitbtn').click(newWorkspace);
		$('#removeWorkspace_submitbtn').click(removeWorkspace);
	});

	function home(wsid) {
		alert("Home Number : " + wsid);
		location.href='/scoop/?wsid=' + wsid;
	}
	
	function switchWorkspace(wsid) {
		alert("Switch Workspace Home Number : " + wsid);
		
		$.ajax({
			type : "POST",
			url : "switchWorkspace",
			data : {wsid: wsid},
			success : function() {
				alert("success : " + wsid);
//				window.location.replace(data.redirect);
			},
			error: function(e) {
				alert(JSON.stringify(e));
			}
		})
	}
	
	function newWorkspace(wsid) {
		alert("New Workspace Home Number : " + wsid);
		
		$.ajax({
			type : "Get",
			url : "newWorkspace",
			data : {wsid: wsid},
			success : function() {
				alert("success : " + wsid);
			},
			error: function(e) {
				alert(JSON.stringify(e));
			}
		})
	}
	
	function removeWorkspace(wsid) {
		alert("Remove Workspace Home Number : " + wsid);
		
		$.ajax({
			type : "Get",
			url : "removeWorkspace",
			data : {wsid: wsid},
			success : function() {
				confirm("success : " + wsid);
			},
			error: function(e) {
				alert(JSON.stringify(e));
			}
		})
	}
	
