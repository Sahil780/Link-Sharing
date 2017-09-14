package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/16/2017.
 */
@Service
public interface ReadStatusService {
    String updateReadStatusService(int readitemid,int userid);
}
