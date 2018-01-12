package com.financial.gavin.walmartlight.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.financial.gavin.walmartlight.R;
import com.financial.gavin.walmartlight.data.DataManager;
import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.data.api.ApiHelper;
import com.financial.gavin.walmartlight.data.api.ApiHelperInterface;
import com.financial.gavin.walmartlight.data.api.model.Item;
import com.financial.gavin.walmartlight.data.api.model.Product;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelper;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelperInterface;
import com.financial.gavin.walmartlight.rx.RxManager;
import com.financial.gavin.walmartlight.ui.base.BaseActivity;
import com.financial.gavin.walmartlight.ui.detail.DetailActivity;
import com.financial.gavin.walmartlight.ui.main.recyclerview.CustomAdapter;

import io.reactivex.observers.DisposableObserver;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {
	
	private EditText searchEditText;
	private TextView resultTextView;
	private Button searchButton;
	private RecyclerView recyclerView;
	private RecyclerView.LayoutManager layoutManager;
	private MainPresenterInterface mMainPresenter;
	private static final String TAG = "MainActivity";
	private static final String API_KEY = "64z6ne4k5t87e6sjaevwgce2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PrefsHelperInterface prefsHelper = new PrefsHelper(this);
		ApiHelperInterface apiHelper = new ApiHelper();
		DataManagerInterface dataManager = DataManager.getInstance(prefsHelper, apiHelper);
		mMainPresenter = new MainPresenter(dataManager);
		mMainPresenter.onAttach(this);
		searchEditText = findViewById(R.id.search_et);
		resultTextView = findViewById(R.id.result_tv);
		recyclerView = findViewById(R.id.recyclerview);
		layoutManager = new LinearLayoutManager(this);
		searchButton = findViewById(R.id.search_btn);
		searchButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		RxManager.getInstance().setObserver(getProductObserver());
		String query = searchEditText.getText().toString();
		mMainPresenter.search(query, "json", API_KEY);
	}
	
	public DisposableObserver<Product> getProductObserver() {
		return new DisposableObserver<Product>() {
			@Override
			public void onNext(Product product) {
				Log.d(TAG, "onNext: " + product);
				updateUI(product);
			}
			
			@Override
			public void onError(Throwable e) {
			
			}
			
			@Override
			public void onComplete() {
			
			}
		};
	}
	
	public DisposableObserver<Item> getItemObserver() {
		return new DisposableObserver<Item>() {
			@Override
			public void onNext(Item item) {
				mMainPresenter.startDetailActivity(item);
			}
			
			@Override
			public void onError(Throwable e) {
			
			}
			
			@Override
			public void onComplete() {
			
			}
		};
	}
	
	@Override
	public void updateUI(final Product product) {
		String result = String.valueOf(product.getNumItems()) + " items have been found!";
		resultTextView.setText(result);
		CustomAdapter adapter = new CustomAdapter(product.getItems(), new CustomAdapter.OnItemClickListener() {
			@Override
			public void onClick(View view, int position) {
				mMainPresenter.getItemDetail(product.getItems().get(position).getItemId(), "json", API_KEY);
				RxManager.getInstance().setObserver(getItemObserver());
			}
		});
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
	}
	
	@Override
	public void startDetailActivity(Item item) {
		Intent intent = new Intent(this, DetailActivity.class);
		intent.putExtra("item", item);
		startActivity(intent);
	}
}
