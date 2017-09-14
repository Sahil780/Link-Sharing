package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Resources;
import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import com.ttn.model.dao.FetchAllTopicsOfUserDao;
import com.ttn.model.service.ServiceInterface.FetchAllDetailsOfTopicsOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Service
public class FetchAllDetailsOfTopicsOfUserServiceImp implements FetchAllDetailsOfTopicsOfUserService {
    @Autowired
    FetchAllTopicsOfUserDao fetchAllTopicsOfUserDao;

    public String getTopicsOfuser(String userName, String currentUserName,int firstresultindex) {
        if(userName.equals(currentUserName))
        {
         List<Topic> topicList=fetchAllTopicsOfUserDao.getAllTopicsOfUser(userName,currentUserName,firstresultindex);
         StringBuilder stringBuilder=new StringBuilder();
         for(Topic topic:topicList)
         {
             Long subscriptioncount=fetchAllTopicsOfUserDao.getSubscriptionCount(topic.getId());
//             System.out.println("topic name "+topic.getName());
//             System.out.println("subscriptioncount "+subscriptioncount);
//             System.out.println(" is subscribed "+fetchAllTopicsOfUserDao.isSubscribedToTopic(topic.getId(),currentUserName));
//             System.out.println(" post in topic "+fetchAllTopicsOfUserDao.getPostCount(topic.getId()));
             if(fetchAllTopicsOfUserDao.isSubscribedToTopic(topic.getId(),currentUserName)) {
                 stringBuilder.append("              <div class=\"media\">\n" +
                         "                                <div class=\"media-left\">\n" +
                         "                                  <h3 class=\"media-heading\">&nbsp;<small><i></i></small><a href=\"\" style=\"margin-left: 20px\">'"+topic.getName()+"'</a></h3>\n" +
                         "                                   <select class=\"form-control btn-info\" style=\"width: 140px;margin-top: 45px\">\n" +
                         "                                      <option>Serious</option>\n" +
                         "                                      <option>Very Serious</option>\n" +
                         "                                      <option>Casual</option>\n" +
                         "                                 </select><a class=\"btn\" role=\"button\" data-toggle=\"modal\"\n" +
                         "                   data-target=\"#SendInvitationModel\"  class=\"fa fa-envelope\" style=\"margin-left: 160px;margin-top: -45px\"></a>\n" +
                         "\n" +
                         "                                </div>\n" +
                         "                                <div class=\"media-body\">\n" +
                         "                                    <div class=\"col-md-6\">\n" +
                         "                                        <h4 style=\"margin-left:65px; \">Subscriptions</h4><br/>\n" +
                         "                                        <small><p style=\"margin-left: 75px\">'"+subscriptioncount+"'</p></small>\n" +
                         "                                    </div>\n" +
                         "                                    <div class=\"col-md-6\">\n" +
                         "                                        <h4 style=\"margin-left: 75px;\">Post</h4><br/>\n" +
                         "                                        <small><p style=\"margin-left: 75px\">'"+fetchAllTopicsOfUserDao.getPostCount(topic.getId())+"'</p></small>\n" +
                         "                                    </div>\n" +
                         "                                </div>\n" +
                         "                            </div>");
                 System.out.println(topic.getName()+"111");


             }
             else
             {
                 stringBuilder.append("<li class=\"list-group-item\">\n" +
                         "                            <div class=\"media\">\n" +
                         "                                <div class=\"media-left\">\n" +
                         "                                  <h3 class=\"media-heading\">&nbsp;<small><i></i></small><a href=\"\" style=\"margin-left: 25px\">'"+topic.getName()+"'</a></h3>\n" +
                         "                                   <h4 style=\"margin-left: 15px\"><a href=\"##\">Subscribe</a></h4>\n" +
                         "\n" +
                         "                                </div>\n" +
                         "                                <div class=\"media-body\">\n" +
                         "                                    <div class=\"col-md-6\">\n" +
                         "                                        <h4 style=\"margin-left: 180px;\">Subscriptions</h4><br/>\n" +
                         "                                        <small><p style=\"margin-left: 180px;\">'"+subscriptioncount+"'</p></small>\n" +
                         "                                    </div>\n" +
                         "                                    <div class=\"col-md-6\">\n" +
                         "                                        <h4 style=\"margin-left: 140px\">Post</h4><br/>\n" +
                         "                                        <small><p style=\"margin-left: 140px\">'"+fetchAllTopicsOfUserDao.getPostCount(topic.getId())+"'</p></small>\n" +
                         "                                    </div>\n" +
                         "                                </div>\n" +
                         "                            </div>\n" +
                         "                        </li>\n" +
                         "               \n");

             }

         }
         return stringBuilder.toString();
        }
        else
        {
            List<Topic> topicList= fetchAllTopicsOfUserDao.getAllPublicTopics(userName, currentUserName,firstresultindex);
            StringBuilder stringBuilder=new StringBuilder();
            for(Topic topic:topicList) {
                Long subscriptioncount = fetchAllTopicsOfUserDao.getSubscriptionCount(topic.getId());
                System.out.println("topic name " + topic.getName());
                System.out.println("subscriptioncount " + subscriptioncount);
                System.out.println(" is subscribed " + fetchAllTopicsOfUserDao.isSubscribedToTopic(topic.getId(), currentUserName));
                System.out.println(" post in topic " + fetchAllTopicsOfUserDao.getPostCount(topic.getId()));
                if (fetchAllTopicsOfUserDao.isSubscribedToTopic(topic.getId(), currentUserName)) {
                    stringBuilder.append("              <div class=\"media\">\n" +
                            "                                <div class=\"media-left\">\n" +
                            "                                  <h3 class=\"media-heading\">&nbsp;<small><i></i></small><a href=\"\" style=\"margin-left: 20px\">'" + topic.getName() + "'</a></h3>\n" +
                            "                                   <select class=\"form-control btn-info\" style=\"width: 140px;margin-top: 45px\">\n" +
                            "                                      <option>Serious</option>\n" +
                            "                                      <option>Very Serious</option>\n" +
                            "                                      <option>Casual</option>\n" +
                            "                                 </select><a class=\"btn\" role=\"button\" data-toggle=\"modal\"\n" +
                            "                   data-target=\"#SendInvitationModel\"  class=\"fa fa-envelope\" style=\"margin-left: 160px;margin-top: -45px\"></a>\n" +
                            "\n" +
                            "                                </div>\n" +
                            "                                <div class=\"media-body\">\n" +
                            "                                    <div class=\"col-md-6\">\n" +
                            "                                        <h4 style=\"margin-left:65px; \">Subscriptions</h4><br/>\n" +
                            "                                        <small><p style=\"margin-left: 75px\">'" + subscriptioncount + "'</p></small>\n" +
                            "                                    </div>\n" +
                            "                                    <div class=\"col-md-6\">\n" +
                            "                                        <h4 style=\"margin-left: 75px;\">Post</h4><br/>\n" +
                            "                                        <small><p style=\"margin-left: 75px\">'" + fetchAllTopicsOfUserDao.getPostCount(topic.getId()) + "'</p></small>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>");
                    System.out.println(topic.getName() + "111");

                }
                else {
                    stringBuilder.append("<li class=\"list-group-item\">\n" +
                            "                            <div class=\"media\">\n" +
                            "                                <div class=\"media-left\">\n" +
                            "                                  <h3 class=\"media-heading\">&nbsp;<small><i></i></small><a href=\"\" style=\"margin-left: 25px\">'"+topic.getName()+"'</a></h3>\n" +
                            "                                   <h4 style=\"margin-left: 15px\"><a href=\"##\">Subscribe</a></h4>\n" +
                            "\n" +
                            "                                </div>\n" +
                            "                                <div class=\"media-body\">\n" +
                            "                                    <div class=\"col-md-6\">\n" +
                            "                                        <h4 style=\"margin-left: 180px;\">Subscriptions</h4><br/>\n" +
                            "                                        <small><p style=\"margin-left: 180px;\">'"+subscriptioncount+"'</p></small>\n" +
                            "                                    </div>\n" +
                            "                                    <div class=\"col-md-6\">\n" +
                            "                                        <h4 style=\"margin-left: 140px\">Post</h4><br/>\n" +
                            "                                        <small><p style=\"margin-left: 140px\">'"+fetchAllTopicsOfUserDao.getPostCount(topic.getId())+"'</p></small>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                        </li>\n" +
                            "               \n");

                }
            }
            return stringBuilder.toString();
        }

    }

    public Long getSubscriptionCount(int topicId) {
        return null;
    }

    public Long getPostCount(int topicId) {
        return null;
    }
}
