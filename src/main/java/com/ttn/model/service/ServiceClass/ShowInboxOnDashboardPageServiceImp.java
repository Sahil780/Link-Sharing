package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Constants.ResourceType;
import com.ttn.beans.ReadingItem;
import com.ttn.model.dao.ShowInboxOnDashboardPageDao;
import com.ttn.model.service.ServiceInterface.ShowInboxOnDashboardPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Service
public class ShowInboxOnDashboardPageServiceImp implements ShowInboxOnDashboardPageService {
    @Autowired
    public ShowInboxOnDashboardPageDao showInboxOnDashboardPageDao;
    public String getResources(String username, int firstresultindex) {
        System.out.println("***************************************");
        System.out.println(username);
        List<ReadingItem> list = showInboxOnDashboardPageDao.getResources(username, firstresultindex);
        StringBuilder stringBuilder=new StringBuilder();
        for (ReadingItem r : list) {
          if(r.getResources().getResourceType()== ResourceType.DocumentResource)
          {
               stringBuilder.append("<div class=\"media\">\n" +
                       "                                <div class=\"media-left\">\n" +
                       "                                    <img src=\'/UserProfilePic?uname=" + r.getResources().getCreatedBy().getUsername() + "' width=\"120\" height=\"120\"/>\n" +
                       "                                </div>\n" +
                       "                                <div class=\"media-body\">\n" +
                       "                                    <h4 class=\"media-heading\">"+r.getResources().getCreatedBy().getUsername()+"<small><i>@"+r.getResources().getCreatedBy().getFirstname()+" " +r.getResources().getLastUpdated()+"</i></small><a href=\"\" style=\"float:right; font-size:12px\">"+r.getResources().getTopic().getName()+"</a></h4>\n" +
                       "                                    <p>"+r.getResources().getDescription()+"</p>\n" +
                       "                                    <div class=\"pgd\">\n" +
                       "                                        <div class=\"soc\">\n" +
                       "                                            <a href=\"#\" class=\"fa fa-facebook\"></a>\n" +
                       "                                            <a href=\"#\" class=\"fa fa-twitter\"></a>\n" +
                       "                                            <a href=\"#\" class=\"fa fa-google\"></a>\n" +
                       "                                        </div>\n" +
                       "                                        <a href=\'/download?fileName="+r.getResources().getResourcePath()+"' style=\"float:right\">Download</a>\n" +
                       "                                        <a href=\"###\" onclick=markasread("+r.getId()+") style=\"float:right\">Mark as Read</a>\n" +
                       "                                        <a href=\"###\" style=\"float:right\">View Post</a>\n" +
                       "                                    </div>\n" +
                       "                                </div>\n" +
                       "                            </div>");
          }
          else
          {
              stringBuilder.append("  <li class=\"list-group-item\">\n" +
                      "                            <div class=\"media\">\n" +
                      "                                <div class=\"media-left\">\n" +
                      "                                    <img src=\'/UserProfilePic?uname=" + r.getResources().getCreatedBy().getUsername() + "' width=\"120\" height=\"120\"/>\n" +
                      "                                </div>\n" +
                      "                                <div class=\"media-body\">\n" +
                      "                                    <h4 class=\"media-heading\">"+r.getResources().getCreatedBy().getUsername()+"<small><i>@"+r.getResources().getCreatedBy().getFirstname()+" " +r.getResources().getLastUpdated()+"</i></small><a href=\"\" style=\"float:right; font-size:12px\">"+r.getResources().getTopic().getName()+"</a></h4>\n" +
                      "                                    <p>"+r.getResources().getDescription()+"</p>\n" +
                      "                                    <div class=\"pgd\">\n" +
                      "                                        <div class=\"soc\">\n" +
                      "                                            <a href=\"#\" class=\"fa fa-facebook\"></a>\n" +
                      "                                            <a href=\"#\" class=\"fa fa-twitter\"></a>\n" +
                      "                                            <a href=\"#\" class=\"fa fa-google\"></a>\n" +
                      "                                        </div>\n" +
                      "                                        <a  href="+r.getResources().getResourcePath()+" target='_blank ' style=\"float:right\">View Full Site</a>\n" +
                      "                                        <a href=\"###\" onclick=markasread("+r.getId()+") style=\"float:right\">Mark as Read</a>\n" +
                      "                                        <a href=\"###\" style=\"float:right\">View Post</a>\n" +
                      "                                    </div>\n" +
                      "                                </div>\n" +
                      "                            </div>\n" +
                      "                        </li>");
          }
        }
        return stringBuilder.toString();
    }
}
