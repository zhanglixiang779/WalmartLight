package com.financial.gavin.walmartlight.data.api;

import android.util.Log;

import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.data.api.model.Product;
import com.financial.gavin.walmartlight.rx.RxManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gavin on 1/10/18.
 */

public class ApiHelper implements ApiHelperInterface, Callback<Product> {
	
	private static final String TAG = "ApiHelper";
	private Product product;
	private Item item;
	private ApiInterface apiInterface = RetrofitClient.getInstance().create(ApiInterface.class);;
	
	public ApiHelper() {
	}
	
	@Override
	public void search(String query, String format, String apiKey) {
		Call<Product> call = apiInterface.search(query, format, apiKey);
		call.enqueue(this);
	}
	
	@Override
	public void getItemDetail(long itemId, String format, String apiKey) {
		Call<Item> call = apiInterface.getItemDetail(itemId, format, apiKey);
		call.enqueue(new Callback<Item>() {
			@Override
			public void onResponse(Call<Item> call, Response<Item> response) {
				if (response.isSuccessful()) {
					item = response.body();
					RxManager.getInstance().post(item);
				}
			}
			
			@Override
			public void onFailure(Call<Item> call, Throwable t) {
			
			}
		});
	}
	
	@Override
	public void onResponse(Call<Product> call, Response<Product> response) {
		if (response.isSuccessful()) {
			product = response.body();
			RxManager.getInstance().post(product);
		}
		
		Log.d(TAG, "onResponse: " + response.errorBody());
	}
	
	@Override
	public void onFailure(Call<Product> call, Throwable t) {
		Log.d(TAG, "onFailure: " + t.getMessage());
	}
	
	@Override
	public Product getProduct() {
		return product;
	}
}
