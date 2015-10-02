'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', function($scope, $http) {

  getUsers().then(function(users){
    $scope.users = users;
  });

  function getUsers(){
    return $http.get('http://52.29.24.118/user').then(function(response){
      return response.data;
      console.log("Load users")
    });
  }
});