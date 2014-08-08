/**
 * Created by AMINOVISH.B on 06/08/2014.
 */
var appSuperadmin = angular.module('SuperAdmin', ['ngRoute','superAdmin.services','SuperAdmin.ctrl','superAdmin.directives','superAdmin.filters'])


appSuperadmin.config(function($routeProvider){
    $routeProvider.when('/', {templateUrl: 'superadminViews/dashbord.html', controller: 'SuperAdminControllerCRUD'});
    $routeProvider.when('/test', {templateUrl: 'superadminViews/test.html', controller: 'SuperAdminControllerCRUD'});
    $routeProvider.when('/new', {templateUrl: 'superadminViews/admin/new.html', controller: 'SuperAdminControllerCRUD'});
    $routeProvider.when('/update/:id', {templateUrl: 'superadminViews/admin/update.html', controller: 'SuperAdminControllerCRUD'});

});