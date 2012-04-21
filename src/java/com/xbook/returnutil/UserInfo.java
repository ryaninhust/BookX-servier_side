/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.returnutil;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author BlueBerry
 */
public class UserInfo {
    private  String userName;
    private  Date firstLogin;
    private  String email;
    private  BigInteger qq;
    private  Integer faith;
    private  Integer account;

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFaith() {
        return faith;
    }

    public void setFaith(Integer faith) {
        this.faith = faith;
    }

    public Date getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public BigInteger getQq() {
        return qq;
    }

    public void setQq(BigInteger qq) {
        this.qq = qq;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
