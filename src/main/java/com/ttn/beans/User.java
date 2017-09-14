package com.ttn.beans;

import org.hibernate.annotations.Table;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
   private String email;
    @Column(nullable = false)
   private String username;
    @Column(nullable = false)
   private String firstname;
    @Column(nullable = false)
   private String lastname;
    @Column(nullable = false)
   private String password;
    @Lob
    @Column(name=("profile_pic"), nullable=false, columnDefinition="longblob")
   private byte[] photo;
    @Column(nullable = false)
   private boolean admin;
    @Column(nullable = false)
   private boolean active;
    @Column(nullable = false)
   private Date dateCreated;
    @Column(nullable = false)
   private Date lastCreateed;

public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastCreateed() {
        return lastCreateed;
    }

    public void setLastCreateed(Date lastCreateed) {
        this.lastCreateed = lastCreateed;
    }
}
