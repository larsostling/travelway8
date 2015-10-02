'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])


.controller('View1Ctrl', function($scope, $http, $location) {

   $scope.passportName;
    $scope.passportNr;
    $scope.validToDate;
    $scope.phone;
    $scope.email;
    $scope.citizenship;
    $scope.socialSecurityNr;

   $scope.submit = function(){
      var data = {};

      data.passportName = $scope.passportName;
      data.passportNr = $scope.passportNr;
      data.validToDate = $scope.validToDate;
      data.phone = $scope.phone;
      data.email = $scope.email;
      data.citizenship = $scope.citizenship;
      data.socialSecurityNr = $scope.socialSecurityNr;

      $scope.createUser(data).then(function(){
        $location.path("/addedUserView");
      });
    }

  $scope.createUser = function(user){

    user = user || {
      passportName: 'My passport name',
      passportNr: 'My passport nr',
      validToDate: (new Date()).toString(),
      phone: '0767-703555',
      email: 'gustaf.nk2@gmail.com',
      citizenship: 'Sweden',
      socialSecurityNr: '800101-7654'
    };

    return $http({
      method: 'POST',
      url: 'http://52.29.24.118/user/',
      data: user
    }).then(function successCallback(response) {
      console.log("Success");
    }, function errorCallback(response) {
      console.log("Fail");
    });
  }
});