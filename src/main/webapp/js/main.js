(function(){
	var app = angular.module('SecretSanta', ['ngResource']);
	
	app.controller('SantaGroupController', function($scope, $http){
		$scope.groups = [];
		$scope.santaGroup = {};
		
		/*var resource =$resource('http://localhost:8080/SecretSanta/rest/santagroup/:id');
		
		function listSantaGroups(){
			resource.query(function(retorno){
				$scope.groups = retorno;
			});
		};
		
		listSantaGroups();*/
		function listSantaGroups(){
			$http.get('http://localhost:8080/SecretSanta/rest/santagroup').success(function(data){
				$scope.groups= data;
			}).error(function(msg){
				$scope.message = "Something wrong happened!!!";
			});
		}
		
		listSantaGroups();
		
		$scope.addGroup = function(){
			$scope.santaGroup.members=[];
			
			$scope.santaGroup.creationDate = new Date();
			$scope.groups.push($scope.santaGroup);
			
			$http.post('http://localhost:8080/SecretSanta/rest/santagroup', $scope.santaGroup).error(function(msg){
				$scope.message = "Something wrong happened!!!";
			});
			
			$scope.santaGroup = {};
		};
	});
	
	app.controller('MemberController', function($scope){
		$scope.member = {};
		
		this.addMember = function(group){
			group.members.push($scope.member);
			$scope.member = {};
		};
	});
	
})();
//http://localhost:8080/SecretSanta/rest/santagroup
