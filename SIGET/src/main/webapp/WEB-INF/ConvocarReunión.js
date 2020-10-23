function ViewModel() {
	var self = this;
	self.users = ko.observableArray([]);
	self.selecteduser = ko.observable;
	
	
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