package com.example.chitramitra;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Root {
    @SerializedName("dates")
    private Dates dates;
    @SerializedName("page")
    private Integer page;
    @SerializedName("results")
    private List<Result> results = new ArrayList<Result>();
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("total_results")
    private Integer totalResults;
    public Dates getDates() {
        return dates;
    }
    public void setDates(Dates dates) {
        this.dates = dates;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    public Integer getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
