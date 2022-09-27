
	$(document).ready(function() {
		$('#invite_submitbtn').click(emailSend);
	});

	//이메일 발송
//    emailSend();

    //이메일 발송
    function emailSend() {
		let userId = $("#userId").val();
		alert("User Id1 : " + userId);
		
        var subject = "chats 회원인증번호 입니다.";
        var body = "안녕하세요 chats 입니다. \n 회원가입 인증번호는 입니다.";

        var params1 = {
             userId : userId
            ,subject : subject
            ,body : body
        }
        
        const params = JSON.stringify(params1);
        
		alert("User Id2 : " + userId);
		alert("Params1 : " + params1); // Params : [object Object]
		alert("Params : " + params);

        $.ajax({
            url: 'sendEmail' // /auth/
            ,type: 'Post'
            ,accept: 'application/json'
            ,contentType: 'application/json' // ; charset=utf-8
            ,data: encodeURIComponent(params) // encodeURI(params)
            ,dataType: 'text'
            ,success: function(data) {
				alert("success data : " + data);
            },
            error: function(e) {
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