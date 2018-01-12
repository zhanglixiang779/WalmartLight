package com.financial.gavin.walmartlight.data.cashe;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by gavin on 1/10/18.
 */

public class PrefsHelper implements PrefsHelperInterface {
	
	private static final String FILE_NAME = "WALMART_LIGHT";
	private static final String EMAIL = "EMAIL";
	private static final String PASSWORD = "PASSWORD";
	private static final String IS_LOGGED_IN = "IS_LOGGED_IN";
	private SharedPreferences mSharedPreferences;
	
	public PrefsHelper(Context context) {
		mSharedPreferences = context.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
	}
	
	public void setEmail(String email) {
		mSharedPreferences.edit().putString(EMAIL, email).apply();
	}
	
	public String getEmail() {
		return mSharedPreferences.getString(EMAIL, null);
	}
	
	@Override
	public void setPassword(String password) {
		mSharedPreferences.edit().putString(PASSWORD, password).apply();
	}
	
	@Override
	public String getPassword() {
		return mSharedPreferences.getString(PASSWORD, null);
	}
	
	public void clear() {
		mSharedPreferences.edit().clear().apply();
	}
	
	public boolean isLoggedIn() {
		return mSharedPreferences.getBoolean(IS_LOGGED_IN, false);
	}
	
	public void setLoggedIn(boolean loggedIn) {
		mSharedPreferences.edit().putBoolean(IS_LOGGED_IN, loggedIn).apply();
	}
}




