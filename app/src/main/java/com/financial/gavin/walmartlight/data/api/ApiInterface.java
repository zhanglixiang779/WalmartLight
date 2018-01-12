package com.financial.gavin.walmartlight.data.api;

import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.data.api.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gavin on 1/10/18.
 */

public interface ApiInterface {
	
	@GET("search/")
	Call<Product> search(@Query("query") String queryName, @Query("format") String format, @Query("apiKey") String apiKey);
	
	@GET("items/{id}")
	Call<Item> getItemDetail(@Path("id") long id, @Query("format") String format, @Query("apiKey") String apiKey);
	
}
