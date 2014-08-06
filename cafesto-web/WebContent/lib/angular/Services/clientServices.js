/**
 * Created by AMINOVISH.B on 04/08/2014.
 */
var services = angular.module('appWeb.clientservices', ['ngResource']);

services.factory('clientService', ['$resource', function($resource) {
    return $resource('../../cafesto/service/Client/:id',{},{
        'save':   {method:'POST'},
        'findbymail': {method:'POST'}
    });
}]);