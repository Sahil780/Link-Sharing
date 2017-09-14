package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Susbcription;
import com.ttn.model.dao.SubscribedTopicsOnDashboardDao;
import com.ttn.model.service.ServiceInterface.SubscriptionOnDashbard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/17/2017.
 */
@Service
public class SubscribedTopicsOnDashboardServiceImp implements SubscriptionOnDashbard {
    @Autowired
    SubscribedTopicsOnDashboardDao subscribedTopicsOnDashboardDao;
    public List<Susbcription> getSubscribedTopics(String username) {
        return subscribedTopicsOnDashboardDao.getSubscribedTopics(username);
    }
}
