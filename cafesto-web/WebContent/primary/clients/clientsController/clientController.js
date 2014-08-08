/**
 * Created by AMINOVISH.B on 04/08/2014.
 */
angular.module('client.ctrl',['paysapp','uploadapp'])
.controller('ClientControllers',['$scope','$location','clients', function($scope,$location,clients) {
    $scope.client={}
    $scope.verifadmin=function(mail){

        clients.findbymail({id:'findbymail'},mail,function (Response) {
            $scope.test = Response.resultat;

            if($scope.test==true){
                $scope.clientForm.email.$setValidity('exist',false);

            }else{
                $scope.clientForm.email.$setValidity('exist',true);

            }

        })

    }
    $scope.create=function(client){
        if(client.$valid){



            var file = document.getElementById("adminprofile").getAttribute('src')
            var n= file.search(",");

            $scope.client.profile = file.substring(n+1,file.length);



            clients.save($scope.client);
            $location.path('/');
        }}



}]);


