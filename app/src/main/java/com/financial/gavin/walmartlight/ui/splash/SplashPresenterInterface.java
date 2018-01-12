package com.financial.gavin.walmartlight.ui.splash;

import com.financial.gavin.walmartlight.ui.base.BasePresenterInterface;

/**
 * Created by gavin on 1/10/18.
 */

public interface SplashPresenterInterface<V extends SplashView> extends BasePresenterInterface<V> {
	void loginOrMain();
}
