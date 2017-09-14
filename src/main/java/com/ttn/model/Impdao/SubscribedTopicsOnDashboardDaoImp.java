package com.ttn.model.Impdao;

import com.ttn.beans.Susbcription;
import com.ttn.model.dao.SubscribedTopicsOnDashboardDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/17/2017.
 */
@Component
public class SubscribedTopicsOnDashboardDaoImp implements SubscribedTopicsOnDashboardDao{
    @Autowired
    SessionFactory sessionFactory;
    //    @Autowired
//    User user;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public List<Susbcription> getSubscribedTopics(String username) {
        Session session=getSession();
        try
        {
            String query="from Susbcription where topic.createdBy.username =:uname ORDER BY topic.name asc";
            Query q=session.createQuery(query);
            q.setString("uname",username);

            return q.list();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        finally {
            session.close();
        }

    }
}
