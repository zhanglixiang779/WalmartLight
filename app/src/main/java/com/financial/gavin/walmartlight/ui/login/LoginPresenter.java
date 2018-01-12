package com.financial.gavin.walmartlight.ui.login;

import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.ui.base.BasePresenter;

/**
 * Created by gavin on 1/10/18.
 */

public class LoginPresenter<V extends LoginView> extends BasePresenter<V> implements LoginPresenterInterface<V> {
	
	public LoginPresenter(DataManagerInterface dataManager) {
		super(dataManager);
	}
	
	@Override
	public void initLogin(String username, String password) {
		getDataManager().setEmail(username);
		getDataManager().setPassword(password);
		getDataManager().setLoggedIn(true);
		getView().startMainActivity();
	}
	
	@Override
	public void initLogout() {
		getDataManager().clear();
		getDataManager().setLoggedIn(false);
	}
}
