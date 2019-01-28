package com.example.adsonafonso.marvel.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelClient {

	public static final String MARVEL_URL = "https://gateway.marvel.com/v1/public/";

	private static Retrofit sRetrofit = null;

	public static Retrofit getRetrofit(){
		if(sRetrofit == null) {
			sRetrofit = new Retrofit.Builder()
					.addConverterFactory(GsonConverterFactory.create())
					.baseUrl(MARVEL_URL)
					.build();
		}
		return sRetrofit;
	}

}
