/**
 * Created by Zammel on 26/07/2014.
 */
var appupload = angular.module('uploadapp', ['flow'])
    .config(['flowFactoryProvider', function (flowFactoryProvider) {
        flowFactoryProvider.defaults = {
            target: '',
            permanentErrors: [404, 500, 501],
            maxChunkRetries: 1,
            chunkRetryInterval: 5000,
            simultaneousUploads: 4,
            singleFile: true
        };
        flowFactoryProvider.on('catchAll', function (event) {

            console.log('catchAll', arguments);

            //console.log($scope.admin);
        });
        // Can be used with different implementations of Flow.js
       // flowFactoryProvider.factory = fustyFlowFactory;
    }]);

appupload.controller('uploadCtr','$scope',function($scope){

    $scope.isDataAvailable=function(){
        if($scope.admin.profile!=null){
            userprofile.src="data:image/png;base64,"+$scope.admin.profile;
            adminprofile.src="data:image/png;base64,"+$scope.admin.profile;
            return true
        }
        else{
            userprofile.src="http://senate.tufts.edu/no-profile-img.jpg";
            return false
        }
    }
})
