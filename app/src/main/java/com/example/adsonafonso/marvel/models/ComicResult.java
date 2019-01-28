
package com.example.adsonafonso.marvel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.adsonafonso.marvel.database.ThumbnailConverter;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

@Entity(tableName = "comics")
public class ComicResult {
	@PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("digitalId")
    @Expose
    private int digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private int issueNumber;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private int pageCount;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("thumbnail")
    @Expose
	@TypeConverters(ThumbnailConverter.class)
    private Thumbnail thumbnail;
    @Ignore
    @SerializedName("creators")
    @Expose
    private Creators creators;

	public ComicResult(int id, int digitalId, String title, int issueNumber,
			String description, String modified, String isbn, String upc, String ean,
			String issn, String format, int pageCount, String resourceURI,
			Thumbnail thumbnail) {
		this.id = id;
		this.digitalId = digitalId;
		this.title = title;
		this.issueNumber = issueNumber;
		this.description = description;
		this.modified = modified;
		this.isbn = isbn;
		this.upc = upc;
		this.ean = ean;
		this.issn = issn;
		this.format = format;
		this.pageCount = pageCount;
		this.resourceURI = resourceURI;
		this.thumbnail = thumbnail;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

}
