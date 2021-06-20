$(document).ready(function() {
	$(".main>li >a ").click(function() {
		var ulNode = $(this).next("ul");
		ulNode.slideToggle();
	});
})