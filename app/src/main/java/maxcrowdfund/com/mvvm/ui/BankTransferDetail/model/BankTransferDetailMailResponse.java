
package maxcrowdfund.com.mvvm.ui.BankTransferDetail.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankTransferDetailMailResponse {

    @SerializedName("user_login_status")
    @Expose
    private Integer userLoginStatus;
    @SerializedName("bank_transfer_detail_mail")
    @Expose
    private BankTransferDetailMail bankTransferDetailMail;

    public Integer getUserLoginStatus() {
        return userLoginStatus;
    }

    public void setUserLoginStatus(Integer userLoginStatus) {
        this.userLoginStatus = userLoginStatus;
    }

    public BankTransferDetailMail getBankTransferDetailMail() {
        return bankTransferDetailMail;
    }

    public void setBankTransferDetailMail(BankTransferDetailMail bankTransferDetailMail) {
        this.bankTransferDetailMail = bankTransferDetailMail;
    }

}
