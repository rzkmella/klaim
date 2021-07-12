function currencyFormater(input){
	var output;
	if (input != null) {
		var data = input.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		output = data;
	}
	return	output;	
}

function resizeIframe(obj) {
	var height = obj.contentWindow.document.documentElement.scrollHeight+15;
	if (obj.contentWindow.document.documentElement.scrollHeight == 0) {
		obj.style.height = obj.contentWindow.document.documentElement.scrollHeight + 'px';
	}else{
		obj.style.height = height + 'px';
	}
}

function getSize() {	  
	var height = $(window).height();	
	$(".modal-content").css("height", height);
	// var width = $(window).width();
	// $(".modal-content").css("width", width);
}