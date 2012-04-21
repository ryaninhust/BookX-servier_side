/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.sessions;


import com.xbook.entities.BookUsers;
import com.xbook.entities.access.UserDA;
import com.xbook.returnutil.UserInfo;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author BlueBerry
 */
@Stateless
@Path("user")
public class UserMangement implements UserMangementLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public  UserDA userDA;
   @PostConstruct
   public void init(){
   userDA=new UserDA();
   }
   
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public UserInfo findByUserInfo(@QueryParam("id") Integer id){
//    UserDA userDA=new UserDA();
    BookUsers bookUsers=userDA.findUserByID(id);
    UserInfo userInfo =new UserInfo();
    if (bookUsers!=null) {
           userInfo.setEmail(bookUsers.getEmail());
           userInfo.setFaith(bookUsers.getFaith());
           userInfo.setFirstLogin(bookUsers.getFirstLogin());
           userInfo.setQq(bookUsers.getQq());
           userInfo.setAccount(bookUsers.getAccount());
           userInfo.setUserName(bookUsers.getUsername());
           
       } else {
           userInfo=null;
           
       }
    return  userInfo;
    }
    
    
    
    
    
    
    
    
    
//   @GET
//   @Produces(MediaType.APPLICATION_JSON)
//   @Override
//   public UserInfo LoginIn(@QueryParam("username")String username,@QueryParam("password")String password){
//   UserInfo userInfo=new UserInfo();
////   UserDA userDA=new UserDA();
//   BookUsers bookUsers=userDA.findUserLogin(username, password);
//       if (bookUsers!=null) {
//           userInfo.setEmail(bookUsers.getEmail());
//           userInfo.setFaith(bookUsers.getFaith());
//           userInfo.setFirstLogin(bookUsers.getFirstLogin());
//           userInfo.setQq(bookUsers.getQq());
//           userInfo.setAccount(bookUsers.getAccount());
//           userInfo.setUserName(bookUsers.getUsername());
//           
//       } else {
//           userInfo=null;
//           
//       }
//       return  userInfo;
//   }

@POST   
@Produces(MediaType.APPLICATION_JSON)
 @Override
  public UserInfo SignUp(@QueryParam("password")String password, @QueryParam("username")String username,@QueryParam("email") String email, @QueryParam("qq") BigInteger qq,@QueryParam("account") Integer account, @QueryParam("faith")Integer faith){
   Date firstLoginDate=new Date();
   UserInfo userInfo=new UserInfo();
//   UserDA userDA=new UserDA();
   Integer id=userDA.createUser(password, username, firstLoginDate, email, qq, account, faith);
   BookUsers bookUsers=userDA.findUserByID(id);
    if (bookUsers!=null) {
           userInfo.setEmail(bookUsers.getEmail());
           userInfo.setFaith(bookUsers.getFaith());
           userInfo.setFirstLogin(bookUsers.getFirstLogin());
           userInfo.setQq(bookUsers.getQq());
           userInfo.setAccount(bookUsers.getAccount());
           userInfo.setUserName(bookUsers.getUsername());
    } else {
        userInfo=null;
    }
   
   return  userInfo;
   }
@PUT
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
    @Override
public UserInfo CompleteInfo(@PathParam("id")Integer id,  @QueryParam("password")String password, @QueryParam("username")String username,@QueryParam("email") String email, @QueryParam("qq") BigInteger qq,@QueryParam("account") Integer account, @QueryParam("faith")Integer faith,@QueryParam("firlstlogin") Date firstLoginDate){
boolean flag;
UserInfo userInfo=new UserInfo();
//UserDA userDA=new UserDA();
flag=userDA.editUser(id, password, username, firstLoginDate, email, qq, account, faith);
    if (flag) {
          BookUsers bookUsers=userDA.findUserByID(id);
          userInfo.setEmail(bookUsers.getEmail());
          userInfo.setFaith(bookUsers.getFaith());
          userInfo.setFirstLogin(bookUsers.getFirstLogin());
          userInfo.setQq(bookUsers.getQq());
          userInfo.setAccount(bookUsers.getAccount());
          userInfo.setUserName(bookUsers.getUsername());
    } else {
        userInfo=null;
    }



return  userInfo;




}
@DELETE
@Produces(MediaType.APPLICATION_JSON)
    @Override
public boolean  removeUser(@ QueryParam("id") Integer id){
boolean flag;
//UserDA userDA=new UserDA();
flag=userDA.removeUser(id);
return  flag;


}
}
