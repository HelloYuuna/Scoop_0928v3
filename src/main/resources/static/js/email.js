
	$(document).ready(function() {
		$('#invite_submitbtn').click(emailSend);
	});

	//이메일 발송
//    emailSend();

    //이메일 발송
    function emailSend() {
		let userId = $("#userId").val();
		let inviteWsid =  $("#inviteWsid").val();
		
		alert("User Id : " + userId);
		alert("Invite Workspace Id1 : " + inviteWsid);
		
        var subject = "혜민 님이 Asana에 있는 Scoop에 참가하도록 초대했습니다";
        var body = "혜민 님이 Scoop에 참가하도록 초대했습니다 \n http://localhost:9500/scoop/inviteWorkspace?wsid=" + inviteWsid;

        $.ajax({
            url: 'sendEmail' // /auth/
            , type: 'Post'
            , data: {userId: userId, subject:subject, body:body}
            , dataType: 'json'
            , success: function() {
				alert("success");
            }
            , error: function(e) {
                alert(JSON.stringify(e));
            }
        });
    }
    
    // success data :
//    <!DOCTYPE html>
//   	<html lang="en">
//    		<head>
//    			<meta charset="utf-8">
//    			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
//    			<meta name="description" content="">
//    			<meta name="author" content="">
//   			<title>Please sign in</title>
//    			<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6wYXjCFtcEpHbNj0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
//