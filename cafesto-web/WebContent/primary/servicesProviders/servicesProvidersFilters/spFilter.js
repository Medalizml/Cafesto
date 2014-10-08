/**
 * Created by AMINOVISH.B on 11/07/2014.
 */
angular.module('SP.filters', []).
    filter('interpolate', ['version', function(version) {
        return function(text) {
            return String(text).replace(/\%VERSION\%/mg, version);
        };
    }]);
