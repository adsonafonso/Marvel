package com.example.adsonafonso.marvel.database;

import com.example.adsonafonso.marvel.models.Thumbnail;

import android.arch.persistence.room.TypeConverter;

public class ThumbnailConverter {
	@TypeConverter
	public static Thumbnail toThumbnail(String completeImagePath) {
		if(completeImagePath == null || completeImagePath.isEmpty()){
			return null;
		}
		int index = completeImagePath.lastIndexOf('.');
		return new Thumbnail(completeImagePath.substring(0,index), completeImagePath.substring(index+1));
	}

	@TypeConverter
	public static String fromThumbnail(Thumbnail thumb) {
		return (thumb!=null ? thumb.buildCompleteImagePath() : null);
	}
}
