
/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
'use strict';

/* Controllers */


angular.module('SuperAdmin.ctrl',['paysapp','uploadapp'])
.controller('SuperAdminControllerCRUD',['$scope','$routeParams','admins','$location', function($scope,$routeParams,admins,$location) {
        $scope.alladmins=admins.query();
        $scope.admin={};
            if($routeParams.id!=null){
                $scope.admin = admins.get({id: $routeParams.id})

            }




    $scope.verifadmin=function(mail){

            admins.findbymail({id:'findbymail'},mail,function (Response) {
                $scope.test = Response.resultat;

                if($scope.test==true){
                    $scope.adminForm.email.$setValidity('exist',false);



                }else{
                    $scope.adminForm.email.$setValidity('exist',true);


                }

            })

        }

        $scope.create=function(admin){
            if(admin.$valid){



                    var file = document.getElementById("adminprofile").getAttribute('src')
                    var n= file.search(",");

                    $scope.admin.profile = file.substring(n+1,file.length);



                    admins.save($scope.admin);
                $location.path('/');



        }}
            $scope.editAdmin = function () { // callback for ng-click 'updateUser':

                if($scope.adminForm.$valid) {
                    var file = document.getElementById("adminprofile").getAttribute('src')

                    var n= file.search(",");

                    $scope.admin.profile = file.substring(n+1,file.length);


                        admins.update($scope.admin);
                        $location.path('/');
                    console.log($scope.admin);


                }
            };
        $scope.deleteUser = function (userId) {
            admins.delete({ id: userId });
            $scope.alladmins=admins.query();
        };

        $scope.editUser = function (userId) {

                $location.path('/update/' + userId);
            
            };

        $scope.activateUser=function(admin){

            console.log(admin)
            $scope.activeadmin=admin
            admin.status=true;
            console.log($scope.activeadmin)

            admins.update($scope.activeadmin);
        }
        $scope.InactivateUser=function(admin){

            console.log(admin)
            $scope.activeadmin=admin
            admin.status=false;
            console.log($scope.activeadmin)

            admins.update($scope.activeadmin);
        }

            $scope.numbers = [
                {ID: '10'},
                {ID: '25'},
                {ID: '50'},
                {ID: '100'}
            ];




        }]);





