/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.access;

import com.xbook.entities.BookGps;
import com.xbook.entities.BookOrder;
import com.xbook.entities.BookUsers;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;



/**
 *
 * @author BlueBerry
 */

public class UserDA {
    
//    @PersistenceContext(unitName="BookXPU")
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("BookXPU");
    EntityManager em=factory.createEntityManager();
    public  BookUsers findUserByID(Integer id){
    BookUsers bookUsers =em.find(BookUsers.class, id);
    return  bookUsers;
    
    
    }
    public BookUsers findUserLogin(String username,String passwprd){
    Query query=em.createQuery("SELECT b FROM BookUsers b WHERE b.password = :password and b.username = :username");
    query.setParameter("password", passwprd);
    query.setParameter("username", username);
    
        if (!query.getResultList().isEmpty()) {
            BookUsers bookUsers=(BookUsers)query.getSingleResult();
            return  bookUsers;
        } else {
            return  null;
        }
    
    }
  public   Integer createUser(String password, String username, Date firstLogin, String email, BigInteger qq, Integer account, Integer faith){
  BookUsers users=new BookUsers();
  users.setAccount(account);
  users.setEmail(email);
  users.setFaith(faith);
  users.setFirstLogin(firstLogin);
  users.setPassword(password);
  users.setQq(qq);
//  BookGps bookGps=em.find(BookGps.class, gpsId);
//  users.setGpsId(bookGps);
  em.persist(users);
//  em.flush();
  int id = users.getId();
  List<BookOrder> saleOrders=new ArrayList<BookOrder>();
  List<BookOrder> wantOrders=new ArrayList<BookOrder>();
  List<BookGps> bookGpses=new ArrayList<BookGps>();
  Query query2=em.createQuery("SELECT b FROM BookGps b WHERE b.userId = :id");
  query2.setParameter("id", id);
//  if(!query2.getResultList().isEmpty()){
////  BookGps gps=(BookGps)query2.getSingleResult();
////  users.setBookGpsList(gps);
//  
//  
//  }
  List list2=query2.getResultList();
      for (Iterator it = list2.iterator(); it.hasNext();) {
          BookGps Gps = (BookGps)it.next();
          bookGpses.add(Gps);
          
      }
      users.setBookGpsList(bookGpses);
  Query query  =   em.createQuery("SELECT b FROM BookOrder b WHERE b.saleUid = :sale_uid");
  query.setParameter("sale_uid", id);
  List list=query.getResultList();
  
      for (Iterator it = list.iterator(); it.hasNext();) {
          BookOrder order = (BookOrder)it.next();
          saleOrders.add(order);
          
      }
      users.setBookOrderList1(saleOrders);
  Query query1=em.createQuery("SELECT b FROM BookOrder b WHERE b.wantUid = :want_uid");
  query.setParameter("want_uid", id);
  List list1=query1.getResultList();
      for (Iterator it = list1.iterator(); it.hasNext();) {
          BookOrder order = (BookOrder)it.next();
          wantOrders.add(order);
          
      }
      users.setBookOrderList(wantOrders);
  em.merge(users);
  return  users.getId();
  
  }
  public boolean editUser(Integer id,String password, String username, Date firstLogin, String email, BigInteger qq, Integer account, Integer faith){
  BookUsers users=em.find(BookUsers.class, id);
  if(users!=null){
      if (account==null) {
          users.setAccount(users.getAccount());
      } else {
          users.setAccount(account);
      }
      if (email==null) {
          users.setEmail(users.getEmail());
      } else {
          users.setEmail(email);
      }
 
      if (faith==null) {
         users.setFaith(users.getFaith()); 
      } else {
          users.setFaith(faith);
      }
      if (firstLogin==null) {
          users.setFirstLogin(users.getFirstLogin());
      } else {
          users.setFirstLogin(firstLogin);
      }
      if (password==null) {
          users.setPassword(users.getPassword());
      } else {
          users.setPassword(password);
      }
      if (qq==null) {
          users.setQq(users.getQq());
      } else {
          users.setQq(qq);
      }
      if (username==null) {
          users.setUsername(users.getUsername());
      } else {
          users.setUsername(username);
      }
  
  em.merge(users);
  return  true;
  
  
  
  }
  else{
  return  false;
  
  }

  }
  public boolean removeUser(Integer id){
  BookUsers users=em.find(BookUsers.class, id);
      if (users!=null) {
          em.remove(users);
          return  true;
      } else {
          return  false;
      }
  
  
  }
}
  