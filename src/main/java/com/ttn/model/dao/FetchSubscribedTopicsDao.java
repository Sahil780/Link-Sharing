package com.ttn.model.dao;

import com.ttn.beans.Susbcription;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/16/2017.
 */
@Component
public interface FetchSubscribedTopicsDao {
    List<Susbcription> getTopics(String topicname,String username);
}
