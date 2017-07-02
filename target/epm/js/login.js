function login(){
    var username = $("#uname").val();
    var password = $("#psw").val();
    var userDetails = {
    	user_id: parseInt(username),
        password: password
    };
    if(password==="" && username===""){
        // alert("Username and password is missing");
        $("#notEntered").empty();
        $("#notEntered").text("Fields missing");
    }else if(password==="" && username != ""){
        //no username
        $("#notEntered").empty();
        $("#notEntered").text("Enter password");
    }else if(password != "" && username === ""){
        //no password
        $("#notEntered").empty();
        $("#notEntered").text("Enter username");
    }else{
        var user = buildJson(userDetails);
        alert(userDetails);
        alert("after build json");
        $.ajax({
            url:'2017/login/page',
            type:'POST',
            contentType: "application/json; charset=utf-8",
            data: user,
            success: function (response) {
            	alert(response.message+","+response.resCode);
            	if(response !== null){
            		if(response.resCode == 200){
            			alert("Local success callback.");
                    	window.location="userHomePage.html";
            		}else if(response.resCode == 204){
            			$("#notEntered").html("Wrong fields")
            		}else{
            			alert("Something went wrong - function success");
            		}            			
            	}            	
            	},
            error: function (error){
    	    	alert("coming in error function")}
        });
        // http://www.binaryintellect.net/articles/749ed588-b408-4a7e-94da-77549c00e803.aspx
        // Info about ajax and success, failure and completion
    }
}
function buildJson(request){
	var response = JSON.stringify(request);
	return response;
}