package com.ttn.controller;

import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import com.ttn.model.service.ServiceInterface.*;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.ContentType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by user on 7/9/2017.
 */
@Controller
public class TopicController {
@Autowired
    CreateTopicService createTopicService;
@Autowired
    FindPublicTopicsService findPublicTopicsService;
@Autowired
ShowInboxOnDashboardPageService showInboxOnDashboardPageService;
@Autowired
    CheckUniqueTopicPerUserService checkUniqueTopicPerUserService;
@Autowired
    FetchSubscribedTopics fetchSubscribedTopics;
@Autowired
ServiceToUnsubscribe serviceToUnsubscribe;
@Autowired
ServiceToSubscribe serviceToSubscribe;
static String topicname;
    @RequestMapping(value = "/createtopic",method = RequestMethod.POST)
    public @ResponseBody String creatTopic(@ModelAttribute Topic topic,HttpSession session)
    {

        int userid=(Integer) session.getAttribute("userid");
        System.out.println("****************************************************");
        System.out.println(userid);

        return createTopicService.createTopic(topic,userid);
    }

    @RequestMapping(value = "/findpublictopic",method = RequestMethod.GET)
    public  @ResponseBody List<Topic> getPublicTopics(HttpServletRequest request)
    {
        System.out.println("ayaaaaaaaaaaaa");
//        System.out.println("topic name "+request.getParameter("term"));
//        List<Topic> list=findPublicTopicsService.getpublictopics(request.getParameter("term"));
//        for(Topic topic:list)
//        {
//            System.out.println(topic.getName());
//        }
        return findPublicTopicsService.getpublictopics(request.getParameter("term"));


    }
    @RequestMapping(value = "/showtopicpage")
    public ModelAndView topicPage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ModelAndView mav=new ModelAndView("ShowTopicPage");
        topicname=request.getParameter("term");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//      topicname=topicname.replace("  ","++");
        System.out.println(topicname);
        mav.addObject("resources", showInboxOnDashboardPageService.getResources(topicname,0));
        mav.addObject("topicname",topicname);
        return mav;
    }
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response)
        {
            try
            {
                String fileName=request.getParameter("fileName");
                System.out.println("controller");
                System.out.println(fileName);

                fileName="file:///"+fileName;

//                System.out.println("file:///D:/spring2-mvc-xml/src/main/webapp/resources/assets/".length());

                URL url = new URL(fileName);
                final URLConnection connection = url.openConnection();

                final InputStream is = connection.getInputStream();
                OutputStream outStream = response.getOutputStream();
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName.substring(61));
                response.setHeader(headerKey, headerValue);
//                File f=new File(new URI("file://D:/spring2-mvc-xml/src/main/webapp/resources/assets/80530016-Sri_Sri_Kishore_Kishori_Close_up_-_1200x900.jpg"));
//                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(f));

                int data;
                byte b[]=new byte[999999];
                while ((data = is.read(b)) != -1) {
                   byte tmp[]= ArrayUtils.subarray(b, 0, data);
                   outStream.write(tmp);
                }
                System.out.println("downloaded");
//                FileCopyUtils.copy(inputStream , response.getOutputStream());
//                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        @RequestMapping(value = "/uniquetopiccheck",method = RequestMethod.POST)
     public @ResponseBody String checkTopicAvailability(HttpServletRequest request)
        {
            System.out.println("aaaaa yaaaaaa yyyaaa");
            return checkUniqueTopicPerUserService.checkAvailabilityOfTopic(request.getParameter("name"),
                    (String)request.getSession().getAttribute("uname"));
        }
        @RequestMapping(value = "/fetchSubscribedTopics",method = RequestMethod.GET)
    public @ResponseBody List<Susbcription> getSubscribedTopics(HttpSession session,HttpServletRequest request)
        {
            return fetchSubscribedTopics.getTopics(request.getParameter("term"),(String)session.getAttribute("uname"));
        }
        @RequestMapping(value = "/unsubscribeToTopic",method = RequestMethod.GET)
        public @ResponseBody String unsubscribe(HttpServletRequest request,HttpSession session)
        {
            int topicid=Integer.parseInt(request.getParameter("tid"));
            int userid=Integer.parseInt(session.getAttribute("userid").toString());
            return serviceToUnsubscribe.unsubscribe(topicid,userid);

        }
        @RequestMapping(value = "/subscribetotopic",method = RequestMethod.GET)
    public @ResponseBody String subscribe(HttpSession session,HttpServletRequest request)
        {
            int userid=Integer.parseInt(session.getAttribute("userid").toString());
            System.out.println("@"+request.getParameter("tid")+"@");
            int topicid=Integer.parseInt(request.getParameter("tid"));
             return serviceToSubscribe.subscribe(topicid,userid);
        }

}
