package com.ttn.model.dao;

import com.ttn.beans.Topic;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/10/2017.
 */
@Component
public interface FindPublicTopics {
    public List<Topic> getPublicTopics(String topicname);
}
