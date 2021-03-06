
package maxcrowdfund.com.mvvm.ui.myprofile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("givenname")
    @Expose
    private Givenname givenname;
    @SerializedName("surname")
    @Expose
    private Surname surname;
    @SerializedName("email")
    @Expose
    private Email email;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("investorid")
    @Expose
    private Investorid investorid;
    @SerializedName("accountid")
    @Expose
    private Accountid accountid;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("mobile_number")
    @Expose
    private MobileNumber mobileNumber;
    @SerializedName("address_country")
    @Expose
    private AddressCountry addressCountry;
    @SerializedName("address_country_code")
    @Expose
    private AddressCountryCode addressCountryCode;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Givenname getGivenname() {
        return givenname;
    }

    public void setGivenname(Givenname givenname) {
        this.givenname = givenname;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Investorid getInvestorid() {
        return investorid;
    }

    public void setInvestorid(Investorid investorid) {
        this.investorid = investorid;
    }

    public Accountid getAccountid() {
        return accountid;
    }

    public void setAccountid(Accountid accountid) {
        this.accountid = accountid;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AddressCountry getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(AddressCountry addressCountry) {
        this.addressCountry = addressCountry;
    }

    public AddressCountryCode getAddressCountryCode() {
        return addressCountryCode;
    }

    public void setAddressCountryCode(AddressCountryCode addressCountryCode) {
        this.addressCountryCode = addressCountryCode;
    }

}
