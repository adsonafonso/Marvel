package com.example.adsonafonso.marvel.database;

import com.example.adsonafonso.marvel.models.ComicResult;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {ComicResult.class}, version = 1)
@TypeConverters(ThumbnailConverter.class)
public abstract class ComicDatabase extends RoomDatabase {
	public abstract ComicDao mComicDao();

	private static ComicDatabase INSTANCE;

	/**
	 * Make it a singleton to prevent having multiple instances of the database opened
	 * @param context
	 * @return
	 */
	public static ComicDatabase getDatabase(final Context context) {
		if(INSTANCE == null) {
			synchronized ((ComicDatabase.class)) {
				if(INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
							ComicDatabase.class, "comic_database")
							.build();
				}
			}
		}
		return INSTANCE;
	}
}
