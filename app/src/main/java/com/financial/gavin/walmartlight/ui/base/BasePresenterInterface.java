package com.financial.gavin.walmartlight.ui.base;

/**
 * Created by gavin on 1/10/18.
 */

public interface BasePresenterInterface<V extends BaseView> {
	
	void onAttach(V baseView);
	
}