package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.SubscribeToTopicDao;
import com.ttn.model.service.ServiceInterface.ServiceToSubscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/18/2017.
 */
@Service
public class ServiceToSubscribeImp implements ServiceToSubscribe {
    @Autowired
    SubscribeToTopicDao subscribeToTopicDao;
    public String subscribe(int topicid,int userid) {

        return subscribeToTopicDao.subscribe(topicid,userid);
    }
}
