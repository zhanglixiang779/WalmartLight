package com.financial.gavin.walmartlight.ui.main.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.financial.gavin.walmartlight.R;
import com.financial.gavin.walmartlight.data.api.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gavin on 1/11/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
	private List<Item> items;
	private Context context;
	private OnItemClickListener mListener;
	
	public interface OnItemClickListener {
		void onClick(View view, int position);
	}
	
	public CustomAdapter(List<Item> items, OnItemClickListener listener) {
		this.items = items;
		mListener = listener;
	}
	
	class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		private TextView price;
		private TextView name;
		private ImageView thumnailImage;
		
		 ViewHolder(View itemView) {
			super(itemView);
			price = itemView.findViewById(R.id.price_tv);
			name = itemView.findViewById(R.id.name_tv);
			thumnailImage = itemView.findViewById(R.id.thumnail_iv);
			itemView.setOnClickListener(this);
		}
		
		@Override
		public void onClick(View v) {
			mListener.onClick(v, getAdapterPosition());
		}
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.list_view, parent, false);
		context = parent.getContext();
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.price.setText(String.valueOf(items.get(position).getSalePrice()));
		holder.name.setText(items.get(position).getName());
		Picasso.with(context).load(items.get(position).getThumbnailImage()).into(holder.thumnailImage);
	}
	
	@Override
	public int getItemCount() {
		return items.size();
	}
}
