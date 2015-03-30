/* Copyright (c) 2007 Marlin Forbes (http://www.datashaman.com)
* Dual licensed under the MIT
* (http://www.opensource.org/licenses/mit-license.php)
* and GPL
* (http://www.opensource.org/licenses/gpl-license.php) licenses.
*/
/* function setupParameters
* Creates an object property window.location.parameters which
* is an associative array of the URL querystring parameters used
* when requesting the current document.
* If the parameter is present but has no value, such as the parameter
* flag in http://example.com/index.php?flag&id=blah, null is stored.
*/
function setupParameters() {
    var parameters = new Object();
    if(window.location.search) {
        var paramArray = window.location.search.substr(1).split('&');
        var length = paramArray.length;
        for (var index = 0;index <length; index++ ) {
            var param = paramArray[index].split('=');
            var name = param[0];
            var value =
                typeof param[1] == "string" ? decodeURIComponent(param[1].replace(/\+/g, ' ')) : null;
            parameters[name] = value;
        }
    }
    window.location.parameters = parameters;
}
setupParameters();