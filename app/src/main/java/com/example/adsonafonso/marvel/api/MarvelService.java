package com.example.adsonafonso.marvel.api;

import com.example.adsonafonso.marvel.models.Comic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

	/**
	 * Retrieve comic by comic Id
	 */
	@GET("comics/{comicId}")
	Call<Comic> getComic(@Path("comicId") long comicId,
			@Query("apikey") String publicKey,
			@Query("hash") String md5Digest,
			@Query("ts") long timestamp);
}
