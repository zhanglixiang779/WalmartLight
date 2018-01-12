package com.financial.gavin.walmartlight.ui.login;

import com.financial.gavin.walmartlight.ui.base.BasePresenterInterface;

/**
 * Created by gavin on 1/10/18.
 */

public interface LoginPresenterInterface<V extends LoginView> extends BasePresenterInterface<V>{
	void initLogin(String username, String password);
	void initLogout();
}

