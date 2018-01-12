package com.financial.gavin.walmartlight.ui.detail;

import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.ui.base.BasePresenter;

/**
 * Created by gavin on 1/11/18.
 */

public class DetailPresenter<V extends DetailView> extends BasePresenter<V> implements DetailPresenterInterface<V> {
	
	public DetailPresenter(DataManagerInterface dataManager) {
		super(dataManager);
	}
	
}
