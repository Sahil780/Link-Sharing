package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.FetchUserProfilePicDao;
import com.ttn.model.service.ServiceInterface.FetchUserProfilePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/15/2017.
 */
@Service
public class FetchUserProfilePicServiceImp implements FetchUserProfilePicService {
    @Autowired
    FetchUserProfilePicDao fetchUserProfilePicDao;
    public byte[] fetchUserProfilePic(String username) {
       return fetchUserProfilePicDao.fetchUserProfilePic(username);
    }
}
