package com.ttn.model.service.ServiceClass;

import com.ttn.beans.User;
import com.ttn.model.dao.UpdateProfileDao;
import com.ttn.model.service.ServiceInterface.UpdateProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.IOException;

/**
 * Created by user on 7/20/2017.
 */
@Service
public class UpdateProfileServiceImp implements UpdateProfileService {
    @Autowired
    UpdateProfileDao updateProfileDao;
    public String updateProfilePic(User user, MultipartFile userPic,int userid) throws IOException {
        if ((userPic != null && userPic.getSize() > 0 )) {
           user.setPhoto(userPic.getBytes());
           return updateProfileDao.updateProfile(user,userid);
        }
        else
        {
            return "error";
        }
    }

    public String updatePassword(String password, int userid) {
   return updateProfileDao.updatePassword(password, userid);
    }

}
