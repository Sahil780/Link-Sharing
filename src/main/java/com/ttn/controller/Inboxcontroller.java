package com.ttn.controller;

import com.ttn.beans.Constants.ResourceType;
import com.ttn.beans.ReadingItem;
import com.ttn.model.service.ServiceInterface.ShowInboxOnDashboardPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by user on 7/16/2017.
 */
@Controller
public class Inboxcontroller {
    @Autowired
    ShowInboxOnDashboardPageService showInboxOnDashboardPageService;
    @RequestMapping(value = "/fetchinbox",method = RequestMethod.GET)
public @ResponseBody String fetchInbox(HttpServletRequest request)
    {
        String username=request.getSession().getAttribute("uname").toString();
      return showInboxOnDashboardPageService.getResources(username,Integer.parseInt(request.getParameter("index")));
//        StringBuilder sb=new StringBuilder();
//        for(ReadingItem r:list)
//        {
//            if(r.getResources().getResourceType()== ResourceType.DocumentResource)
//            {
//                System.out.println("######################");
//               sb.append("\n" +
//                       "<div class=\"col-sm-2\" style=\"margin-top: 10px;\">\n" +
//                       "    <img src=\'/UserProfilePic?uname="+r.getResources().getCreatedBy().getUsername()+"' width=\"70px\" height=\"70px\">\n" +
//                       "</div>\n" +
//                       "<div class=\"col-sm-10\">\n" +
//                       "    <div class=\"description\" style=\"font-size: 15px;margin-left: 25px;\">\n" +
//                       "        <!-- resource creator name will fetch here -->\n" +r.getResources().getCreatedBy().getUsername()+
//                       "        <span style=\"font-size: 10px;color: grey;\">\n" +
//                       "              <!-- resource creator firstname will fetch here with date created -->\n"
//                       +"<br>"+"@"+r.getResources().getCreatedBy().getFirstname()+" "+r.getResources().getDateCreated()+"</span>\n" +
//                       "        <a href=\"###\" style=\"float: right;\">"+r.getResources().getTopic().getName()+"</a>\n" +
//                       "        <br>\n" +
//                       "        <!-- description of resource will fetch from the -->\n" +
//                       "        \n" +r.getResources().getDescription()+
//                       "        <br>\n" +
//                       "        <span class=\"fa fa-facebook-official\"></span>\n" +
//                       "        <span class=\"fa\">&#xf173;</span>\n" +
//                       "        <span class=\"fa fa-google-plus\"></span>\n" +
//                       "\n" +
//                       "        <!-- link for view post -->\n" +
//                       "\n" +
//                       "        <a href=\"\"><span style=\"float: right;text-decoration: underline;font-size: 15px\">view full post</span></a>\n" +
//                       "\n" +
//                       "        <!-- link for mark as read -->\n" +
//                       "\n" +
//                       "        <a href='##'style='float:right;text-decoration:underline;font-size:15px;padding-right: 10px;' onclick='markasread("+r.getId()+")'><span >mark as read</span></a>\n" +
//                       "\n" +
//                       "        <!--  link for download option -->\n" +
//                       "\n" +
//                       "        <a href=\'/download?fileName="+r.getResources().getResourcePath()+"'><span style=\"float: right;text-decoration: underline;padding-right: 10px;font-size: 15px\">download</span></a>\n" +
//                       "\n" +
//                       "    </div>\n" +
//                       "\n" +
//                       "</div>");
//            }
//            else
//            {
//                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//                System.out.println(r.getResources().getDescription());
//                sb.append(
//                        "<div class=\"col-sm-2\" style=\"margin-top: 10px;\">\n" +
//                                "    <img src='UserProfilePic?uname="+r.getResources().getCreatedBy().getUsername()+"' width=\"70px\" height=\"70px\">\n" +
//                        "</div>\n" +
//                        "<div class=\"col-sm-10\">\n" +
//                        "    <div class=\"description\" style=\"font-size: 15px;margin-left: 25px;\">\n" +
//                        "        <!-- resource creator name will fetch here -->\n" +r.getResources().getCreatedBy().getUsername()+
//                        "         <span style=\"font-size: 10px;color: grey;\">\n" +
//                        "              <!-- resource creator firstname will fetch here with date created -->\n" +"<br>@"+r.getResources().getCreatedBy().getFirstname()+
//                        " "+r.getResources().getDateCreated()+
//                        "              </span>\n" +
//                        "        <a href=\"###\" style=\"float: right;\">"+r.getResources().getTopic().getName()+"</a>\n" +
//                        "        <br>\n" +
//                        "        <!-- description of resource will fetch from the -->\n" +r.getResources().getDescription()+
//                        "        <br>\n" +
//                        "        <span class=\"fa fa-facebook-official\"></span>\n" +
//                        "        <span class=\"fa\">&#xf173;</span>\n" +
//                        "        <span class=\"fa fa-google-plus\"></span>\n" +
//                        "\n" +
//                        "        <!-- link for view post -->\n" +
//                        "\n" +
//                        "        <a href=\"\"><span style=\"float: right;text-decoration: underline;font-size: 15px\">view full post</span></a>\n" +
//                        "\n" +
//                        "        <!-- link for mark as read -->\n" +
//                        "\n" +
//                                "        <a href='##' style='float:right;text-decoration:underline;font-size:15px;padding-right: 10px;' onclick='markasread("+r.getId()+")'><span >mark as read</span></a>\n" +
//                        "\n" +
//                        "        <!-- link for view full site -->\n" +
//                        "\n" +
//                        "\n" +
//                        "       <a href="+r.getResources().getResourcePath()+" target='_blank '><span style=\"float: right;text-decoration: underline;padding-right: 10px;font-size: 15px\">View Full Site</span></a>\n" +
//                        "\n" +
//                        "    </div>\n" +
//                        "\n" +
//                        "</div>\n");
//
//
//            }
//        }
//        return sb.toString();

    }
}
