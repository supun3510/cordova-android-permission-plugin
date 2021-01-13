package com.android.plugins;

import android.os.Build;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JasonYang on 2016/3/11.
 */
public class Permissions extends CordovaPlugin {

	public static final int REQ_CODE = 1;
	
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("RequestPermission")) {
            String message = args.getString(0);
            this.RequestPermission(message, callbackContext);
            return true;
        }
        return false;
    }

    private void RequestPermission(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {		
			try{
				if(cordova.hasPermission(message))
				{
					callbackContext.success("Permission Already Granted");
				}
				else
				{ 
					 cordova.requestPermission(this, REQ_CODE, message);					  
				}
			}catch(Exception ex){
					callbackContext.error(ex+" Error"); 
			} 
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
	
	public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
    // you can find the whole example implementation in the docs
	
    }
	
}
