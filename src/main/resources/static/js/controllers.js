'use strict';
var myController = angular.module('deviceControllers',[]);

myController.controller('deviceListCtrl',['$scope','$location','deviceservice',
      function($scope,$location,deviceservice){
		$scope.devices = deviceservice.list.query();
		$scope.delete = function(id,name){
			deviceservice.delete.delete({deviceid:id});
			alert("成功删除设备【"+name+"】");
			$location.path('/SDM/findAll');
		}
		$scope.detail = function(id){
			$location.path('/SDM/findById/'+id);
		}
		$scope.edit = function(device){
			console.log(device.id);
			$location.path('/SDM/updateById/'+device.id);
		}
}]);

myController.controller('deviceAddCtrl',['$scope','$location','deviceservice',
      function($scope,$location,deviceservice){
		$scope.save = function(){
			deviceservice.add.save($scope.device);
			//$location.path('/SDM/findAll');
		}
		$scope.reset = function(){
			$scope.device = '';
		}
}]);

myController.controller('deviceDetailCtrl',['$scope','$routeParams','deviceservice',
	   function($scope,$routeParams,deviceservice){
		$scope.device = deviceservice.detail.get({deviceid:$routeParams.deviceid});
 }]);

myController.controller('userUpdateCtrl',['$scope','$routeParams','$location','deviceservice',
	   function($scope,$routeParams,$location,deviceservice){
		console.log("update:"+$routeParams.deviceid);
		$scope.device = deviceservice.detail.get({deviceid:$routeParams.deviceid});
		$scope.save = function(){
			console.log("update:save");
			deviceservice.update.save($scope.device);
			$location.path('/SDM/findAll');
		}
}]);
