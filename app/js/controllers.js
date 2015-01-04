'use strict';

var demo_data = [
{
	id: "1",
	name : "Laphroaig 10",
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
	subName: "10y0"
}
];


angular.module('whiskyApp.list', [])

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
	}]);;