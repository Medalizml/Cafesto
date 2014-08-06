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
appupload.controller('uploadimage',['$scope',function($scope){

    console.log($scope.admin)
    console.log(adminprofile)
    console.log($scope.admin.profile)
    console.log($scope.admin.lastName)
    


}])

appupload.controller('uploadCtr','$scope',function($scope){

    $scope.isDataAvailable=function(){
    	if($scope.admin.profile!=null) {
            userprofile.src = "data:image/gif;base64," + $scope.admin.profile;
            adminprofile.src="data:image/gif;base64,"+$scope.admin.profile;
        }else{
            userprofile.src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image";
        }
    }
})
