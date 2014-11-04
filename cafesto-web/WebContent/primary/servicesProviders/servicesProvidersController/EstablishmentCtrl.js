/**
 * Created by Zammel on 05/10/2014.
 */
var establishmentCtrl =angular.module('establishmentSP.ctrl',['ui.map','ui.bootstrap'])

establishmentCtrl.controller('establishmentCtrl',['$scope','Establishment','$routeParams',function($scope,Establishment,$routeParams){

    $scope.myMarkers = [];

    $scope.mapOptions = {
        center: new google.maps.LatLng(35.784, -78.670),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    $scope.setZoomMessage = function(zoom) {
        $scope.zoomMessage = 'You just zoomed to '+zoom+'!';
        console.log(zoom,'zoomed')
    };
    $scope.openMarkerInfo = function(marker) {
        console.log("hello")
        $scope.currentMarker = marker;
        $scope.currentMarkerLat = marker.getPosition().lat();
        $scope.currentMarkerLng = marker.getPosition().lng();
        $scope.myInfoWindow.open($scope.myMap, marker);
    };
    $scope.setMarkerPosition = function(marker, lat, lng) {
        console.log("test")
        marker.setPosition(new google.maps.LatLng(lat, lng));
    };
    
    $scope.establishment=Establishment.getByid({id: '48'});
    console.log("dddd"+$scope.establishment);

}]);




