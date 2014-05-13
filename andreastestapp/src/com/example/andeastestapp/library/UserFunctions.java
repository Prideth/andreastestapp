/**
 * based on the concept of Ravi Tamada
 * edited by Andreas Dier
 * 
 * 
 * @author adier
 * */

package com.example.andeastestapp.library;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class UserFunctions implements Serializable{
	
	private static final long serialVersionUID = 4793059875476004728L;



	private JSONParser jsonParser;
	
	private static String sign_in_URL = "http://andreastest.de.a9sapp.eu/users/sign_in";
	private static String sign_up_URL = "http://andreastest.de.a9sapp.eu/users/sign_up";
	private static String forpassURL = "http://andreastest.de.a9sapp.eu/users/password/new";
    private static String chgpassURL = "";
	
	private static String sign_in_tag = "sign_in";
	private static String sign_up_tag = "sign_up";
	private static String forpass_tag = "forpass";
    private static String chgpass_tag = "chgpass";
	
	// constructor
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * function make Login Request 
	 * @param email
	 * @param password
	 * */
	public JSONObject loginUser(String email, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("page", sign_in_tag));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl(sign_in_URL, params);
		// return json
		 Log.e("JSON", json.toString());
		return json;
	}
	
	
	/**
     * Function to change password
     **/

    public JSONObject chgPass(String newpas, String username){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("page", chgpass_tag));

        params.add(new BasicNameValuePair("newpas", newpas));
        params.add(new BasicNameValuePair("username", username));
        JSONObject json = jsonParser.getJSONFromUrl(chgpassURL, params);
        return json;
    }





    /**
     * Function to reset the password
     **/

    public JSONObject forPass(String forgotpassword){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("page", forpass_tag));
        params.add(new BasicNameValuePair("forgotpassword", forgotpassword));
        JSONObject json = jsonParser.getJSONFromUrl(forpassURL, params);
        return json;
    }
	
	
	
	/**
	 * function make Login Request
	 * @param name
	 * @param user
	 * @param password
	 * */
	public JSONObject registerUser(String universe, String username, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("page", sign_up_tag));
		params.add(new BasicNameValuePair("name", ""+universe));
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		
		// getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl(sign_up_URL, params);
		// return json
		return json;
	}
	
	/**
	 * Function get Login status
	 * */
	public boolean isUserLoggedIn(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		int count = db.getRowCount();
		if(count > 0){
			// user logged in
			return true;
		}
		return false;
	}
	
	/**
	 * Function to logout user
	 * Reset Database
	 * */
	public boolean logoutUser(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		db.resetTables();
		return true;
	}
	
}
