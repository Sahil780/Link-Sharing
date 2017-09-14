package com.ttn.model.Impdao;

import com.ttn.beans.Resources;
import com.ttn.model.dao.RecentShareOnHomePageDao;
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
public class RecentShareOnHomePageDaoImp implements RecentShareOnHomePageDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<Resources> getRsources() {
        Session session=getSession();
        try {
            String q="from Resources order by dateCreated desc";
            Query query=session.createQuery(q);
            query.setMaxResults(5);
            return query.list();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        finally {
            session.close();
        }}
}
