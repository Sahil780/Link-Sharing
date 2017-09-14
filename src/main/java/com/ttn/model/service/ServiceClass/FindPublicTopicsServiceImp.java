package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Topic;
import com.ttn.model.dao.FindPublicTopics;
import com.ttn.model.service.ServiceInterface.FindPublicTopicsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/10/2017.
 */
@Component
public class FindPublicTopicsServiceImp implements FindPublicTopicsService {
    @Autowired
    FindPublicTopics findPublicTopics;

    public List<Topic> getpublictopics(String topicname) {
        List<Topic> listofpublictopics=findPublicTopics.getPublicTopics(topicname);
        return listofpublictopics;
    }
}
