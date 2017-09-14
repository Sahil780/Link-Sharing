package com.ttn.model.Impdao;

import com.ttn.beans.Constants.Visibility;
import com.ttn.beans.ResourceRating;
import com.ttn.beans.Resources;
import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import com.ttn.model.dao.FetchAllTopicsOfUserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Component
public class FetchAllTopicsOfUserDaoImp implements FetchAllTopicsOfUserDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<Topic> getAllPublicTopics(String username, String currentusername,int firstresultindex) {
        Session session=getSession();
        try
        {
            String q="from Topic where createdBy.username=:username and visibililty=:vis";
            Query query=session.createQuery(q);
            query.setString("username",username);
            query.setParameter("vis", Visibility.Public);
            query.setFirstResult(2 * (firstresultindex - 1) + 1);
            query.setMaxResults(2);
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

    public List<Topic> getAllTopicsOfUser(String username, String currentUser,int firstresultindex) {
        Session session=getSession();
        try
        {
            String q="from Topic where createdBy.username=:username";
            Query query=session.createQuery(q);
            query.setString("username",username);
            query.setFirstResult(2 * (firstresultindex - 1) );
            query.setMaxResults(2);
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

    public Long getSubscriptionCount(int topicId) {
        Session session = getSession();
        try {
            String q = "select count(*) from Susbcription where topic.id=:topicid";
            Query query = session.createQuery(q);
            query.setInteger("topicid",topicId);
           return (Long)query.uniqueResult();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            session.close();
        }

    }

    public Long getPostCount(int topicId) {
        Session session=getSession();
        try
        {
            String q="select count(*) from Resources  where topic.id=:topicid";
            Query query=session.createQuery(q);
            query.setInteger("topicid",topicId);
            return (Long)query.uniqueResult();

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

    public boolean isSubscribedToTopic(int tid, String currentusername) {
        Session session=getSession();
        try
        {
            System.out.println("tid "+tid);
            System.out.println("uid "+currentusername);
            String q="from Susbcription where topic.id=:tid and user.username=:currentuser";
            Query query=session.createQuery(q);
            query.setInteger("tid",tid);
            query.setString("currentuser",currentusername);

                    if(!query.list().isEmpty()){
                        List<Susbcription> list=query.list();
                        for(Susbcription susbcription:list)
                        {
                            System.out.println(susbcription.getTopic()+"topic");
                            System.out.println(susbcription.getUser().getUsername()+"username");
                        }
                return true;
                    }
                    else
                    {
                        return false;
                    }

        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        finally {
            session.close();
        }

    }
}
