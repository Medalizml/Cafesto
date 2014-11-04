/**
 * Created by Zammel on 10/10/2014.
 */
angular.module('ui.bootstrap').controller('ProgressDemoCtrl', function ($scope) {
    $scope.max = 200;
       console.log($scope.max)
    $scope.random = function() {
        var value = 50;
        var type;

        if (value < 25) {
            type = 'success';
        } else if (value < 50) {
            type = 'info';
        } else if (value < 75) {
            type = 'warning';
        } else {
            type = 'danger';
        }

        $scope.showWarning = (type === 'danger' || type === 'warning');

        $scope.dynamic = value;
        $scope.type = type;
    };
});
