package com.ttn.beans;

import com.ttn.beans.Constants.Visibility;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by user on 7/9/2017.
 */
@Entity
@Component
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private User createdBy;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Visibility visibililty;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Visibility getVisibililty() {
        return visibililty;
    }

    public void setVisibililty(Visibility visibililty) {
        this.visibililty = visibililty;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;

    }
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
