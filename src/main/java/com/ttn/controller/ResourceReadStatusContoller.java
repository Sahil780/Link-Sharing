package com.ttn.controller;

import com.ttn.model.service.ServiceInterface.ReadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 7/16/2017.
 */
@Controller
public class ResourceReadStatusContoller {
   @Autowired
    ReadStatusService readStatusService;
    @RequestMapping(value = "/readstatus",method = RequestMethod.GET)
    public @ResponseBody String updateReadStatus(HttpServletRequest request, HttpSession session)
    {
        System.out.println(session.getAttribute("userid").toString());
        int readitemid=Integer.parseInt(request.getParameter("rid"));
        int userid=Integer.parseInt(session.getAttribute("userid").toString());
      return readStatusService.updateReadStatusService(readitemid,userid);
    }
}
