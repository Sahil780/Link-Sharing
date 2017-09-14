package com.ttn.model.dao;

import com.ttn.beans.Resources;
import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FetchAllTopicsOfUserDao {
    List<Topic> getAllPublicTopics(String username,String currentusername,int firstresultindex);
    List<Topic> getAllTopicsOfUser(String username,String currentUser,int firstresultindex);
    Long getSubscriptionCount(int topicId);
    Long getPostCount(int topicId);
    boolean isSubscribedToTopic(int tid,String currentusername);
}
