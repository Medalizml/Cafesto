angular.module('SP.ctrl',['paysapp','uploadapp'])



.controller('ServiceProviderControllers',['$scope','servicesProviders','$location', function($scope,serviceProviders,$location) {

    $scope.sp={};
    $scope.verifadmin=function(mail){

        serviceProviders.findbymail({id:'findbymail'},mail,function (Response) {
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



            serviceProviders.save($scope.sp);
            $location.path('/');
        }}



}]);



