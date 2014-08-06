/**
 * Created by AMINOVISH.B on 06/08/2014.
 */

appSuperadmin.controller('superAdminCtrl',['$scope','$routeParams','$location',function($scope,$routeParams,$location){

        $scope.admin = admins.get({id: $routeParams.id})

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
}])