'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', function($scope, $http, $timeout) {

  getUsers().then(function(users){
    $scope.users = users;
  });

  $scope.message = "";
  $scope.messages = [
    { username: "Fatima", time: new Date(), message: "Right now it looks like the weather in Toledo will be really nice." },
  ]

  $scope.submitMessage = function(){
    $scope.messages.push({
      username: "Gabriella", time: new Date(), message: $scope.editMessage
    });
    $scope.editMessage = "";

    $timeout(function(){
      $scope.typingUser = "Fatima is typing..."
    }, 3000);

    $timeout(function(){
      $scope.typingUser = "";
      $scope.messages.push({ username: "Fatima", time: new Date(), message: "Glad to hear that Gabriella! :)" });
    }, 8000);
  }

  function getUsers(){
    return $http.get('http://52.29.24.118/api/user').then(function(response){
      return response.data;
      console.log("Load users")
    });
  }
});