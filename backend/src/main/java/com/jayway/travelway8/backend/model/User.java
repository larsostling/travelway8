package com.jayway.travelway8.backend.model;

import java.util.Date;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface User {

    //void setPassportNr(String passportNr);

    Date getValidToDate();

    //void setValidToDate(Date validToDate);

    String getPhone();

    //void setPhone(String phone);

    String getEmail();

    //void setEmail(String email);

    String getCitizenship();

    //void setCitizenship(String citizenship);

    String getSocialSecurityNr();

    //void setSocialSecurityNr(String socialSecurityNr);

    String getPassportName();
}
