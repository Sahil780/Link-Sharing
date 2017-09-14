package com.ttn.controller;
import com.ttn.beans.ForgotPasswordVerification;
import com.ttn.beans.Login;
import com.ttn.beans.User;
import com.ttn.model.Impdao.uniqueusernameimp;
import com.ttn.model.dao.LoginAuthentication;
import com.ttn.model.dao.RegistrationDao;
import com.ttn.model.dao.Uniqueemail;
import com.ttn.model.dao.Uniqueusername;
import com.ttn.model.service.ServiceInterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
    @Autowired
    public LoginAuthentication loginAuthentication;
  @Autowired
  public RegistrationService registrationService;
@Autowired
public Uniqueusername uniqueusername;
@Autowired
public Uniqueemail uniqueemail;
@Autowired
public LoginService loginService;
@Autowired
public User user;
@Autowired
public ForgotPasswordService forgotPasswordService;
@Autowired
public SendPasswordVerificationCodeService sendPasswordVerificationCodeService;
@Autowired
    FetchUserInfoOnDashboard fetchUserInfoOnDashboard;
@Autowired
SubscriptionOnDashbard subscriptionOnDashbard;
@Autowired
PostCountOnDashboardService postCountOnDashboardService;
@Autowired
RescentShareOnHomePageService rescentShareOnHomePageService;

    @RequestMapping(value = "/")
    public ModelAndView showhomepage() {
        System.out.println("call to hua h");
   ModelAndView modelAndView=new ModelAndView("indexhome");
   modelAndView.addObject("recentresources",rescentShareOnHomePageService.getResources());
        return modelAndView;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute User user, BindingResult bindingResult,HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession session=request.getSession();
  ModelAndView modelAndView=null;
        if(bindingResult.hasErrors())
        {
            ModelAndView mav = new ModelAndView("homepage");
              return mav;
        }
        else {
            ModelAndView mav = null;
            List<User> userList = loginService.authenticationservice(user);
            if(!userList.isEmpty())
            {
                mav = new ModelAndView("dashboard");

                for(User user1:userList) {
                  mav.addObject("userinfo",fetchUserInfoOnDashboard.userInfoService(user1.getId()));
                  mav.addObject("subscribedTopics",subscriptionOnDashbard.getSubscribedTopics(user1.getUsername()));
                  mav.addObject("resources",postCountOnDashboardService.getResources());
                    mav.addObject("username",user1.getUsername());
                    mav.addObject("firstname",user1.getFirstname());
                    session.setAttribute("userinfo",fetchUserInfoOnDashboard.userInfoService(user1.getId()));
                    session.setAttribute("userid", user1.getId());
                    session.setAttribute("uname", user1.getUsername());
                    session.setAttribute("fname",user1.getFirstname());
                    modelAndView=mav;
                }
                mav.addObject("linktoallviewofsubscription","View all");
            }
            else
            {
                ModelAndView m= new ModelAndView("indexhome");
                m.addObject("recentresources",rescentShareOnHomePageService.getResources());
                modelAndView=m;
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registrationprocess", method = RequestMethod.POST)
    public ModelAndView registrationProcess(@ModelAttribute User user,@RequestParam("fileupload") MultipartFile[] fileUpload
                                            ,HttpSession session,
                                            HttpServletRequest request)throws Exception
    {
        ModelAndView mav = null;
        int flag=0;
        if ((fileUpload != null && fileUpload.length > 0 )) {
            for (MultipartFile aFile : fileUpload){
                if(aFile.getOriginalFilename().equals("")||aFile.getOriginalFilename()==null)
                {
                    flag=1;
                    break;
                }
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                user.setPhoto(aFile.getBytes());
            }
            System.out.println("length "+ fileUpload.length);
        }
        if(flag==1){
            File file=new File("E://defaultpic.png");
            FileInputStream fis=new FileInputStream(file);
            byte b[]=new byte[(int)file.length()];
            fis.read(b);
            user.setPhoto(b);
            System.out.println("aya to hai isme");
        }
        User u = registrationService.register(user);
                if (u != null) {
                    session=request.getSession();
                    mav = new ModelAndView("dashboard");
                    mav.addObject("ok", u.getFirstname());
                    mav.addObject("userinfo",fetchUserInfoOnDashboard.userInfoService(user.getId()));
                    mav.addObject("subscribedTopics",subscriptionOnDashbard.getSubscribedTopics(user.getUsername()));
                    mav.addObject("resources",postCountOnDashboardService.getResources());
                    mav.addObject("username",user.getUsername());
                    mav.addObject("firstname",user.getFirstname());
                    session.setAttribute("userinfo",fetchUserInfoOnDashboard.userInfoService(user.getId()));
                    session.setAttribute("userid", user.getId());
                    session.setAttribute("uname", user.getUsername());
                    session.setAttribute("fname",user.getFirstname());
                    return mav;

                } else {
                    mav = new ModelAndView("dashboard");
                    mav.addObject("error",  user.getUsername());
                    return mav;
                }
            }


            @RequestMapping(value = "/uniqueusername",method = RequestMethod.POST)
         public @ResponseBody String checkusername(HttpServletRequest request,HttpServletResponse response)throws Exception
            {
                if(uniqueusername.checkavailability(request.getParameter("val")))
                {
                    System.out.println("%%%%%%%%%%%5 not %%%%%%%%%%%%%%%%%%");
                    return "user name available";
                }
                else {
                    return "user name not available";

                }

            }

    @RequestMapping(value = "/uniqueemail",method = RequestMethod.POST)
    public @ResponseBody String checkemail(HttpServletRequest request,HttpServletResponse response)throws Exception
    {
        if(uniqueemail.checkemailavailability(request.getParameter("val")))
        {
            return "email id not available";
        }
        else
        {
            return "email id available";
        }


    }
    @RequestMapping(value = "/sendverificationcode",method = RequestMethod.POST)
    public @ResponseBody String sendVerificationcode(@ModelAttribute ForgotPasswordVerification forgotPasswordVerification, HttpServletResponse response) throws IOException {

        if(sendPasswordVerificationCodeService.checkemailid(forgotPasswordVerification.getUseremailid()))
        {
           return sendPasswordVerificationCodeService.sendVerificationCode(forgotPasswordVerification.getUseremailid());
        }
        else
        {
            return "email doest not exist in our database";
        }
    }
    @RequestMapping(value = "/updatepassword",method = RequestMethod.POST)
    public void updatePassword(String useremailid,String password,String verificationcode,
                               HttpServletResponse response,HttpServletRequest request) throws IOException {

        response.getWriter().write(forgotPasswordService.updatePassword(request.getParameter("email"),request.getParameter("password"),request.getParameter("verificationcode")));
    }

}