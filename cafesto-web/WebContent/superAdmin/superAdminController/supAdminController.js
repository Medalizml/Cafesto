/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
var app = angular.module('urls', ['ngRoute','app.services','paysapp','uploadapp'])


app.config(function($routeProvider){
    $routeProvider.when('/', {templateUrl: '../superAdmin/superadminViews/dashbord.html', controller: 'adminControllers'});
    $routeProvider.when('/test', {templateUrl: '../superAdmin/superadminViews/test.html', controller: 'adminControllers'});
    $routeProvider.when('/new', {templateUrl: '../superAdmin/superadminViews/admin/new.html', controller: 'adminControllers'});

});


    app.controller('adminControllers',['$scope','admins', function($scope,admins,$flow) {
        $scope.alladmins=admins.query();


    $scope.verifadmin=function(mail){
            console.log("testing ",mail);
            admins.findbymail({id:'findbymail'},mail,function (Response) {
                $scope.test = Response.resultat;
                console.log("test1",$scope.test);
                if($scope.test==true){
                    $scope.adminForm.email.$setValidity('exist',false);

                     console.log($scope.adminForm.email);
                    console.log("test2",$scope.test);
                    console.log("validation",$scope.adminForm.email.$valid);

                }else{
                    $scope.adminForm.email.$setValidity('exist',true);

                    console.log("test4",$scope.test);
                    console.log("validation",$scope.adminForm.email.$valid);
                }

            })

        }
        $scope.create=function(admin){
            if(admin.$valid){

                if($scope.test==false){
                    console.log("test2",$scope.test);
                    alert("User exsit")
                }else
                {
                    console.log("test3",$scope.test);
                    var file = document.getElementById("adminprofile").getAttribute('src')
                    var n= file.search(",");

                    $scope.admin.profile = file.substring(n+1,file.length);
                    console.log($scope.admin.profile);


                    admins.save($scope.admin);
                    console.log("valid");
                    console.log(admin);
                    alert("done");

                }

        }}
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
