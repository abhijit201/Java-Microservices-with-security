package com.olx.entity;

import javax.persistence.*;

@Entity(name = "EXPIRED_TOKEN")
public class ExpiredToken {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "expiredtoken_jwt")
    private String expiredtoken;

    public ExpiredToken() {

    }

    public ExpiredToken(String expiredtoken) {
        this.expiredtoken = expiredtoken;
    }

    public ExpiredToken(int id, String expiredtoken) {
        this.id = id;
        this.expiredtoken = expiredtoken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlacklistedJwt() {
        return expiredtoken;
    }

    public void setBlacklistedJwt(String expiredtoken) {
        this.expiredtoken = expiredtoken;
    }

    @Override
    public String toString() {
        return "ExpiredToken{" +
                "id=" + id +
                ", expiredtokenjwt='" + expiredtoken + '\'' +
                '}';
    }
}