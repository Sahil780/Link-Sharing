package com.ttn.beans;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by user on 7/13/2017.
 */
@Entity
@Component
public class ForgotPasswordVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(nullable = false)
    String useremailid;
    @Column(nullable = false)
    String verificationcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUseremailid() {
        return useremailid;
    }

    public void setUseremailid(String useremailid) {
        this.useremailid = useremailid;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }
}
