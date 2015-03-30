var MainController = function() {

	this.initialize = function() {
		loadWhiskyList();
	};	

	function loadWhiskyList() {
		$.ajax({
			url: "http://whisky.repsaj.com/api/whisky/",
			dataType: 'json',
			success: function(data) {
				renderWhiskyList(data);
			},
			error: function(xhr, status, err) {
				console.error(err.toString());
			}
		});

	}

	function renderWhiskyList(whiskyList) {
		React.render(
    		React.createElement(WhiskyList, {data: whiskyList}),
    		document.getElementById('container')
		);
	}


};
var mainController = new MainController();

$(document).ready(function() {	
	mainController.initialize();
});