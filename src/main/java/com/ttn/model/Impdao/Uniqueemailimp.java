package com.ttn.model.Impdao;

import com.ttn.beans.User;
import com.ttn.model.dao.Uniqueemail;
import org.hibernate.Criteria;
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
public class Uniqueemailimp implements Uniqueemail {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    User user;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public boolean checkemailavailability(String email) {
        Session ss=getSession();
        Criteria ct=ss.createCriteria(User.class);
        List<User> list=ct.add(Restrictions.eq("email",email)).list();
        if(list.isEmpty())
        {
            return false;
        }
        else {
            return true;
        }


    }
}
