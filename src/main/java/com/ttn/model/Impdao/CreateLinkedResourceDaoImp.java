package com.ttn.model.Impdao;

import com.ttn.beans.*;
import com.ttn.beans.Constants.ResourceType;
import com.ttn.model.dao.CreateLinkedResourceDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class CreateLinkedResourceDaoImp implements CreateLinkedResourceDao {
    @Autowired
    SessionFactory sessionFactory;
@Autowired
ReadingItem readingItem;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String createLinkedResourceDao(com.ttn.beans.CreateLinkedResource createLinkedResource,int userid) {
        Session session = getSession();
        try {
            Query q = session.createQuery("select id from Topic where name =:tname and createdBy.username =:username");
            q.setParameter("tname", createLinkedResource.getTopicnameforlinkedresource().substring(13, createLinkedResource.getTopicnameforlinkedresource().indexOf(",")));
            q.setParameter("username", createLinkedResource.getTopicnameforlinkedresource().substring(createLinkedResource.getTopicnameforlinkedresource().indexOf(",") + 15
                    , createLinkedResource.getTopicnameforlinkedresource().length()));
            Resources resources = new Resources();
            User user = (User) session.get(User.class, userid);
            Iterator iterate = q.iterate();
            int tid = 0;
            while (iterate.hasNext()) {
                tid =(Integer) iterate.next();
            }
            Topic topic = (Topic) session.get(Topic.class, tid);
            resources.setCreatedBy(user);
            resources.setDescription(createLinkedResource.getDescription());
            resources.setDateCreated(new Date());
            resources.setResourcePath(createLinkedResource.getUrl());
            resources.setLastUpdated(new Date());
            resources.setTopic(topic);
            resources.setResourceType(ResourceType.LinkResource);
            session.save(resources);
            String sub="from Susbcription ";
            Query query=session.createQuery(sub);
            List<Susbcription> list=query.list();
            for(Susbcription susbcription:list) {
                readingItem.setRead(false);
                readingItem.setResources(resources);
                readingItem.setUser(susbcription.getUser());
                session.save(readingItem);
            }
            return "resource added succefully";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "unsuccessfull operation";
        }
        finally {
            session.close();
        }
    }

}
