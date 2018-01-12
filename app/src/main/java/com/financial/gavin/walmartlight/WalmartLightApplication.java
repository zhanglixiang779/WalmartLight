package com.financial.gavin.walmartlight;

import android.app.Application;

import com.financial.gavin.walmartlight.data.DataManager;
import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.data.api.ApiHelper;
import com.financial.gavin.walmartlight.data.api.ApiHelperInterface;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelper;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelperInterface;


/**
 * Created by gavin on 1/10/18.
 */

public class WalmartLightApplication extends Application {
	
	private static DataManagerInterface mDataManager;
	private PrefsHelperInterface mPrefsHelper;
	private ApiHelperInterface apiHelper;
	private static Application instance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
		mPrefsHelper = new PrefsHelper(this);
		apiHelper = new ApiHelper();
		mDataManager = DataManager.getInstance(mPrefsHelper, apiHelper);
	}
	
	public static Application getInstance() {
		return instance;
	}
	
	public static DataManagerInterface getDataManager() {
		return mDataManager;
	}
}
