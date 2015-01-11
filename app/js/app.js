'use strict';

// Declare app level module which depends on views, and components
angular.module('whiskyApp', [
	'ngRoute',
	'whiskyApp.ctrl'
	])

.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/list', {
		templateUrl: '/views/whisky-list.html',
		controller: 'ListCtrl'
	})
	.when('/detail/:whiskyId', {
		templateUrl: '/views/whisky-detail.html',
		controller: 'DetailCtrl'
	})
	.when('/new', {
		templateUrl: '/views/add-whisky.html',
		controller: 'AddCtrl'
	})
	.otherwise({redirectTo: '/list'});
}])
.directive('backButton', function(){
    return {
      restrict: 'A',
 
      link: function(scope, element, attrs) {
        element.bind('click', goBack);
 
        function goBack() {
          history.back();
          scope.$apply();
        }
      }
    }
});

