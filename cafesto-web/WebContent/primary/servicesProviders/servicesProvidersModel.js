/**
 * Created by AMINOVISH.B on 06/08/2014.
 */
var appServicesProviders = angular.module('ServicesProviders', ['ngRoute','SP.services','SP.ctrl','SP.directives','SP.filters','establishmentSP.ctrl','EstablishmentSp.services'])


appServicesProviders.config(function($routeProvider){


    $routeProvider.when('/',{templateUrl:'servicesProvidersViews/Dashbord.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/business',{templateUrl:'servicesProvidersViews/Business/list.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/services',{templateUrl:'servicesProvidersViews/Business/services.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/profile',{templateUrl:'servicesProvidersViews/Business/Profile.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/business/dishes',{templateUrl:'servicesProvidersViews/Business/Dishes/dishesList.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/business/services',{templateUrl:'servicesProvidersViews/Business/services/listservices.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/business/establishmentshow',{templateUrl:'servicesProvidersViews/Business/list/establishmentshow.html',controller:'ServiceProviderControllers'})
    $routeProvider.when('/business/addnewestablishmentmarker',{templateUrl:'servicesProvidersViews/Business/addestablishment/addmarker.html',controller:'ServiceProviderControllers'})
});