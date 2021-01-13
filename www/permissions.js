 var exec = require('cordova/exec');
 function Permissions() { 
	        this.ACCESS_COARSE_LOCATION = 'android.permission.ACCESS_COARSE_LOCATION';
            this.ACCESS_FINE_LOCATION = 'android.permission.ACCESS_FINE_LOCATION';
            this.ACCESS_LOCATION_EXTRA_COMMANDS = 'android.permission.ACCESS_LOCATION_EXTRA_COMMANDS';
            this.ACCESS_NETWORK_STATE = 'android.permission.ACCESS_NETWORK_STATE';
            this.CAMERA = 'android.permission.CAMERA'; 
 }
   
Permissions.prototype = { 
    RequestPermission: function(arg0, success, error) {	 
        exec(success, error, 'Permissions', 'RequestPermission', [arg0]);
    }
};
 
module.exports = new Permissions();
 