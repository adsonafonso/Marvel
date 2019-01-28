package com.example.adsonafonso.marvel;

import com.example.adsonafonso.marvel.database.ComicDao;
import com.example.adsonafonso.marvel.database.ComicDatabase;
import com.example.adsonafonso.marvel.models.ComicResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class RoomDatabaseTesting {
	private ComicDao mComicDao;
	private ComicDatabase mDb;
	private ComicResult mComicResult;

	@Before
	public void createDb() {
		mDb = ComicDatabase.getDatabase(InstrumentationRegistry.getTargetContext());
		mComicDao = mDb.mComicDao()	;
	}

	@After
	public void closeDb() throws IOException {
		mDb.close();
	}

	@Test
	public void basics() {

		mComicDao.deleteAll();

		//check to see if Database is empty
		List<ComicResult> results = mComicDao.loadComics();
		assertEquals(0, mComicDao.loadComics().size());

		// check to see if comic is saved to DB
		ComicResult comic = new ComicResult(3, 0, "superman", 2,
		"", "", "", "", "",
				"", "", 0, "",
				null);

		mComicDao.save(comic);

		assertEquals(1, mComicDao.loadComics().size());

		//check to see if DB has comic with ID 3
		ComicResult comicTest = mComicDao.hasComic(3);
		assertNotNull(comicTest);

	}

}