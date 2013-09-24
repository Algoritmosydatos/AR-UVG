package com.uvg.parse;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.uvg.ar.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class ParseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Parse.initialize(this, "App Id" , "Client Key");
		
		if(ParseUser.getCurrentUser() == null){
			ParseFacebookUtils.logIn(this, new LogInCallback() {
				
				@Override
				public void done(ParseUser user, ParseException err) {
					// TODO Auto-generated method stub
					if (user == null) {
					      Log.d("MyApp", "Facebook login cancelled.");
					    } else if (user.isNew()) {
					      Log.d("MyApp", "User signed up and logged in through Facebook!");
					    } else {
					      Log.d("MyApp", "User logged in through Facebook!");
					    }
				}
			});
		}
		
		ParseInstallation.getCurrentInstallation().saveInBackground();
		
		// Saving the device's owner
		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		installation.put("owner",ParseUser.getCurrentUser());
		installation.saveInBackground();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void logOutUser(){
		ParseUser.logOut();
	}
}
