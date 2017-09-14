package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Topic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/9/2017.
 */
@Service
public interface CreateTopicService {
    public String createTopic(Topic topic,int userid);
    public String updateTopic(Topic topic);
}
