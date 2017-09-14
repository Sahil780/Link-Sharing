package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Login;
import com.ttn.beans.User;
import com.ttn.model.dao.LoginAuthentication;
import com.ttn.model.service.ServiceInterface.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/4/2017.
 */
@Component
public class Loginimp implements LoginService {
    @Autowired
    public LoginAuthentication loginAuthentication;
    @Autowired
    public Login login;
    public List<User> authenticationservice(User user) {

        List<User> list=loginAuthentication.Authenticate(user);
   return list;
    }
}
