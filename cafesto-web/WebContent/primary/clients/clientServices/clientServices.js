/**
 * Created by AMINOVISH.B on 04/08/2014.
 */
angular.module('client.services', ['ngResource'])

.factory('clients', ['$resource', function($resource) {
    return $resource('../../../cafesto/service/Client/:id',{},{
        'save':   {method:'POST'},
        'findbymail': {method:'POST'}
    });
}]);