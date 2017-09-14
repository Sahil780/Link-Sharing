package com.ttn.model.Impdao;

import com.ttn.beans.Login;
import com.ttn.beans.User;
import com.ttn.model.dao.LoginAuthentication;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created by user on 7/1/2017.
 */

@Component
public class LoginAuthenticationimp
        implements LoginAuthentication {


    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<User> Authenticate(User user) {

        List<User> list=null;
        try {
           Criteria ct = getSession().createCriteria(User.class);
            list=   ct.add(Restrictions.and(Restrictions.eq("username",user.getUsername()), Restrictions.eq("password", user.getPassword()))).list();

        } catch (Exception e) {
            System.out.println("  exception occures -----------------------   ");

        } finally {
            getSession().close();
        }
return list;
    }

}
