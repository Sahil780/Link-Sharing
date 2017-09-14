package com.ttn.controller;

import com.ttn.beans.CreateDocumentResource;
import com.ttn.beans.CreateLinkedResource;
import com.ttn.model.service.ServiceInterface.CreateDocumentResourceService;
import com.ttn.model.service.ServiceInterface.CreateLinkedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created by user on 7/13/2017.
 */
@Controller
public class ResourceController {
    @Autowired
    CreateLinkedResourceService createLinkedResourceService;
    @Autowired
    CreateDocumentResourceService createDocumentResourceService;
    @RequestMapping(value = "/createLinkedResource",method = RequestMethod.POST)
    public void createLinkedResource(@ModelAttribute CreateLinkedResource createLinkedResource, HttpSession session, HttpServletResponse response)
    {
        int userid=(Integer) session.getAttribute("userid");
        try {
            response.getWriter().write(createLinkedResourceService.createLinkedResourceService(createLinkedResource,userid));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @RequestMapping(value = "/createDocumentResource",method = RequestMethod.POST)
    public void createDocumentResource(@ModelAttribute CreateDocumentResource createDocumentResource, HttpSession session
            , HttpServletResponse response, @RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        Random random=new Random();
        int randomnumber=random.nextInt(100000);
        int userid=(Integer) session.getAttribute("userid");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File serverFile = new File("D:/spring2-mvc-xml/src/main/webapp/resources/assets/" +randomnumber+ file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                System.out.println("Server File Location="
                        +" D:/spring2-mvc-xml/src/main/webapp/resources/assets/");
                createDocumentResource.setFilepath("D:/spring2-mvc-xml/src/main/webapp/resources/assets/" +randomnumber+ file.getOriginalFilename());
                response.getWriter().write(createDocumentResourceService.createDocumentResource(createDocumentResource,userid));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                response.getWriter().write("not uploaded");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

