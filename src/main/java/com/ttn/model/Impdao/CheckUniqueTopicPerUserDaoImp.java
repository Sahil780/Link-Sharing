package com.ttn.model.Impdao;

import com.ttn.model.dao.CheckUniqueTopicPerUserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 7/16/2017.
 */
@Component
public class CheckUniqueTopicPerUserDaoImp implements CheckUniqueTopicPerUserDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public boolean checkAvailability(String topicname,String username) {
        Session session=getSession();
        try
        {
            String check="from Topic where name =:tname and createdBy.username =:uname";
            Query query=session.createQuery(check);
            query.setString("uname",username);
            query.setString("tname",topicname);
            if(query.list().isEmpty())
            {
                return false;
            }
            else {
                return true;
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
