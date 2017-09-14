package com.ttn.model.dao;

import com.ttn.beans.User;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/2/2017.
 */
@Service
public interface RegistrationDao {
    User register(User user);
}
