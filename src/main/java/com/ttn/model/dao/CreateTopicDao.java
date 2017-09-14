package com.ttn.model.dao;

import com.ttn.beans.Topic;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/9/2017.
 */
@Component
public interface CreateTopicDao {
    public boolean createTopic(Topic topic,int userid);
    public boolean updateTopic(Topic topic);
}
