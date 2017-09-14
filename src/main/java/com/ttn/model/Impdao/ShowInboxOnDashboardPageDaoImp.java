package com.ttn.model.Impdao;

import com.ttn.beans.ReadingItem;
import com.ttn.beans.User;
import com.ttn.model.dao.ShowInboxOnDashboardPageDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class ShowInboxOnDashboardPageDaoImp implements ShowInboxOnDashboardPageDao {
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
        List<ReadingItem> resources=null;
        try
        {
        String query="from ReadingItem where isRead =:readstatus and user.username =:uname";
        Query query1=session.createQuery(query);
        query1.setString("uname",username);
        query1.setBoolean("readstatus",false);
        query1.setFirstResult(5 * (firstresultindex - 1));
        query1.setMaxResults(5);
        resources=query1.list();
        return resources;
        }catch (Exception e)
        {
            System.out.println(e);
            return resources;
        }
        finally {
            session.close();
        }
        }
}
