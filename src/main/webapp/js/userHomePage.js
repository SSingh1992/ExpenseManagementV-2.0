function firstCall() {
	alert('ok');
	$.ajax({
		url:'2017/login/user',
		type:'GET',
		contentType: "application/json; charset=utf-8",
        data: user,
        success: function(userJson){
        	alert(userJson.name);
        },
        error: function(error){
        	alert("coming in error function")
        }
	});
}
window.onload = firstCall();