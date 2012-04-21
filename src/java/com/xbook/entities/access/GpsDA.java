/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.access;

import com.xbook.entities.BookGps;
import com.xbook.entities.BookUsers;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author BlueBerry
 */

public class GpsDA {
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("BookXPU");
    EntityManager em=factory.createEntityManager();
  public GpsDA findGPSbyID(Integer id){
  GpsDA gpsDA=em.find(GpsDA.class, id);
  return  gpsDA;
   
  }
  public Integer  createGps(float gpsX, Float gpsY, String gpsName, Integer userId){
  BookGps bookGps=new BookGps();
  bookGps.setGpsName(gpsName);
  bookGps.setGpsX(gpsX);
  bookGps.setGpsY(gpsY);
  BookUsers users=em.find(BookUsers.class, userId);
      if (users!=null) {
          bookGps.setUserId(users);
          em.persist(bookGps);
          em.flush();
          Integer id=bookGps.getId();
          return  id;
      } 
      else {
          return  -1;
      }
  
  
  
  
  
  }
  //缺省用户修改
  public boolean editGps(Integer id, Float gpsX, Float gpsY, String gpsName){
  BookGps bookGps=em.find(BookGps.class, id);
      if (bookGps!=null) {
          if (gpsX==null) {
              bookGps.setGpsX(bookGps.getGpsX());
          } else {
              bookGps.setGpsX(gpsX);
          }
          if (gpsY==null) {
              bookGps.setGpsY(bookGps.getGpsX());
          } else {
              bookGps.setGpsY(gpsY);
          }
          if (gpsName==null) {
              bookGps.setGpsName(bookGps.getGpsName());
          } else {
              bookGps.setGpsName(gpsName);
          }
          return  true;
      } else {
          return  false;
      }
  
  
  
  
  
  }
  public boolean removeGps(Integer id){
  BookGps bookGps=em.find(BookGps.class, id);
      if (bookGps!=null) {
          em.remove(bookGps);
          return  true;
      } else {
          return  false;
      }
  
  
  
  }
 
}
