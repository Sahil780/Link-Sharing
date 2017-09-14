package com.ttn.model.service.ServiceClass;

import com.ttn.beans.User;
import com.ttn.model.dao.RegistrationDao;
import com.ttn.model.service.ServiceInterface.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/15/2017.
 */
@Service
public class RegistrationServiceImp implements RegistrationService {
    @Autowired
    RegistrationDao registrationDao;
    public User register(User user) {
       return registrationDao.register(user);

    }
}
