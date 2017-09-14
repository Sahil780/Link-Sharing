package com.ttn.model.Impdao;

import com.ttn.beans.Resources;
import com.ttn.model.dao.UnsubsribeDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 7/18/2017.
 */
@Component
public class UnsubscribeDaoImp implements UnsubsribeDao {
    @Autowired
    SessionFactory sessionFactory;
    /*  @Autowired
       User user;*/
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
@Transactional(propagation = Propagation.REQUIRED)
    public String unsubscribe(int topicid, int userid) {
        Session session=getSession();
        try
        {
            String q="delete from Susbcription where topic.id =:tid and user.id=:uid";
            Query query=session.createQuery(q);
            query.setInteger("tid",topicid);
            query.setInteger("uid",userid);
            query.executeUpdate();
//            als0 updating table of readingitem  ///
//            deleting the user correspond to that resource from reading item ////
            String id="from Resources where topic.id=:tid";
            Query query2=session.createQuery(id);
            query2.setInteger("tid",topicid);
            List<Resources> list=query2.list();
         for(Resources resources:list) {
             String r = "delete from ReadingItem where  resources.id=:rid and user.id=:uid";
             Query query1 = session.createQuery(r);
             query1.setParameter("rid", resources.getId());
             query1.setInteger("uid", userid);
             query1.executeUpdate();
         }
            return "unsubscibed from  topic";
        }
        catch (Exception e)
        {
            System.out.println("error is "+e);
            return "error while unsubscribing from topic";
        }
        finally {
            session.close();
        }

    }
}
