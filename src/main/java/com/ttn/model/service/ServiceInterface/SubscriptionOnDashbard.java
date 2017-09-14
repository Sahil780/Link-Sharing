package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Susbcription;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/17/2017.
 */
@Service
public interface SubscriptionOnDashbard {
    List<Susbcription> getSubscribedTopics(String username);
}
