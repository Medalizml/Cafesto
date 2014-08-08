/**
 * Created by Zammel on 07/08/2014.
 */
var Generalapp=angular.module('generalApp',['ngRoute','client.services','SP.services','client.ctrl','SP.ctrl'])

Generalapp.config(function($routeProvider){

    $routeProvider.when('/',{templateUrl:'primary/accueil.html'})
    $routeProvider.when('/registre/client', {templateUrl: 'primary/clients/clientViews/registrationclient.html', controller: 'ClientControllers'});
    $routeProvider.when('/registre/ServiceProvider', {templateUrl: 'primary/servicesProviders/servicesProvidersViews/registrationsp.html', controller: 'ServiceProviderControllers'});
})
