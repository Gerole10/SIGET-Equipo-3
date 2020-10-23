function ViewModel() {
	var self = this;
	self.user = ko.observableArray([]); //Array observable con los usuarios de la bbdd
	
	
	getUserNames();
	
	function getUserNames() {
		$.get("getUser", function(user) {
			for (var i=0; i<user.length; i++) {
				self.user.push();
			}
		});
	}
}

var vm = new ViewModel();
ko.applyBindings(vm);