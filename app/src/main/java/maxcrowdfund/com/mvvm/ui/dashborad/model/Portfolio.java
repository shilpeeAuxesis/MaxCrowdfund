
package maxcrowdfund.com.mvvm.ui.dashborad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Portfolio {

    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("data")
    @Expose
    private Data_ data;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

}
