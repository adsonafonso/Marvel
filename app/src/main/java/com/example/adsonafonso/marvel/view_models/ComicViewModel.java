package com.example.adsonafonso.marvel.view_models;

import com.example.adsonafonso.marvel.models.ComicResult;
import com.example.adsonafonso.marvel.repositories.ComicRepository;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

public class ComicViewModel extends AndroidViewModel {

	private LiveData<ComicResult> comic;
	private ComicRepository mComicRepository;

	public ComicViewModel(@NonNull Application application) {
		super(application);
		this.mComicRepository = new ComicRepository(application);
	}

	public void init(long comicId){
		if (this.comic != null) {
			return;
		}
		comic = mComicRepository.getComic(comicId);
	}

	public LiveData<ComicResult> getComic() {
		return comic;
	}
}
