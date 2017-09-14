package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Login;
import com.ttn.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/4/2017.
 */
@Service
public interface LoginService {
    List<User> authenticationservice(User user);
}
