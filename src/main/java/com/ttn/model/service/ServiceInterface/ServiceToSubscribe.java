package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/18/2017.
 */
@Service
public interface ServiceToSubscribe {
String subscribe(int topicid,int userid);
}
