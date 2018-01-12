package com.financial.gavin.walmartlight.ui.base;

import com.financial.gavin.walmartlight.data.DataManager;
import com.financial.gavin.walmartlight.data.DataManagerInterface;

/**
 * Created by gavin on 1/10/18.
 */

public class BasePresenter<V extends BaseView> implements BasePresenterInterface<V> {
	
	private DataManagerInterface mDataManager;
	private V mView;
	
	
	public BasePresenter(DataManagerInterface dataManager) {
		mDataManager = dataManager;
	}
	
	@Override
	public void onAttach(V view) {
		mView = view;
	}
	
	public V getView() {
		return mView;
	}
	
	public DataManagerInterface getDataManager() {
		return mDataManager;
	}
}
