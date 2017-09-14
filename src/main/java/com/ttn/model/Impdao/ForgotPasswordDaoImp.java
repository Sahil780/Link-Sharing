package com.ttn.model.Impdao;

import com.ttn.beans.ForgotPasswordVerification;
import com.ttn.beans.User;
import com.ttn.model.dao.ForgotPasswordDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class ForgotPasswordDaoImp implements ForgotPasswordDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public String sendVerificationCode(String emailOfUser) {

        return null;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public String insertVerificationCode(String emailOfUser, String verificationcode) {
        Session session=getSession();
        try {
            Criteria otpalreadyexist=session.createCriteria(ForgotPasswordVerification.class);
            List<ForgotPasswordVerification> list=otpalreadyexist.add(Restrictions.eq("useremailid",emailOfUser)).list();
            if(list.isEmpty()) {
                ForgotPasswordVerification forgotPasswordVerification = new ForgotPasswordVerification();
                forgotPasswordVerification.setUseremailid(emailOfUser);
                forgotPasswordVerification.setVerificationcode(verificationcode);
                session.save(forgotPasswordVerification);
            }
            else
            {
              String update="update ForgotPasswordVerification set verificationcode =:code where useremailid =:useremailid";
              Query q=session.createQuery(update);
              q.setString("code",verificationcode).setString("useremailid",emailOfUser).executeUpdate();
            }
            return "verification code inserted";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "error in inserting verificaation code";
        }
        finally {
            session.close();
        }
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public String updatePasswoord(String emailofuser, String password,String verficationcode) {
        Session session=getSession();
        try {
            Criteria ct = session.createCriteria(ForgotPasswordVerification.class);
            List<ForgotPasswordVerification> list = ct.add(Restrictions.and(Restrictions.eq("useremailid", emailofuser)
                    , Restrictions.eq("verificationcode", verficationcode))).list();
            if (list.isEmpty()) {
                return " verification did not matched ";
            } else {
                String updatepassword = "update User u set u.password =:newpassword where u.email =:emailofuser";
                int updatestatus = session.createQuery(updatepassword).setString("newpassword", password).setString("emailofuser", emailofuser).executeUpdate();

            }

            return "password updated successfully";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "password did not updated due to some reason";
        }
        finally {
            session.close();
        }
    }

    public boolean checkemailid(String emailenteredbyuser) {
        Session session = getSession();
        Criteria ct = session.createCriteria(User.class);
        List<User> list = ct.add(Restrictions.eq("email", emailenteredbyuser)).list();
        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
