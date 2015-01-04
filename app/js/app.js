'use strict';

// Declare app level module which depends on views, and components
angular.module('whiskyApp', [
	'ngRoute',
	'whiskyApp.list'
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
	.otherwise({redirectTo: '/list'});
}]);