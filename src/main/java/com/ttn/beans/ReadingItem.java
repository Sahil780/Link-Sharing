package com.ttn.beans;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by user on 7/9/2017.
 */
@Entity
@Component
public class ReadingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;


    @OneToOne

    private Resources resources;
    @OneToOne
    private User user;
    @Column(nullable = false)
    private boolean isRead;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
