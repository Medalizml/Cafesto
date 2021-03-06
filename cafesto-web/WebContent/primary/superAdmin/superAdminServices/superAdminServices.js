/**
 * Created by AMINOVISH.B on 11/07/2014.
 */


'use strict';

/* Services */
var services = angular.module('superAdmin.services', ['ngResource']);

services.factory('admins', ['$resource', function($resource) {
    return $resource('../../../cafesto/service/Administrator/:id',{},{
        'query':  {method:'GET', isArray:true},
        'save':   {method:'POST'},
        'findbymail': {method:'POST'},
        'update': {method:'PUT',params: {id: '@id'}},
        'delete': { method: 'DELETE', params: {id: '@id'} }


    });
}]);