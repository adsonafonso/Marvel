package com.example.adsonafonso.marvel.database;

import com.example.adsonafonso.marvel.models.ComicResult;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ComicDao {
	@Insert(onConflict =  REPLACE)
	void save(ComicResult comicResult);

	@Query("SELECT * FROM comics WHERE id = :comicId")
	LiveData<ComicResult> load(long comicId);

	@Query("SELECT * FROM comics WHERE id = :comicId")
	ComicResult hasComic(long comicId);

	@Query("SELECT * FROM comics")
	List<ComicResult> loadComics();

	@Query("DELETE FROM comics")
	void deleteAll();
}
