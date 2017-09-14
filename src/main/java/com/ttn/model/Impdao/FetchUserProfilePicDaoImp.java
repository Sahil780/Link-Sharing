package com.ttn.model.Impdao;

import com.ttn.beans.User;
import com.ttn.model.dao.FetchUserProfilePicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/15/2017.
 */
@Component
public class FetchUserProfilePicDaoImp implements FetchUserProfilePicDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public byte[] fetchUserProfilePic(String uname) {
        Session session=getSession();

        String fetchprofilepic=" from User where username =:name";
        Query query=session.createQuery(fetchprofilepic);
        query.setString("name",uname);
        List<User> list=query.list();
        System.out.println("aa gya");
        byte pic[]=null;
        for(User user:list)
        {
            System.out.println(user.getFirstname());
            pic=user.getPhoto();

        }
        return pic;
    }
}
