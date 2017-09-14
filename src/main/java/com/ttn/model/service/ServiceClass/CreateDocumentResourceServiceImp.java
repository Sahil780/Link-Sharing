package com.ttn.model.service.ServiceClass;

import com.ttn.beans.CreateDocumentResource;
import com.ttn.model.dao.CreateDocumentResourceDao;
import com.ttn.model.service.ServiceInterface.CreateDocumentResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class CreateDocumentResourceServiceImp implements CreateDocumentResourceService {
    @Autowired
    CreateDocumentResourceDao createDocumentResourceDao;
    public String createDocumentResource(CreateDocumentResource createDocumentResource, int userid) {
        return createDocumentResourceDao.CreateDocumentResource(createDocumentResource, userid);
    }
}
