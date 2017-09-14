package com.ttn.controller;

import com.ttn.model.service.ServiceInterface.FetchUserProfilePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 7/15/2017.
 */
@Controller
public class UserProfilePicFetchController {
    @Autowired
    FetchUserProfilePicService fetchUserProfilePicService;
    @RequestMapping(value = "/UserProfilePic")
    public void fetchUserProfilePic(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        System.out.println("**** hare krishna ****");
        System.out.println(request.getParameter("uname"));
        byte pic[]=fetchUserProfilePicService.fetchUserProfilePic(request.getParameter("uname"));
        try {
            response.getOutputStream().write(pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
