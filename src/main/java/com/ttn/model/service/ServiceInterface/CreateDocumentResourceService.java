package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.CreateDocumentResource;
import org.springframework.stereotype.Service;

/**
 * Created by user on 7/13/2017.
 */
@Service
public interface CreateDocumentResourceService {
    String createDocumentResource(CreateDocumentResource createDocumentResource,int userid);
}
