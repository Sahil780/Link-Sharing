package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Resources;
import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Service
public interface FetchAllDetailsOfTopicsOfUserService {
String getTopicsOfuser(String userName,String currentUserName,int firstresultindex);
Long  getSubscriptionCount(int topicId);
Long getPostCount(int topicId);
}
