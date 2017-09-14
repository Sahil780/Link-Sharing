package com.ttn.model.dao;

import com.ttn.beans.CreateDocumentResource;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public interface CreateDocumentResourceDao {
    String CreateDocumentResource(CreateDocumentResource createDocumentResource,int userid);
}
