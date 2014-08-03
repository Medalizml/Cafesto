/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
var app = angular.module('urls', ['ngRoute','app.services','paysapp','uploadapp'])


app.config(function($routeProvider){
    $routeProvider.when('/', {templateUrl: '../superAdmin/superadminViews/dashbord.html', controller: 'adminControllers'});
    $routeProvider.when('/test', {templateUrl: '../superAdmin/superadminViews/test.html', controller: 'adminControllers'});
    $routeProvider.when('/new', {templateUrl: '../superAdmin/superadminViews/admin/new.html', controller: 'adminControllers'});
    $routeProvider.when('/update/:id', {templateUrl: '../superAdmin/superadminViews/admin/new.html', controller: 'adminControllers'});

});


app.controller('adminControllers',['$scope','$routeParams','admins','$location', function($scope,$routeParams,admins,$location) {
        $scope.alladmins=admins.query();
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
            $scope.editAdmin = function (admin) { // callback for ng-click 'updateUser':
                if(admin.$valid) {
                    var file = document.getElementById("adminprofile").getAttribute('src')
                    var n= file.search(",");

                    $scope.admin.profile = file.substring(n+1,file.length);


                        admins.update($scope.admin);
                        $location.path('/');



                }
            };
            $scope.editUser = function (userId) {

                $location.path('/update/' + userId);
            };


        }]
    );
app.directive("equals",function(){
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
