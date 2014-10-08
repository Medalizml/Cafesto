/**
 * Created by Zammel on 02/10/2014.
 */

function  onGoogleReady() {
    console.log('Google maps api initialized.');
    var body = document.getElementsByTagName('body')[0];
    angular.bootstrap(body, ['ServicesProviders'])
}
angular.module('doc.ui-map', ['ui.map' ])
.controller('MapCtrl', ['$scope', function ($scope) {
        $scope.myMarkers = [];

        $scope.mapOptions = {
            center: new google.maps.LatLng(35.784, -78.670),
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        $scope.addMarker = function($event, $params) {
            $scope.myMarkers.push(new google.maps.Marker({
                map: $scope.myMap,
                position: $params[0].latLng
            }));
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
    }]);