package com.ttn.model.Impdao;

import com.ttn.beans.*;
import com.ttn.beans.Constants.Seriousness;
import com.ttn.model.dao.SubscribeToTopicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 7/18/2017.
 */
@Component
public class SubscribeToTopicDaoImp implements SubscribeToTopicDao {
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
    @Transactional(propagation = Propagation.REQUIRED)
    public String subscribe(int tid, int uid) {
        Session session=getSession();
        try
        {
            Susbcription susbcription=new Susbcription();
            ReadingItem readingItem=new ReadingItem();
            Topic topic=(Topic)session.get(Topic.class,tid);
            User user=(User)session.get(User.class,uid);
            susbcription.setDateCreated(new Date());
            susbcription.setSeriousness(Seriousness.VerySerious);
            susbcription.setTopic(topic);
            susbcription.setUser(user);
            session.save(susbcription);
            String q="from Resources where topic.id=:tid";
            Query query=session.createQuery(q);
            query.setInteger("tid",tid);
            List<Resources> list=query.list();
            for(Resources t: list)
            {
                readingItem.setResources(t);
                readingItem.setUser(user);
                readingItem.setRead(false);
                session.save(readingItem);
            }

            return "subscribed to topic";
        }
        catch (Exception e)
        {
            return "error";
        }
        finally {
            session.close();
        }

    }
    public String SubscribeToTopicByInvitation(String topicName, String createrName, String email) {
        Session session=getSession();
        try
        {
            String queryToFetchTopicId="select id from Topic where name=:topicname and createdBy.username=:creatername";
            Query query=session.createQuery(queryToFetchTopicId);
            query.setString("topicname",topicName);
            query.setString("creatername",createrName);
            Iterator iterator=query.iterate();
           int tid= (Integer)iterator.next();
           String queryToFetchUserId="select id from User where email =:mail";
           Query query1=session.createQuery(queryToFetchUserId);
            query1.setString("mail",email);
            iterator=query1.iterate();
            int uid=(Integer)iterator.next();
            String queryToCheckExistanceOfSubscription="from Susbcription where topic.id=:tid and user.id=:userid";
                    Query query2=session.createQuery(queryToCheckExistanceOfSubscription);
                    query2.setInteger("userid",uid);
                    query2.setInteger("tid",tid);
                    if(query2.list().isEmpty())
                    {
                        subscribe(tid,uid);
                        return "subscribe to topic successfully";

                    }
                    else
                    {
                        return "Already subscribed";
                    }

        }
        catch (Exception e)
        {
            System.out.println(e);
            return "unable to subscribe";
        }
        finally {
            session.close();
        }

    }
}
