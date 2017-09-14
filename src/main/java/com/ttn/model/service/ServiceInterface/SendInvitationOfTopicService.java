package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/19/2017.
 */
@Service
public interface SendInvitationOfTopicService {
    String sendInvitation(String email,String topicname);
}
