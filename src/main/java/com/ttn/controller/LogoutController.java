package com.ttn.controller;

import com.ttn.model.service.ServiceInterface.RescentShareOnHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 7/15/2017.
 */
@Controller

public class LogoutController {
    @Autowired
    RescentShareOnHomePageService rescentShareOnHomePageService;
    @RequestMapping(value = "/logout")

    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,
                               @CookieValue(value = "linksharingusername", defaultValue = "def123") String username,
                               @CookieValue(value = "linksharingpassword",defaultValue = "pas123") String password)
    {
        response.addCookie(new Cookie("linksharingusername","def123"));
        response.addCookie(new Cookie("linksharingpassword","pas123"));
       HttpSession session=request.getSession();
       session.setAttribute("login",null);
  session.invalidate();
        ModelAndView mav=new ModelAndView("indexhome");
        mav.addObject("msg","you are successfully log out");
        mav.addObject("recentresources",rescentShareOnHomePageService.getResources());
        return mav;
    }
}
