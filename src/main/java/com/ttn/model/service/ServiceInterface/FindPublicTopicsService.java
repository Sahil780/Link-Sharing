package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Topic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/10/2017.
 */
@Service
public interface FindPublicTopicsService {
    public List<Topic> getpublictopics(String topicname);

}
