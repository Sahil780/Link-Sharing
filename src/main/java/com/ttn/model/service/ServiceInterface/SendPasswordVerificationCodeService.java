package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/13/2017.
 */
@Service
public interface SendPasswordVerificationCodeService {
    boolean checkemailid(String emailenteredbyuser);
    String sendVerificationCode(String useremail);
}
