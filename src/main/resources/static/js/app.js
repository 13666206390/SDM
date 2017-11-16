'use strict';
var app = angular.module('myApp',
		['ngRoute',
		 'deviceControllers',
		 'deviceServices']);
app.config(['$routeProvider',
	function($routeProvider){
		$routeProvider.when('/SDM/findAll',{
			templateUrl:'resources/static/partials/deviceList.html',
			controller:'deviceListCtrl'
		}).when('/SDM/add',{
			templateUrl:'resources/statc/partials/addDevice.html',
			controller:'deviceAddCtrl'
		}).when('/SDM/findById/:deviceid',{
			templateUrl:'resources/static/partials/detailDevice.html',
			controller:'userDetailCtrl'
	}).when('/SDM/updateById/:deviceid',{
		templateUrl:'resources/static/partials/updateDevice.html',
		controller:'deviceUpdateCtrl'
	}).otherwise({
		redirectTo:'/SDM/findAll'
		});
}]);