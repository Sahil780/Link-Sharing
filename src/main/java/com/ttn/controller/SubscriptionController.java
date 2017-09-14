package com.ttn.controller;

import com.ttn.model.dao.SubscribeToTopicDao;
import com.ttn.model.service.ServiceInterface.SendInvitationOfTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 7/19/2017.
 */
@Controller
public class SubscriptionController {
    @Autowired
    SendInvitationOfTopicService sendInvitationOfTopicService;
    @Autowired
    SubscribeToTopicDao subscribeToTopicDao;
    @RequestMapping(value = "/sendSubscriptionInvitation",method = RequestMethod.POST)
    public @ResponseBody String sendInvitation(@RequestParam("emailofuser") String email,@RequestParam("tname") String topicName)
    {
        return sendInvitationOfTopicService.sendInvitation(email,topicName);
    }
    @RequestMapping(value = "/subscribetotopicbyinvitation",method = RequestMethod.GET)
    public ModelAndView getSubscribedToTopic(@RequestParam("topicname") String topicName, @RequestParam("creatorname") String ceraterName,
                                             @RequestParam("useremail") String userEmail, HttpSession session, HttpServletRequest request)
    {
        session=request.getSession();

       if(session.getAttribute("uname")!=null)
       {
           ModelAndView modelAndView=new ModelAndView("SubscriptionByInvitation");
           modelAndView.addObject("msg",subscribeToTopicDao.SubscribeToTopicByInvitation(topicName,ceraterName,userEmail));
           return modelAndView;
       }
       else
       {
           ModelAndView modelAndView=new ModelAndView("homepage");
           return modelAndView;
       }
    }
}
