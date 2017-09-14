package com.ttn.model.Impdao;

import com.ttn.beans.*;
import com.ttn.beans.Constants.ResourceType;
import com.ttn.model.dao.CreateDocumentResourceDao;
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
public class CreateDocumentRsourceDaoImp implements CreateDocumentResourceDao {
    @Autowired
    SessionFactory sessionFactory;
   @Autowired
   ReadingItem readingItem;
   @Autowired
   Resources resources;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public String CreateDocumentResource(CreateDocumentResource createDocumentResource, int userid) {
        Session session = getSession();
        try {
            System.out.println("topic and user name");
            System.out.println(createDocumentResource.getTopicnamefordocumentresource());
            System.out.println("a"+createDocumentResource.getTopicnamefordocumentresource().substring(13, createDocumentResource.getTopicnamefordocumentresource().indexOf(","))+"b");

            System.out.println(createDocumentResource.getTopicnamefordocumentresource().substring(createDocumentResource.getTopicnamefordocumentresource().indexOf(",") + 15
                    , createDocumentResource.getTopicnamefordocumentresource().length()));
            Query q = session.createQuery("select id from Topic where name =:tname and createdBy.username =:username");
            q.setParameter("tname", createDocumentResource.getTopicnamefordocumentresource().substring(13, createDocumentResource.getTopicnamefordocumentresource().indexOf(",")));
            q.setParameter("username", createDocumentResource.getTopicnamefordocumentresource().substring(createDocumentResource.getTopicnamefordocumentresource().indexOf(",")+15
                    , createDocumentResource.getTopicnamefordocumentresource().length()));
            User user = (User) session.get(User.class, userid);
            Iterator iterate = q.iterate();
            int tid = 0;
            while (iterate.hasNext()) {
                tid = (Integer) iterate.next();
            }
            Topic topic = (Topic) session.get(Topic.class, tid);
            resources.setCreatedBy(user);
            resources.setDescription(createDocumentResource.getDescription());
            resources.setDateCreated(new Date());
            resources.setLastUpdated(new Date());
            resources.setResourcePath(createDocumentResource.getFilepath());
            resources.setTopic(topic);
            resources.setResourceType(ResourceType.DocumentResource);
            session.save(resources);
            String sub="from Susbcription where topic.id =:tid";
            Query query=session.createQuery(sub);
            query.setInteger("tid",tid);
            List<Susbcription> list=query.list();
            for(Susbcription susbcription:list) {
                readingItem.setRead(false);
                readingItem.setResources(resources);
                readingItem.setUser(susbcription.getUser());
                session.save(readingItem);
            }
            return "resource created successfully";
        } catch (Exception e) {
            System.out.println(e);
            return "unsuccessfull operation";
        }
        finally {
            session.close();
        }
    }
}
