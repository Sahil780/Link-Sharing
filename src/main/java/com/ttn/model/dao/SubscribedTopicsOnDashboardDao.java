package com.ttn.model.dao;

import com.ttn.beans.Susbcription;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/17/2017.
 */
@Component
public interface SubscribedTopicsOnDashboardDao {
    List<Susbcription> getSubscribedTopics(String username);
}
