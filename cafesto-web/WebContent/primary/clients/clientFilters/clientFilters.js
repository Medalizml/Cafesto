/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
angular.module('client.filters', []).
    filter('interpolate', ['version', function(version) {
        return function(text) {
            return String(text).replace(/\%VERSION\%/mg, version);
        };
    }]);
