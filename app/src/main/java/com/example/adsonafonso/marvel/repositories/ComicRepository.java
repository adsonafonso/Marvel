package com.example.adsonafonso.marvel.repositories;

import com.example.adsonafonso.marvel.BuildConfig;
import com.example.adsonafonso.marvel.api.MarvelClient;
import com.example.adsonafonso.marvel.api.MarvelService;
import com.example.adsonafonso.marvel.database.ComicDao;
import com.example.adsonafonso.marvel.database.ComicDatabase;
import com.example.adsonafonso.marvel.models.Comic;
import com.example.adsonafonso.marvel.models.ComicResult;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicRepository {

	private static final String TAG_COMIC_REPOSITORY= "TAG_COMIC_REPOSITORY";
	private MarvelService mMarvelService;
	private ComicDatabase db;
	private ComicDao comicDao;
	private Executor mExecutor;

	public ComicRepository(Application application) {
		mMarvelService = new MarvelClient().getRetrofit().create(MarvelService.class);
		db = ComicDatabase.getDatabase(application);
		this.comicDao = db.mComicDao();
		this.mExecutor = Executors.newSingleThreadExecutor();
	}

	public LiveData<ComicResult> getComic(long comicId) {
		long timeStamp = System.currentTimeMillis();
		mExecutor.execute(() -> {
			//check if comic is already stored in the DB
			boolean comicExists = (comicDao.hasComic(comicId)!= null );
			if(!comicExists) {
				mMarvelService.getComic(comicId, BuildConfig.pubKey, buildMd5AuthParameter(timeStamp), timeStamp).enqueue(new Callback<Comic>() {
					@Override
					public void onResponse(Call<Comic> call, Response<Comic> response) {
						if(response.isSuccessful()) {
							Log.d(TAG_COMIC_REPOSITORY, "successfull response" + response.body());
							mExecutor.execute(() -> {
								ComicResult comicResult = response.body().getData().getComicResults().get(0);
								comicDao.save(comicResult);
							});
						}
					}

					@Override
					public void onFailure(Call<Comic> call, Throwable t) {
						Log.d(TAG_COMIC_REPOSITORY, "failed response" + t.toString());
					}
				});
			}
		});
		return comicDao.load(comicId);
	}

	/**
	 * Builds the required API "hash" parameter (timeStamp + privateKey + publicKey)
	 *
	 * @param timeStamp Current timeStamp
	 * @return MD5 hash string
	 */
	private static String buildMd5AuthParameter(long timeStamp) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest((timeStamp + BuildConfig.privateKey
					+ BuildConfig.pubKey).getBytes());
			BigInteger number = new BigInteger(1, messageDigest);

			String md5 = number.toString(16);
			while (md5.length() < 32) {
				md5 = 0 + md5;
			}
			return md5;

		} catch (NoSuchAlgorithmException e) {
			Log.d(TAG_COMIC_REPOSITORY, e.getMessage());
			return "";
		}
	}
}
