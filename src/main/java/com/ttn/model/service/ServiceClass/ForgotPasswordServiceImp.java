package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.ForgotPasswordDao;
import com.ttn.model.service.ServiceInterface.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/13/2017.
 */
@Service
public class ForgotPasswordServiceImp implements ForgotPasswordService {
@Autowired
    ForgotPasswordDao forgotPasswordDao;
    public String updatePassword(String emailOfUser, String password, String verificationcode)
    {
       return forgotPasswordDao.updatePasswoord(emailOfUser,password,verificationcode);

    }
}
