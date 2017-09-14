package com.ttn.model.Impdao;

import com.ttn.beans.ReadingItem;
import com.ttn.model.dao.ShowPostOnUserProfilePageDao;
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
public class ShowPostOnUserProfilePageeDaoImp implements ShowPostOnUserProfilePageDao {
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
    public List<ReadingItem> getResources(String username, int firstresultindex) {
        Session session=getSession();
        try
        {
            String query="from ReadingItem where isRead =:readstatus and user.username =:uname";
            Query query1=session.createQuery(query);
            query1.setString("uname",username);
            query1.setBoolean("readstatus",false);
            query1.setFirstResult(5 * (firstresultindex - 1) + 1);
            query1.setMaxResults(5);
            return query1.list();
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
