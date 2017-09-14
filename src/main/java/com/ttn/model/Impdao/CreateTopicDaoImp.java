package com.ttn.model.Impdao;

import com.ttn.beans.Constants.Seriousness;
import com.ttn.beans.Constants.Visibility;
import com.ttn.beans.ReadingItem;
import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import com.ttn.beans.User;
import com.ttn.model.dao.CreateTopicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by user on 7/9/2017.
 */
@Component
public class CreateTopicDaoImp implements CreateTopicDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public boolean createTopic(Topic topic,int userid) {
        Session session = getSession();
        try {
            topic.setDateCreated(new Date());
            topic.setLastUpdate(new Date());
            User user=(User)session.get(User.class,userid);
            topic.setCreatedBy(user);
            Susbcription susbcription=new Susbcription();
            susbcription.setDateCreated(new Date());
            susbcription.setTopic(topic);
            susbcription.setSeriousness(Seriousness.VerySerious);
            susbcription.setUser(user);
            session.save(topic);
            session.save(susbcription);
            return true;
        } catch (Exception e) {
            System.out.println("exception is " + e);
            return false;
        }
        finally {
            session.close();
        }
    }
    public boolean updateTopic(Topic topic) {
        return false;
    }
}
