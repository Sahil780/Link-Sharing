package com.ttn.model.service.ServiceClass;

import com.ttn.beans.Constants.ResourceType;
import com.ttn.beans.ReadingItem;
import com.ttn.model.dao.ShowPostOnUserProfilePageDao;
import com.ttn.model.service.ServiceInterface.ShowPostOnUserProfilePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Service
public class ShowPostOnUserProfilePageServiceImp implements ShowPostOnUserProfilePageService {
    @Autowired
    ShowPostOnUserProfilePageDao showPostOnUserProfilePageDao;

    public String getResources(String username, int firstresultindex) {
        if (showPostOnUserProfilePageDao.getResources(username, firstresultindex).isEmpty()) {
            return "NO POST YET";
        } else {
            List<ReadingItem> readingItems = showPostOnUserProfilePageDao.getResources(username, firstresultindex);
            StringBuilder sb = new StringBuilder();
            for (ReadingItem readingItem : readingItems) {

                if (readingItem.getResources().getResourceType() == ResourceType.LinkResource) {
                    sb.append(
                            "                            <div class=\"media\">\n" +
                            "                                <div class=\"media-body\">\n" +
                            "                                    <p><a href=\"##\">'" + readingItem.getResources().getTopic().getName() + "'</p></a>\n" +
                            "                                    <h4>'" + readingItem.getResources().getDescription() + "'</h4>\n" +
                            "                                    <div class=\"pgd\">\n" +
                            "                                        <div class=\"soc\">\n" +
                            "                                            <a href=\"#\" class=\"fa fa-facebook\"></a>\n" +
                            "                                            <a href=\"#\" class=\"fa fa-twitter\"></a>\n" +
                            "                                            <a href=\"#\" class=\"fa fa-google\"></a>\n" +
                            "                                        </div>\n" +
                            "                                        <a href=\"###\" style=\"float:right;padding:5px\">ViewPost</a>\n" +
                            "                                        <a href="+readingItem.getResources().getResourcePath()+" target='_blank ' style=\"float:right;padding: 5px\">View Full Site</a>\n" +
                            "                                        <a href=\"###\" style=\"float:right;padding:5px\" onclick=markedasread('"+readingItem.getId()+"')>Marked As Read</a>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                      ");
                } else {
                    sb.append(
                            "                            <div class=\"media\">\n" +
                            "                                <div class=\"media-body\">\n" +
                            "                                    <p><a href=\"##\">'" + readingItem.getResources().getTopic().getName() + "'</p></a>\n" +
                            "                                    <h4>'" + readingItem.getResources().getDescription() + "'</h4>\n" +
                            "                                    <div class=\"pgd\">\n" +
                            "                                        <div class=\"soc\">\n" +
                            "                                            <a href=\"#\" class=\"fa fa-facebook\"></a>\n" +
                            "                                            <a href=\"#\" class=\"fa fa-twitter\"></a>\n" +
                            "                                            <a href=\"#\" class=\"fa fa-google\"></a>\n" +
                            "                                        </div>\n" +
                            "                                         <a href=\"###\" style=\"float:right;padding: 5px;\">View Post</a>\n" +
                            "                                        <a href=\'/download?fileName=" + readingItem.getResources().getResourcePath() + "' style=\"float:right;padding: 5px;\">Download</a>\n" +
                            "                                        <a href=\"###\" onclick=markedasread('"+readingItem.getId()+"') style=\"float:right;padding: 5px;\">Mark as Read</a>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                       ");
                }

            }
            return sb.toString();
        }
    }
}