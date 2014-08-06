/**
 * Created by AMINOVISH.B on 06/08/2014.
 */
var appSuperadmin = angular.module('urls', ['ngRoute','app.services','paysapp','uploadapp','SuperadminControllers'])


appSuperadmin.config(function($routeProvider){
    $routeProvider.when('/', {templateUrl: '../superAdmin/superadminViews/dashbord.html', controller: 'adminControllers'});
    $routeProvider.when('/test', {templateUrl: '../superAdmin/superadminViews/test.html', controller: 'adminControllers'});
    $routeProvider.when('/new', {templateUrl: '../superAdmin/superadminViews/admin/new.html', controller: 'adminControllers'});
    $routeProvider.when('/update/:id', {templateUrl: '../superAdmin/superadminViews/admin/update.html', controller: 'adminControllers'});

});