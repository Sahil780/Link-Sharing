package com.ttn.beans;

import com.ttn.beans.Constants.ResourceType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 7/9/2017.
 */
@Entity
@Component
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false)
    private int id;
    @Column(nullable = false,length = 2000)
    private String description;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Topic topic;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(nullable = false)
    private String resourcePath;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
