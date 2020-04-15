
package com.auxesis.maxcrowdfund.mvvm.ui.investform.questmodel.questionlistmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvestSurveyRuestionResponse {

    @SerializedName("user_login_status")
    @Expose
    private Integer userLoginStatus;
    @SerializedName("threshold_display")
    @Expose
    private Integer thresholdDisplay;
    @SerializedName("ques_one")
    @Expose
    private QuesOne quesOne;
    @SerializedName("ques_two")
    @Expose
    private QuesTwo quesTwo;
    @SerializedName("ques_three")
    @Expose
    private QuesThree quesThree;
    @SerializedName("ques_four")
    @Expose
    private QuesFour quesFour;
    @SerializedName("ques_five")
    @Expose
    private QuesFive quesFive;
    @SerializedName("ques_six")
    @Expose
    private QuesSix quesSix;
    @SerializedName("ques_seven")
    @Expose
    private QuesSeven quesSeven;
    @SerializedName("ques_eight")
    @Expose
    private QuesEight quesEight;
    @SerializedName("ques_nine")
    @Expose
    private QuesNine quesNine;

    public Integer getUserLoginStatus() {
        return userLoginStatus;
    }

    public void setUserLoginStatus(Integer userLoginStatus) {
        this.userLoginStatus = userLoginStatus;
    }

    public Integer getThresholdDisplay() {
        return thresholdDisplay;
    }

    public void setThresholdDisplay(Integer thresholdDisplay) {
        this.thresholdDisplay = thresholdDisplay;
    }

    public QuesOne getQuesOne() {
        return quesOne;
    }

    public void setQuesOne(QuesOne quesOne) {
        this.quesOne = quesOne;
    }

    public QuesTwo getQuesTwo() {
        return quesTwo;
    }

    public void setQuesTwo(QuesTwo quesTwo) {
        this.quesTwo = quesTwo;
    }

    public QuesThree getQuesThree() {
        return quesThree;
    }

    public void setQuesThree(QuesThree quesThree) {
        this.quesThree = quesThree;
    }

    public QuesFour getQuesFour() {
        return quesFour;
    }

    public void setQuesFour(QuesFour quesFour) {
        this.quesFour = quesFour;
    }

    public QuesFive getQuesFive() {
        return quesFive;
    }

    public void setQuesFive(QuesFive quesFive) {
        this.quesFive = quesFive;
    }

    public QuesSix getQuesSix() {
        return quesSix;
    }

    public void setQuesSix(QuesSix quesSix) {
        this.quesSix = quesSix;
    }

    public QuesSeven getQuesSeven() {
        return quesSeven;
    }

    public void setQuesSeven(QuesSeven quesSeven) {
        this.quesSeven = quesSeven;
    }

    public QuesEight getQuesEight() {
        return quesEight;
    }

    public void setQuesEight(QuesEight quesEight) {
        this.quesEight = quesEight;
    }

    public QuesNine getQuesNine() {
        return quesNine;
    }

    public void setQuesNine(QuesNine quesNine) {
        this.quesNine = quesNine;
    }

}
