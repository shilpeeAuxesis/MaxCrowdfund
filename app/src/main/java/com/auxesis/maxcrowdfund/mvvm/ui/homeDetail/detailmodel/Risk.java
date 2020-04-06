
package com.auxesis.maxcrowdfund.mvvm.ui.homeDetail.detailmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Risk {

    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("data")
    @Expose
    private List<Datum_____> data = null;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public List<Datum_____> getData() {
        return data;
    }

    public void setData(List<Datum_____> data) {
        this.data = data;
    }

}
