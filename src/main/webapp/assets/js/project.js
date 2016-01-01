function checkRedirect() {
	var user = '<%= Session["user"] %>';
	if(user == null) {
		window.location = "/FitnessTracker/home.html"
	}
}
