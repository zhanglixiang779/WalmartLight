package com.financial.gavin.walmartlight.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.financial.gavin.walmartlight.R;
import com.financial.gavin.walmartlight.WalmartLightApplication;
import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.ui.base.BaseActivity;
import com.financial.gavin.walmartlight.ui.login.LoginActivity;
import com.financial.gavin.walmartlight.ui.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashView {
	
	SplashPresenterInterface<SplashView> mSplashPresenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		DataManagerInterface dataManager = WalmartLightApplication.getDataManager();
		mSplashPresenter = new SplashPresenter<>(dataManager);
		mSplashPresenter.onAttach(this);
		mSplashPresenter.loginOrMain();
		
	}
	
	@Override
	public void startLoginActivity() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void startMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
