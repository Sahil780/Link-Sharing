package com.ttn.controller;

import com.ttn.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 7/6/2017.
 */
@Controller
public class formcontroller {
@RequestMapping(value = "/savedata",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("lo") Login lo)
{
    ModelAndView mav=new ModelAndView("HelloWorldPage");
    mav.addObject("msg",lo);
    return mav;
}

}
