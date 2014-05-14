package com.example.andreastestapp;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
	
	
	Spinner userspinner;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem(true)); // adding a spinner to the list

		dataList.add(new DrawerItem("My Favorites")); // adding a header to the list
		dataList.add(new DrawerItem("Profil", R.drawable.ic_action_group));
		dataList.add(new DrawerItem("Articles", R.drawable.ic_action_email));
		dataList.add(new DrawerItem("Likes", R.drawable.ic_action_good));
		dataList.add(new DrawerItem("Games", R.drawable.ic_action_gamepad));
		dataList.add(new DrawerItem("Lables", R.drawable.ic_action_labels));

		dataList.add(new DrawerItem("Main Options"));// adding a header to the list
		dataList.add(new DrawerItem("Search", R.drawable.ic_action_search));
		dataList.add(new DrawerItem("Cloud", R.drawable.ic_action_cloud));
		dataList.add(new DrawerItem("Camara", R.drawable.ic_action_camera));
		dataList.add(new DrawerItem("Video", R.drawable.ic_action_video));
		dataList.add(new DrawerItem("Groups", R.drawable.ic_action_group));
		dataList.add(new DrawerItem("Import & Export",
				R.drawable.ic_action_import_export));

		 dataList.add(new DrawerItem("Other Option")); // adding a header to the list
		dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
		dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
		dataList.add(new DrawerItem("Help", R.drawable.ic_action_help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);
		
		
		
		

		mDrawerList.setAdapter(adapter);
		// add user
		

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			if (dataList.get(0).isSpinner()
					& dataList.get(1).getTitle() != null) {
				SelectItem(2);
			} else if (dataList.get(0).getTitle() != null) {
				SelectItem(1);
			} else {
				SelectItem(0);
			}
		}
		
		//addUser();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {

		case 2:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 3:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 4:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 5:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 7:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 8:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 9:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 10:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 11:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 12:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 14:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;	
		case 15:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 16:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (dataList.get(position).getTitle() == null) {
				SelectItem(position);
			}

		}
	}
	
	
	public void addUser(String username, String email){
		//adapter.addUser("test", "test@test.de");
		userspinner = (Spinner) adapter.view.findViewById(R.id.drawerSpinner);
		adapter.userList.add(new SpinnerItem(R.drawable.user1, username, email));
		CustomSpinnerAdapter new_adapter = new CustomSpinnerAdapter(adapter.context,
				R.layout.custom_spinner_item, adapter.userList);
		
		userspinner.setAdapter(new_adapter);
		
		/*CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(context,
				R.layout.custom_spinner_item, userList);

		drawerHolder.spinner.setAdapter(adapter);*/
		//mDrawerList.refreshDrawableState();
	}
	
	
	 private class NetCheck extends AsyncTask<String,String,Boolean>
	    {
	        private ProgressDialog nDialog;

	        @Override
	        protected void onPreExecute(){
	            super.onPreExecute();
	            nDialog = new ProgressDialog(LoginActivity.this);
	            nDialog.setTitle("Checking Network");
	            nDialog.setMessage("Loading...");
	            nDialog.setIndeterminate(false);
	            nDialog.setCancelable(true);
	            nDialog.show();
	        }
	        /**
	         * Gets current device state and checks for working internet connection by trying Google.
	        **/
	        @Override
	        protected Boolean doInBackground(String... args){



	            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	            NetworkInfo netInfo = cm.getActiveNetworkInfo();
	            if (netInfo != null && netInfo.isConnected()) {
	                try {
	                    URL url = new URL("http://www.google.com");
	                    HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
	                    urlc.setConnectTimeout(3000);
	                    urlc.connect();
	                    if (urlc.getResponseCode() == 200) {
	                        return true;
	                    }
	                } catch (MalformedURLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	            return false;

	        }
	        @Override
	        protected void onPostExecute(Boolean th){

	            if(th == true){
	                nDialog.dismiss();
	                new ProcessLogin().execute();
	            }
	            else{
	                nDialog.dismiss();
	                loginErrorMsg.setText("Error in Network Connection");
	            }
	        }
	    }

	    /**
	     * Async Task to get and send data to My Sql database through JSON respone.
	     **/
	    private class ProcessLogin extends AsyncTask<String, String, JSONObject> {


	        private ProgressDialog pDialog;

	        String username,password;

	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();

	            inputUser = (EditText) findViewById(R.id.loginUser);
	            inputPassword = (EditText) findViewById(R.id.loginPassword);
	            username = inputUser.getText().toString();
	            password = inputPassword.getText().toString();
	            pDialog = new ProgressDialog(LoginActivity.this);
	            pDialog.setTitle("Contacting Servers");
	            pDialog.setMessage("Logging in ...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }

	        @Override
	        protected JSONObject doInBackground(String... args) {

	            UserFunctions userFunction = new UserFunctions();
	            JSONObject json = userFunction.loginUser(username, password);
	            return json;
	        }

	        @Override
	        protected void onPostExecute(JSONObject json) {
	            try {
	               if (json.getString(KEY_SUCCESS) != null) {

	                    String res = json.getString(KEY_SUCCESS);

	                    if(Integer.parseInt(res) == 1){
	                        pDialog.setMessage("Loading User Space");
	                        pDialog.setTitle("Getting Data");
	                        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
	                        
	                        Intent upanel = new Intent(getApplicationContext(), MainActivity.class);
	                        JSONArray json_user = json.getJSONArray("login");
	                        /**
	                         * Clear all previous data in SQlite database.
	                         **/
	                        UserFunctions logout = new UserFunctions();
	                        logout.logoutUser(getApplicationContext());
	                        db.addUser(json_user.getJSONObject(0).getString(KEY_EMAIL),json_user.getJSONObject(0).getString(KEY_USERNAME),json_user.getJSONObject(0).getString(KEY_UID),json_user.getJSONObject(0).getString(KEY_CREATED_AT));
	                       /**
	                        *If JSON array details are stored in SQlite it launches the User Panel.
	                        **/
	                        
	                        upanel.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	                        upanel.putExtra("Username", json_user.getJSONObject(0).getString(KEY_USERNAME));
	                        upanel.putExtra("Uid", json_user.getJSONObject(0).getInt(KEY_UID));
	                        pDialog.dismiss();
	                        startActivity(upanel);
	                        /**
	                         * Close Login Screen
	                         **/
	                        finish();
	                    }else{

	                        pDialog.dismiss();
	                        loginErrorMsg.setText("Incorrect username/password");
	                    }
	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	       }
	    }
	    public void NetAsync(View view){
	        new NetCheck().execute();
	    }

}

