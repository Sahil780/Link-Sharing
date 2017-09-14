package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.SubscribeToTopicDao;
import com.ttn.model.service.ServiceInterface.SubscribeToTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/19/2017.
 */
@Service
public class SubscribeToTopicServiceImp implements SubscribeToTopicService{
    @Autowired
    SubscribeToTopicDao subscribeToTopicDao;
    public String subscribeToTopic(String topicname, String createrName, String email) {
       return subscribeToTopicDao.SubscribeToTopicByInvitation(topicname, createrName, email);
    }
}
