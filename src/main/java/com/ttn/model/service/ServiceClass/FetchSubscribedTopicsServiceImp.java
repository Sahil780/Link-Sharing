package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Susbcription;
import com.ttn.model.dao.FetchSubscribedTopicsDao;
import com.ttn.model.service.ServiceInterface.FetchSubscribedTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/16/2017.
 */
@Service
public class FetchSubscribedTopicsServiceImp implements FetchSubscribedTopics {
    @Autowired
    FetchSubscribedTopicsDao fetchSubscribedTopicsDao;
    public List<Susbcription> getTopics(String topicname,String username) {
        return fetchSubscribedTopicsDao.getTopics(topicname,username);
    }
}
