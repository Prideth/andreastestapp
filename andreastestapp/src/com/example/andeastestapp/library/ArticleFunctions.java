
package com.example.andeastestapp.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class ArticleFunctions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7609258453037447280L;

	private JSONParser jsonParser;
	
	private static String articleURL = "http://dlxg.pf-control.de/prideth/GalaxyWars/index_android.php";

	//private static String login_tag = "login";

	
	// constructor
	public ArticleFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * function make Login Request 
	 * @param username
	 * @param password
	 * */
	public JSONObject loginUser(String username, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair("page", login_tag));
		//params.add(new BasicNameValuePair("username", username));
		//params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl(articleURL, params);
		// return json
		 Log.e("JSON", json.toString());
		return json;
	}
	
	
}
