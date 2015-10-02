'use strict';

angular.module('myApp.addedUserView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addedUserView', {
    templateUrl: 'addedUserView/addedUserView.html',
    controller: 'addedUserViewCtrl'
  });
}])

.controller('addedUserViewCtrl', function($scope) {

});