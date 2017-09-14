package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Susbcription;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/16/2017.
 */
@Service
public interface FetchSubscribedTopics {
    List<Susbcription> getTopics(String topicname,String username);
}
