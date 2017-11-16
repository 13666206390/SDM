'use strict';
var deviceServices = angular.module('deviceServices',['ngResource']);

deviceServices.factory('deviceservice',['$resource',
      function($resource){
		return  {
				list:$resource('SDM/findAll',{},{
						query:{method:'GET',params:{},isArray:true}
					}),
				add:$resource('SDM/add',{},{
					save:{method:'POST'}
		  		}),
		  		delete:$resource('SDM/deleteById/:deviceid',{deviceid:'@id'},{
		  			delete:{method:'DELETE'}
		  		}),
		  		detail:$resource('SDM/findById/'+deviceid,{deviceid:'@id'},{
		  			get:{method:'GET'}
		  		}),
		  		update:$resource('SDM/updateById/:deviceid',{deviceid:'@id'},{
		  			save:{method:'PUT'}
		  		})
		}
}]);
