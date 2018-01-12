package com.financial.gavin.walmartlight.data;

import android.content.SharedPreferences;

import com.financial.gavin.walmartlight.data.api.ApiHelperInterface;
import com.financial.gavin.walmartlight.data.api.model.Product;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelper;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelperInterface;
import com.financial.gavin.walmartlight.ui.main.MainPresenterInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gavin on 1/10/18.
 */

public class DataManager implements DataManagerInterface {
	
	private PrefsHelperInterface mPrefsHelper;
	private ApiHelperInterface mApiHelper;
	private static DataManager instance;
	
	private DataManager(PrefsHelperInterface prefsHelper, ApiHelperInterface apiHelper) {
		this.mPrefsHelper = prefsHelper;
		this.mApiHelper = apiHelper;
	}
	
	public static synchronized DataManager getInstance(PrefsHelperInterface prefsHelper, ApiHelperInterface apiHelper) {
		if (instance == null) {
			instance = new DataManager(prefsHelper, apiHelper);
		}
		
		return instance;
	}
	
	@Override
	public void setEmail(String email) {
		mPrefsHelper.setEmail(email);
	}
	
	@Override
	public void setLoggedIn(boolean loggedIn) {
		mPrefsHelper.setLoggedIn(loggedIn);
	}
	
	@Override
	public boolean isLoggedIn() {
		return mPrefsHelper.isLoggedIn();
	}
	
	@Override
	public String getPassword() {
		return mPrefsHelper.getPassword();
	}
	
	@Override
	public void setPassword(String password) {
		mPrefsHelper.setPassword(password);
	}
	
	@Override
	public void clear() {
		mPrefsHelper.clear();
	}
	
	@Override
	public String getEmail() {
		return mPrefsHelper.getEmail();
	}
	
	@Override
	public void search(String query, String format, String apiKey) {
		mApiHelper.search(query, format, apiKey);
	}
	
	@Override
	public void getItemDetail(long itemId, String format, String apiKey) {
		mApiHelper.getItemDetail(itemId, format, apiKey);
	}
	
	@Override
	public Product getProduct() {
		return mApiHelper.getProduct();
	}
}
