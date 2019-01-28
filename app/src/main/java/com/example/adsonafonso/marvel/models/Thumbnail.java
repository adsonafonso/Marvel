package com.example.adsonafonso.marvel.models;

import com.google.gson.annotations.SerializedName;

public class Thumbnail {
	@SerializedName("path")
	private String mPath;
	@SerializedName("extension")
	private String mExtension;

	public Thumbnail(String path, String extension) {
		this.mPath = path;
		this.mExtension = extension;
	}

	public String buildCompleteImagePath() {
		return mPath + "." + mExtension;
	}

	public String getPath() {
		return mPath;
	}

	public void setPath(String path) {
		mPath = path;
	}

	public String getExtension() {
		return mExtension;
	}

	public void setExtension(String extension) {
		mExtension = extension;
	}
}
