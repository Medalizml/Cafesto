angular.module('SP.ctrl',['paysapp','uploadapp','doc.ui-map','ui.bootstrap'])



.controller('ServiceProviderControllers',['$scope','servicesProviders','$location','$modal', function($scope,serviceProviders,$location,$modal) {
//--------------------CRUDCTRL-----------------------
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
        //------------------------levelCTRL----------------------

        $scope.rate = 7;
        $scope.max = 10;
        $scope.isReadonly = false;

        $scope.ratingStates = [
            {stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle'},
            {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
            {stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle'},
            {stateOn: 'glyphicon-heart'},
            {stateOff: 'glyphicon-off'}
        ];
 //------------------------------active class----------------------------
        $scope.isActive = function (viewLocation) {

            var active = (viewLocation === $location.path());
            return active;
        };


//--------------------------------------modal-------------------------------
        $scope.open = function (size) {

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: 'ModalInstanceCtrl',
                size: size,
                resolve: {

                }
            });

        }

       //--------------------------------mapCtrl-------------------------------

    }]);


angular.module('ui.bootstrap').controller('ModalInstanceCtrl', function ($scope, $modalInstance) {

    $scope.rate = 1;
    $scope.max = 5;
    $scope.isReadonly = true;

    $scope.ok = function () {

        $modalInstance.dismiss('ok');
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
    $scope.isCollapsed = false;
});
