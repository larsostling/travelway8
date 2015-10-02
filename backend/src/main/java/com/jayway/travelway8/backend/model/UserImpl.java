package com.jayway.travelway8.backend.model;

import java.util.Date;

public class UserImpl implements User{
    private String passportName;
    private String passportNr;
    private Date validToDate;
    private String phone;
    private String email;
    private String citizenship;
    private String socialSecurityNr;

    public String getPassportNr() {
        return passportNr;
    }

    public UserImpl(String passportName, String passportNr, Date validToDate, String phone, String email,
            String citizenship, String socialSecurityNr) {
        this.passportName = passportName;
        this.passportNr = passportNr;
        this.validToDate = validToDate;
        this.phone = phone;
        this.email = email;
        this.citizenship = citizenship;
        this.socialSecurityNr = socialSecurityNr;
    }


    public void setPassportNr(String passportNr) {
        this.passportNr = passportNr;
    }

    @Override
    public Date getValidToDate() {
        return validToDate;
    }


    public void setValidToDate(Date validToDate) {
        this.validToDate = validToDate;
    }

    @Override
    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCitizenship() {
        return citizenship;
    }


    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String getSocialSecurityNr() {
        return socialSecurityNr;
    }


    public void setSocialSecurityNr(String socialSecurityNr) {
        this.socialSecurityNr = socialSecurityNr;
    }

    @Override
    public String getPassportName() {
        return passportName;
    }

    public void setPassportName(String passportName) {
        this.passportName = passportName;
    }
}
