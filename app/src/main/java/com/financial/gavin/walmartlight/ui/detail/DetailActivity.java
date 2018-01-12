package com.financial.gavin.walmartlight.ui.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.financial.gavin.walmartlight.R;
import com.financial.gavin.walmartlight.data.api.model.Item;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
	
	private Item mItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Intent intent = getIntent();
		mItem = intent.getParcelableExtra("item");
		
		ImageView itemImage = findViewById(R.id.product_image_iv);
		TextView itemName = findViewById(R.id.product_name_tv);
		TextView itemDescription = findViewById(R.id.product_description_tv);
		itemDescription.setMovementMethod(new ScrollingMovementMethod());
		
		
		Picasso.with(this).load(mItem.getLargeImage()).into(itemImage);
		itemName.setText(mItem.getName());
		itemDescription.setText(Html.fromHtml(mItem.getLongDescription()));
	}
}
