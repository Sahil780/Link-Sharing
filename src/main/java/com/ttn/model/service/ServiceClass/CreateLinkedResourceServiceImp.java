package com.ttn.model.service.ServiceClass;
import com.ttn.model.dao.CreateLinkedResourceDao;
import com.ttn.model.service.ServiceInterface.CreateLinkedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class CreateLinkedResourceServiceImp implements CreateLinkedResourceService{
    @Autowired
    CreateLinkedResourceDao createLinkedResourceDao;
    public String createLinkedResourceService(com.ttn.beans.CreateLinkedResource createLinkedResource,int userid) {
    return createLinkedResourceDao.createLinkedResourceDao(createLinkedResource,userid);
    }
}