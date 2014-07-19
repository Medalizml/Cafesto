/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
var app = angular.module('urls', ['ngRoute','app.services'])


app.config(function($routeProvider){
    $routeProvider.when('/', {templateUrl: '../superAdmin/superadminViews/dashbord.html', controller: 'adminControllers'});
    $routeProvider.when('/test', {templateUrl: '../superAdmin/superadminViews/test.html', controller: 'adminControllers'});
    $routeProvider.when('/new', {templateUrl: '../superAdmin/superadminViews/admin/new.html', controller: 'adminControllers'});

});


    app.controller('adminControllers',['$scope','admins', function($scope,admins) {
        $scope.alladmins=admins.query();

        $scope.create=function(){
            admins.save($scope.admin);
            alert("done");
        }
    }]
    );
