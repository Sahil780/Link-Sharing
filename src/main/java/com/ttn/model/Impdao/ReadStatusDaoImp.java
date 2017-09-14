package com.ttn.model.Impdao;

import com.ttn.model.dao.ReadStatusDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 7/16/2017.
 */
@Component
public class ReadStatusDaoImp implements ReadStatusDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String updateReadStatus(int readitemid,int userid) {
        Session session=getSession();
        try
        {
        String q="update ReadingItem set isRead =:readstatus where id =:rid and user.id=:uid";
        Query query=session.createQuery(q);
        query.setBoolean("readstatus",true);
        query.setInteger("uid",userid);
        query.setInteger("rid",readitemid);
        query.executeUpdate();
        return "marked as read";
       }
       catch (Exception e)
       {
           return "unsuccessfull operation";
       }
       finally {
            session.close();
        }
        }
}
