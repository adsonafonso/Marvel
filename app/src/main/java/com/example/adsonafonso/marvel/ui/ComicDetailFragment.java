package com.example.adsonafonso.marvel.ui;

import com.bumptech.glide.Glide;
import com.example.adsonafonso.marvel.R;
import com.example.adsonafonso.marvel.view_models.ComicViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ComicDetailFragment extends Fragment{

	private ComicViewModel viewModel;
	private ImageView thumbnailImage;
	private TextView titleText, descriptionText;
	private ProgressBar progressBar;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.comic_detail, container, false);
		thumbnailImage = v.findViewById(R.id.thumbnailImg);
		titleText = v.findViewById(R.id.titleText);
		descriptionText = v.findViewById(R.id.detailText);
		progressBar = v.findViewById(R.id.progressBar);
		return v;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		viewModel = ViewModelProviders.of(this).get(ComicViewModel.class);
		viewModel.init(1000);
		viewModel.getComic().observe(this, comicResult-> {
			if (comicResult!= null) {
				progressBar.setVisibility(View.GONE);
				titleText.setVisibility(View.VISIBLE);
				descriptionText.setVisibility(View.VISIBLE);
				thumbnailImage.setVisibility(View.VISIBLE);
				titleText.setText(comicResult.getTitle());
				descriptionText.setText(comicResult.getDescription());
				Glide.with(this).load(comicResult.getThumbnail().buildCompleteImagePath()).into(thumbnailImage);
			}
		});
	}

}
