package com.ttn.beans;

import com.ttn.beans.Constants.Seriousness;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 7/9/2017.
 */
@Entity
@Component
public class Susbcription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
   private int id;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private User user;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Seriousness seriousness;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setSeriousness(Seriousness seriousness)
    {
        this.seriousness=seriousness;

    }
    public Seriousness getSeriousness()
    {
        return seriousness;
    }
}
