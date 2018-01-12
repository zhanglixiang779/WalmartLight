package com.financial.gavin.walmartlight.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gavin on 1/10/18.
 */

public class RetrofitClient {
	
	private static final String BASE_URL = "http://api.walmartlabs.com/v1/";
	private static Retrofit instance;
	
	private RetrofitClient() {
	
	}
	
	public static synchronized Retrofit getInstance() {
		if (instance == null) {
			instance = new Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create(getGson()))
					.build();
		}
		
		return instance;
	}
	
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create(getGson()))
			.build();
	
	private static Gson getGson() {
		return new GsonBuilder()
				.setLenient()
				.create();
	}
}
