package com.financial.gavin.walmartlight.data.api;

import com.financial.gavin.walmartlight.data.api.model.Product;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by gavin on 1/10/18.
 */

public interface ApiHelperInterface {
	void search(String query, String format, String apiKey);
	void getItemDetail(long itemId, String format, String apiKey);
	Product getProduct();
}
