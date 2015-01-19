'use strict';


angular.module('whiskyApp.ctrl', [])

.controller('ListCtrl', [ '$scope', 'WhiskyService', 
	function($scope, whiskyService) {
		$scope.whiskies = whiskyService.query();
	}])

.controller('DetailCtrl', [ '$scope', '$routeParams', 'WhiskyService',
	function($scope, $routeParams, whiskyService) {
		$scope.whisky = whiskyService.get({id: $routeParams.whiskyId});
	}])
.controller('AddCtrl' ,[ '$scope', '$location', 'WhiskyService',  
	function($scope, $location, whiskyService) {
		
		$scope.whisky = new whiskyService();

		$scope.addWhisky = function() {
			$scope.whisky.$save(function(){
				$location.path('/list')
			});
		};
	}]);

