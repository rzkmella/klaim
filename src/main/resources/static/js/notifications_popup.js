$('#notifications').slideDown('slow').delay(3000).slideUp('slow');

var notif;
var success = ['<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><h4>Success</h4><p>', '</p></div>'];
var warning = ['<div class="alert alert-warning"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><h4>Warning</h4><p>','</p></div>'];
var danger = ['<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><h4>Failed</h4><p>', '</p></div>'];

function loadNotification(status, message){
	notif = status[0]+message+status[1];
	$('#notifications').html(notif);
	$('#notifications').slideDown('slow').delay(3000).slideUp('slow');
}
