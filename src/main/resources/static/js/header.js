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
	
	function workspaceHome(wsid) {
		alert("New Workspace Home Number : " + wsid);
		location.href='/scoop/workspaceHome?wsid=' + wsid;
	}
	