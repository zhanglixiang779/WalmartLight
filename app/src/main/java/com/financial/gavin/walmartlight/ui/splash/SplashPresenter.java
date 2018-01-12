package com.financial.gavin.walmartlight.ui.splash;

import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.ui.base.BasePresenter;
import com.financial.gavin.walmartlight.ui.base.BaseView;

/**
 * Created by gavin on 1/10/18.
 */

public class SplashPresenter<V extends SplashView> extends BasePresenter<V>
									implements SplashPresenterInterface<V> {
	
	public SplashPresenter(DataManagerInterface dataManager) {
		super(dataManager);
	}
	
	@Override
	public void loginOrMain() {
		boolean isLoggedIn = getDataManager().isLoggedIn();
		if (!isLoggedIn) {
			getView().startLoginActivity();
		} else {
			getView().startMainActivity();
		}
	}
}
