package com.financial.gavin.walmartlight.ui.main;

import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.ui.base.BasePresenter;
import com.financial.gavin.walmartlight.ui.base.BasePresenterInterface;

/**
 * Created by gavin on 1/10/18.
 */

public class MainPresenter<V extends MainView> extends BasePresenter<V>
		implements MainPresenterInterface<V> {
	
	public MainPresenter(DataManagerInterface dataManager) {
		super(dataManager);
	}
	
	@Override
	public void search(String query, String format, String apiKey) {
		getDataManager().search(query, format, apiKey);
	}
	
	@Override
	public void getItemDetail(long itemId, String format, String apiKey) {
		getDataManager().getItemDetail(itemId, format, apiKey);
	}
	
	@Override
	public void startDetailActivity(Item item) {
		getView().startDetailActivity(item);
	}
}
