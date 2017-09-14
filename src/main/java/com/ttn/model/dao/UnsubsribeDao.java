package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/18/2017.
 */
@Component
public interface UnsubsribeDao {
    String unsubscribe(int topicid,int userid);
}
