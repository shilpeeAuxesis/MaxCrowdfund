
package com.auxesis.maxcrowdfund.mvvm.ui.home.homeDetail.funddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum_______ {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
