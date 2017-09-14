package com.ttn.model.Impdao;

import com.ttn.beans.Resources;
import com.ttn.model.dao.PostCountOnDashboardDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/18/2017.
 */
@Component
public class PostCountOnDashboardDaoImp implements PostCountOnDashboardDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public List<Resources> getResources() {
        Session session=getSession();
        try
        {
            String q="from Resources";
            Query query=session.createQuery(q);
            return query.list();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }

    }
}
