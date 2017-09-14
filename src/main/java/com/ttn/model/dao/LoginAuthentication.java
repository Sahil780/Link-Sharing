package com.ttn.model.dao;


import com.ttn.beans.Login;
import com.ttn.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/1/2017.
 */
@Service
public interface LoginAuthentication {

    public List<User> Authenticate(User user);
}
