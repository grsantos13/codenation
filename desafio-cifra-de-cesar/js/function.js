$(function(){
	var iBody = $("#iFrameSuperlogica").contents().find("body");
	var myContent = iBody.find("#email");

	myContent.click(function(e){
		alert('hi')
	})
})