/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
angular.module('superAdmin.filters', []).
    filter('interpolate', ['version', function(version) {
        return function(text) {
            return String(text).replace(/\%VERSION\%/mg, version);
        };
    }]);
