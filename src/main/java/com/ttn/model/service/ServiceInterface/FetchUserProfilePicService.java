package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/15/2017.
 */
@Service
public interface FetchUserProfilePicService {
    byte[] fetchUserProfilePic(String username);
}
