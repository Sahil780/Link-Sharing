package com.ttn.model.Impdao;

import com.ttn.beans.Constants.Visibility;
import com.ttn.beans.Topic;
import com.ttn.beans.User;
import com.ttn.model.dao.FindPublicTopics;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/10/2017.
 */
@Component
public class FindPublicTopicsImp implements FindPublicTopics {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public   List<Topic> getPublicTopics(String topicname) {
        Session session=getSession();
        String hql="select name,createdBy.username from Topic where name like :tname and visibililty =:vis";
        Query query=session.createQuery(hql);
        query.setString("tname",topicname+"%");
        query.setParameter("vis",Visibility.Public);
        List<Topic> list=query.list();
        System.out.println("aaya to bhi aya to");
        session.close();
        return list;
    }
}
