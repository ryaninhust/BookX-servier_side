/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.sessions;

import javax.ejb.Local;

/**
 *
 * @author BlueBerry
 */
@Local
public interface UserMangementLocal {

//    public com.xbook.returnutil.UserInfo LoginIn(java.lang.String username, java.lang.String password);
    @javax.ws.rs.POST
    @javax.ws.rs.Produces(value = {"application/json"})
    public com.xbook.returnutil.UserInfo SignUp(@javax.ws.rs.QueryParam(value = "password") java.lang.String password, @javax.ws.rs.QueryParam(value = "username") java.lang.String username, @javax.ws.rs.QueryParam(value = "email") java.lang.String email, @javax.ws.rs.QueryParam(value = "qq") java.math.BigInteger qq, @javax.ws.rs.QueryParam(value = "account") java.lang.Integer account, @javax.ws.rs.QueryParam(value = "faith") java.lang.Integer faith);

    @javax.ws.rs.PUT
    @javax.ws.rs.Produces(value = {"application/json"})
    public com.xbook.returnutil.UserInfo CompleteInfo(@javax.ws.rs.QueryParam(value = "id") java.lang.Integer id, @javax.ws.rs.QueryParam(value = "password") java.lang.String password, @javax.ws.rs.QueryParam(value = "username") java.lang.String username, @javax.ws.rs.QueryParam(value = "email") java.lang.String email, @javax.ws.rs.QueryParam(value = "qq") java.math.BigInteger qq, @javax.ws.rs.QueryParam(value = "account") java.lang.Integer account, @javax.ws.rs.QueryParam(value = "faith") java.lang.Integer faith, @javax.ws.rs.QueryParam(value = "firlstlogin") java.util.Date firstLoginDate);

    @javax.ws.rs.DELETE
    @javax.ws.rs.Produces(value = {"application/json"})
    public boolean removeUser(@javax.ws.rs.QueryParam(value = "id") java.lang.Integer id);

    @javax.ws.rs.GET
    @javax.ws.rs.Produces(value = {"application/json"})
    public com.xbook.returnutil.UserInfo findByUserInfo(@javax.ws.rs.QueryParam(value = "id") java.lang.Integer id);
    
}
