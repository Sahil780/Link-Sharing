package com.ttn.model.Impdao;

import com.ttn.beans.User;
import com.ttn.model.dao.RegistrationDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 7/2/2017.
 */
@Component
public class RegistrationDaoImp implements RegistrationDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public User register(User u) {
        Session ss=getSession();
        try {

   ss.beginTransaction();
            u.setDateCreated(new Date());
            u.setLastCreateed(new Date());
            u.setActive(true);
            u.setAdmin(false);
           ss.save(u);
            ss.getTransaction().commit();
            System.out.println("inserted");
            return u;
        }
        catch (Exception e)
        {
            System.out.println(" error is --> "+e );
            return u;
        }
        finally {
            ss.close();

        }


    }
}
