
package maxcrowdfund.com.mvvm.ui.dashborad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balance {

    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
