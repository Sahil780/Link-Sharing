package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Topic;
import com.ttn.model.dao.CreateTopicDao;
import com.ttn.model.service.ServiceInterface.CreateTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/9/2017.
 */
@Service
public class CreateTopicServiceImp implements CreateTopicService {
@Autowired
CreateTopicDao createTopicDao;

    public String createTopic(Topic topic,int userid) {
           if(createTopicDao.createTopic(topic,userid))
           {
               return "topic created successfully";
           }
           else {
               return " unsuccessfully operation";
           }
    }

    public String updateTopic(Topic topic) {
        return "";
    }
}
