package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/19/2017.
 */
@Service
public interface SubscribeToTopicService {
    String subscribeToTopic(String topicname,String createrName,String email);
}
