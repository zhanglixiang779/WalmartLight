package com.financial.gavin.walmartlight.data.cashe;

/**
 * Created by gavin on 1/10/18.
 */

public interface PrefsHelperInterface {
	
	void setEmail(String email);
	void setLoggedIn(boolean loggedIn);
	void setPassword(String password);
	void clear();
	String getEmail();
	String getPassword();
	boolean isLoggedIn();
	
}
