$(document).ready(function() {
	
	headerJs();
	
});

function headerJs() {
	
	// Sets the selected menu item with the class "active"
	$("ul.nav li").click(function() {
		
		$("ul.nav li").removeClass("active");
		
		$(this).addClass("active");
		
	});
	
}