package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.ReadStatusDao;
import com.ttn.model.service.ServiceInterface.ReadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/16/2017.
 */
@Service
public class ReadStatusServiceImp implements ReadStatusService {
    @Autowired
    ReadStatusDao readStatusDao;
    public String updateReadStatusService(int readitemid,int userid) {
        return  readStatusDao.updateReadStatus(readitemid,userid);
    }
}
