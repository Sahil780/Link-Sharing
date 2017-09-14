package com.ttn.model.Impdao;

import com.ttn.beans.Susbcription;
import com.ttn.model.dao.FetchSubscribedTopicsDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/16/2017.
 */
@Component
public class FetchSubscribedTopicsDaoImp implements FetchSubscribedTopicsDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public List<Susbcription> getTopics(String topicname,String username) {
        Session session=getSession();
        try
        {
            System.out.println("topic name "+topicname );
            System.out.println("user name "+username);
            Query query=session.createQuery("from Susbcription where user.username =:uname and topic.name like :name");
            query.setParameter("uname",username);
            query.setString("name",topicname+"%");
            List<Susbcription> list=query.list();
            for (Susbcription susbcription:list)
            {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(susbcription.getTopic().getName());
            }
            return query.list();
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
