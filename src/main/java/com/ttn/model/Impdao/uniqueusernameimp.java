package com.ttn.model.Impdao;

import com.ttn.beans.User;
import com.ttn.model.dao.Uniqueusername;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/3/2017.
 */
@Component
public class uniqueusernameimp implements Uniqueusername {

    @Autowired
    SessionFactory sessionFactory;
 /*  @Autowired
    User user;*/
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public boolean checkavailability(String username) {
   Session ss=getSession();
        Query query=ss.createQuery("from User where username=:username");
        query.setString("username",username);
        System.out.println("input "+username);
        List<User> list=query.list();
   for (User user:list)
        {
            System.out.println(user.getUsername()+"&&&");
        }
       return list.isEmpty();
    }
}
