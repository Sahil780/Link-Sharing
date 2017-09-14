package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.CheckUniqueTopicPerUserDao;
import com.ttn.model.service.ServiceInterface.CheckUniqueTopicPerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/16/2017.
 */
@Service
public class CheckUniqueTopicPerUserServiceImp implements CheckUniqueTopicPerUserService {
    @Autowired
    CheckUniqueTopicPerUserDao checkUniqueTopicPerUserDao;
    public String checkAvailabilityOfTopic(String topicname,String username) {
        if(!checkUniqueTopicPerUserDao.checkAvailability(topicname,username))
        {
            return "topic name available";
        }
        else
        {
            return "topic name already exist";
        }

    }
}
