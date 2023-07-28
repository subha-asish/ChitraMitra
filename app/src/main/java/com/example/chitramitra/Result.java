package com.example.chitramitra;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Result {
    @SerializedName("adult")
    private boolean adult;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("id")
    private int id;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("title")
    private String title;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    public Boolean getAdult() {
        return adult;
    }
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
    public String getBackdropPath() {
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
    public List<Integer> getGenreIds() {
        return genreIds;
    }
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public Double getPopularity() {
        return popularity;
    }
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getVideo() {
        return video;
    }
    public void setVideo(Boolean video) {
        this.video = video;
    }
    public Double getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
    public Integer getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
