'use strict';

var demo_data = [
{
	id: "1",
	name : "Laphroaig",
	subName: "10yo"
},
{
	id: "2",
	name : "Laphroaig",
	subName: "quarter cask"
},
{
	id: "3",
	name : "Ardbeg",
	subName: "10yo"
},
{
	id: "4",
	name : "Lagavullin",
	subName: "16yo"
},
{
	id: "5",
	name : "Balvenie",
	subName: "14 yo - caribbean cask"
},
{
	id: "6",
	name : "Bruichladdich",
	subName: "the laddie ten"
}
];


angular.module('whiskyApp.ctrl', [])

.controller('ListCtrl', [ '$scope', 
	function($scope) {
		$scope.whiskies = demo_data;
	}])

.controller('DetailCtrl', [ '$scope', '$routeParams', 
	function($scope, $routeParams) {

		demo_data.forEach(function(element){	
			if(element.id === $routeParams.whiskyId){
				$scope.whisky = element;
			}
		});
	}])
.controller('AddCtrl' ,[ '$scope',  
	function($scope) {
		$scope.save = function() {
			//TODO
		};
	}]);

