package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public interface CreateLinkedResourceDao {
     String createLinkedResourceDao(com.ttn.beans.CreateLinkedResource createLinkedResource,int userid);
}
