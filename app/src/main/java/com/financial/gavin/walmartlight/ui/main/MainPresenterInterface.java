package com.financial.gavin.walmartlight.ui.main;

import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.ui.base.BasePresenterInterface;

/**
 * Created by gavin on 1/10/18.
 */

public interface MainPresenterInterface<V extends MainView> extends BasePresenterInterface<V> {
	void search(String query, String format, String apiKey);
	void getItemDetail(long itemId, String format, String apiKey);
	void startDetailActivity(Item item);
}
