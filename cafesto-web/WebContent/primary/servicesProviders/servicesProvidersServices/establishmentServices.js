/**
 * Created by Zammel on 05/10/2014.
 */
angular.module('EstablishmentSp.services', ['ngResource'])

    .factory('Establishment', ['$resource', function($resource) {
        return $resource('../../../cafesto/service/SP/:id',{},{
            'getByid':{method:'GET',params: {id: '@id'}}
        });

    }]);