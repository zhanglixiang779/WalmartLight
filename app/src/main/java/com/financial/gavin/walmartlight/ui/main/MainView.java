package com.financial.gavin.walmartlight.ui.main;

import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.data.api.model.Product;
import com.financial.gavin.walmartlight.ui.base.BaseView;

/**
 * Created by gavin on 1/10/18.
 */

public interface MainView extends BaseView {
	void updateUI(Product product);
	void startDetailActivity(Item item);
}
