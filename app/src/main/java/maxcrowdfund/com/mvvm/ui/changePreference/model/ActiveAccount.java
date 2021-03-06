
package maxcrowdfund.com.mvvm.ui.changePreference.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveAccount {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("options")
    @Expose
    private List<Option_> options = null;
    @SerializedName("value")
    @Expose
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Option_> getOptions() {
        return options;
    }

    public void setOptions(List<Option_> options) {
        this.options = options;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
