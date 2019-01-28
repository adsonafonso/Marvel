package com.example.adsonafonso.marvel.ui;

import com.example.adsonafonso.marvel.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ComicActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comic);

		if(savedInstanceState == null) {
			ComicDetailFragment fragment = new ComicDetailFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, fragment, null)
					.commit();
		}
	}
}
