package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.IOException;

/**
 * Created by user on 7/20/2017.
 */
@Service
public interface UpdateProfileService
{
    String updateProfilePic(User user, MultipartFile userpic,int userid) throws IOException;
    String updatePassword(String password,int userid);
}
