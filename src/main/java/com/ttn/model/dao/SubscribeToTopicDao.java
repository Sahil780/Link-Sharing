package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/18/2017.
 */
@Component
public interface SubscribeToTopicDao {
    String subscribe(int tid,int id);
    String SubscribeToTopicByInvitation(String topicName,String createrName,String email);
}
