
package com.auxesis.maxcrowdfund.mvvm.ui.dashborad.pendingmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arrears365 {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("value")
    @Expose
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
