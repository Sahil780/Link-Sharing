package com.ttn.beans;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/4/2017.
 */
@Component
public class Login {
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
private String password;
private String authenticate;
private String view;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(String authenticate) {
        this.authenticate = authenticate;
    }

    public Login(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
