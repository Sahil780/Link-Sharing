package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public interface ForgotPasswordDao {
    String insertVerificationCode(String emailOfUser,String verificationcode);
    String updatePasswoord(String emailofuser,String password,String verificationcode);
    boolean checkemailid(String emailenteredbyuser);
}
