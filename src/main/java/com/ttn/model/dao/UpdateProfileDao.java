package com.ttn.model.dao;

import com.ttn.beans.User;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/20/2017.
 */
@Component
public interface UpdateProfileDao {
    String updateProfile(User user,int userid);
    String updatePassword(String password,int userid);
}
