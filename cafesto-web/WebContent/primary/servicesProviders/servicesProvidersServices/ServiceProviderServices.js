/**
 * Created by AMINOVISH.B on 11/07/2014.
 */

angular.module('SP.services', ['ngResource'])

.factory('servicesProviders', ['$resource', function($resource) {
    return $resource('../../../cafesto/service/ServiceProvider/:id',{},{
        'save':   {method:'POST'},
        'findbymail': {method:'POST'}
    });
}]);