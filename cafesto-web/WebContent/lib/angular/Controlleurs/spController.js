var appweb = angular.module('appWeb',['ngRoute','appWeb.spservices','appWeb.clientservices','paysapp','uploadapp'])

appweb.config(function($routeProvider){

    $routeProvider.when('/', {templateUrl: 'accueil.html', controller: ''});
    $routeProvider.when('/registre/ServiceProvider', {templateUrl: 'registrationsp.html', controller: 'ServiceProviderControllers'});
    $routeProvider.when('/registre/client', {templateUrl: 'registrationclient.html', controller: 'ClientControllers'});
});

appweb.controller('ServiceProviderControllers',['$scope','serviceProvider','$location', function($scope,serviceProvider,$location) {

    $scope.verifadmin=function(mail){

        serviceProvider.findbymail({id:'findbymail'},mail,function (Response) {
            $scope.test = Response.resultat;

            if($scope.test==true){
                $scope.spForm.email.$setValidity('exist',false);

            }else{
                $scope.spForm.email.$setValidity('exist',true);

            }

        })

    }
    $scope.create=function(sp){
        if(sp.$valid){



            var file = document.getElementById("adminprofile").getAttribute('src')
            var n= file.search(",");

            $scope.sp.profile = file.substring(n+1,file.length);



            serviceProvider.save($scope.sp);
            $location.path('/');
        }}



}]);



appweb.directive("equals",function(){
    return {
        restrict: 'A', // only activate on element attribute
        require: '?ngModel', // get a hold of NgModelController
        link: function(scope, elem, attrs, ngModel) {
            if(!ngModel) return; // do nothing if no ng-model

            // watch own value and re-validate on change
            scope.$watch(attrs.ngModel, function() {
                validate();
            });

            // observe the other value and re-validate on change
            attrs.$observe('equals', function (val) {
                validate();
            });

            var validate = function() {
                // values
                var val1 = ngModel.$viewValue;
                var val2 = attrs.equals;

                // set validity
                ngModel.$setValidity('equals', val1 === val2);
            };

        }
    }


})