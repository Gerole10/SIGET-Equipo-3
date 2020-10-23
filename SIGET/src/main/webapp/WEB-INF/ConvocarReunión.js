function ViewModel() {
	var self = this;
	self.users = ko.observableArray([]);
	
	
	getUserNames();
	
	function getUserNames() {
		$.get("getUserNames", function(names) {
			for (var i=0; i<names.length; i++) {
				self.users.push(name);
			}
		});
	}
}

var vm = new ViewModel();
ko.applyBindings(vm);