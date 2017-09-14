package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.UnsubsribeDao;
import com.ttn.model.service.ServiceInterface.ServiceToUnsubscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/18/2017.
 */
@Service
public class ServiceToUnsubscribeImp implements ServiceToUnsubscribe {
    @Autowired
    UnsubsribeDao unsubsribeDao;
    public String unsubscribe(int topicid, int userid) {
        return unsubsribeDao.unsubscribe(topicid,userid);
    }
}
