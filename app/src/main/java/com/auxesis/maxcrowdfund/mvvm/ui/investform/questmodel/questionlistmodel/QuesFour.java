
package com.auxesis.maxcrowdfund.mvvm.ui.investform.questmodel.questionlistmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuesFour {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("option")
    @Expose
    private Option___ option;
    @SerializedName("warning")
    @Expose
    private String warning;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Option___ getOption() {
        return option;
    }

    public void setOption(Option___ option) {
        this.option = option;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

}
