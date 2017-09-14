package com.ttn.model.Impdao;

import com.ttn.beans.User;
import com.ttn.model.dao.UpdateProfileDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 7/20/2017.
 */
@Component
public class UpdateProfileDaoImp implements UpdateProfileDao {
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
    public String updateProfile(User user,int userid) {

        Session session=getSession();
        try
        {
            String updateQuery="update User set username=:uname,firstname=:fname,lastname=:lname,photo=:pic where id=:uid";
            Query query=session.createQuery(updateQuery);
            query.setString("uname",user.getUsername());
            query.setString("fname",user.getFirstname());
            query.setString("lname",user.getLastname());
            query.setBinary("pic",user.getPhoto());
            query.setInteger("uid",userid);
            query.executeUpdate();
            return "updated";
        }
        catch (Exception e)
        {
            System.out.println(e);
         return "error";
        }
        finally {
            session.close();
        }

    }

    public String updatePassword(String password, int userid) {
        Session session=getSession();
        try
        {
            String updatePassword="update User set password=:newpassword where id=:uid";
            Query query=session.createQuery(updatePassword);
            query.setInteger("uid",userid);
            query.setString("newpassword",password);
            query.executeUpdate();
            return "password updated successfully";

        }
        catch (Exception e)
        {
            System.out.println(e);
            return "error";
        }
        finally {
            session.close();
        }
    }
}
