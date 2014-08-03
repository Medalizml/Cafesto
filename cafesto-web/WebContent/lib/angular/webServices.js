/**
 * Created by AMINOVISH.B on 02/08/2014.
 */


var services = angular.module('app.spservices', ['ngResource']);

services.factory('serviceProvider', ['$resource', function($resource) {
    return $resource('../../cafesto/service/ServiceProvider/:id',{},{
        'save':   {method:'POST'},
        'findbymail': {method:'POST'}
    });
}]);
