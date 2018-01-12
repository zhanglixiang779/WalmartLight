package com.financial.gavin.walmartlight.data.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gavin on 1/10/18.
 */

public class Item implements Parcelable {
	
	@SerializedName("itemId")
	@Expose
	private Long itemId;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("thumbnailImage")
	@Expose
	private String thumbnailImage;
	
	@SerializedName("largeImage")
	@Expose
	private String largeImage;
	
	@SerializedName("salePrice")
	@Expose
	private double salePrice;
	
	@SerializedName("longDescription")
	@Expose
	private String longDescription;
	
	public Item(Long itemId, String name, String thumbnailImage, String largeImage, double salePrice, String longDescription) {
		this.itemId = itemId;
		this.name = name;
		this.thumbnailImage = thumbnailImage;
		this.largeImage = largeImage;
		this.salePrice = salePrice;
		this.longDescription = longDescription;
	}
	
	public Long getItemId() {
		return itemId;
	}
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getThumbnailImage() {
		return thumbnailImage;
	}
	
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	
	public String getLargeImage() {
		return largeImage;
	}
	
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.itemId);
		dest.writeString(this.name);
		dest.writeString(this.thumbnailImage);
		dest.writeString(this.largeImage);
		dest.writeDouble(this.salePrice);
		dest.writeString(this.longDescription);
	}
	
	protected Item(Parcel in) {
		this.itemId = (Long) in.readValue(Long.class.getClassLoader());
		this.name = in.readString();
		this.thumbnailImage = in.readString();
		this.largeImage = in.readString();
		this.salePrice = in.readDouble();
		this.longDescription = in.readString();
	}
	
	public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
		@Override
		public Item createFromParcel(Parcel source) {
			return new Item(source);
		}
		
		@Override
		public Item[] newArray(int size) {
			return new Item[size];
		}
	};
}
