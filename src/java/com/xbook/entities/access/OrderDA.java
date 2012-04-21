/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.access;


import com.xbook.entities.BookBookdetail;
import com.xbook.entities.BookOrder;
import com.xbook.entities.BookUsers;
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
public class OrderDA {
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("BookXPU");
    EntityManager em=factory.createEntityManager();

    public BookOrder findOrderByID(Integer id){
    BookOrder bookOrder =em.find(BookOrder.class, id);
    return  bookOrder;
    
    }
    
    //以后可以为卖书人建立接口,此处暂设买书人
    public  List<BookOrder> findOrdersByUserID(Integer wantID){
    List<BookOrder> bookOrders=new ArrayList<BookOrder>();
    
    UserDA userDA=new UserDA();
    BookUsers bookUsers=userDA.findUserByID(wantID);
    Query query= em.createQuery("SELECT b FROM BookOrder b WHERE b.wantUid = :want_uid");
    query.setParameter("want_uid", bookUsers);
    List list=query.getResultList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            BookOrder bookOrder = (BookOrder)it.next();
            bookOrders.add(bookOrder);
           
        }
    
    
    return  bookOrders;
    
    }
    
    public List<BookOrder> findUserOrderByStatues(Integer id,Integer statues){
    List<BookOrder> bookOrders=new ArrayList<BookOrder>();
     UserDA userDA=new UserDA();
    BookUsers bookUsers=userDA.findUserByID(id);
    Query query=em.createQuery("SELECT b FROM BookOrder b WHERE b.wantUid = :want_uid and b.staues = :staues");
       query.setParameter("want_uid", bookUsers);
    List list =query.getResultList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            BookOrder bookOrder =(BookOrder) it.next();
            bookOrders.add(bookOrder);
            
        }
    
    return  bookOrders;
    }
    
    
    public Integer createOrder(Float salePrice, Float needPrice, Integer saleEnsure, Integer saleGo, Integer wantGo, Date sDate, Date mDate, Date fDate, Integer staues, Integer wantUid, Integer saleUid, Integer bookId,Integer wantEnsure){
    BookOrder bookOrder=new BookOrder();
    bookOrder.setFDate(fDate);
    bookOrder.setMDate(mDate);
    bookOrder.setNeedPrice(needPrice);
    bookOrder.setSDate(sDate);
    bookOrder.setWantEnsure(wantEnsure);
    bookOrder.setSaleEnsure(saleEnsure);
    bookOrder.setSaleGo(saleGo);
    bookOrder.setSalePrice(salePrice);
    bookOrder.setStaues(staues);
    bookOrder.setWantGo(wantGo);
    BookUsers wantBookUsersbookUsers=em.find(BookUsers.class, wantUid);
    bookOrder.setWantUid(wantBookUsersbookUsers);
    BookUsers saleBookUsers=em.find(BookUsers.class, saleUid);
    bookOrder.setSaleUid(saleBookUsers);
    BookBookdetail bookBookdetail =em.find(BookBookdetail.class, bookId);
    bookOrder.setBookId(bookBookdetail);
    em.persist(bookOrder);
    em.flush();
    Integer id=bookOrder.getId();
    return  id;
    
        
            
    
    }
    public boolean editOrder(Integer id,Float salePrice, Float needPrice, Integer saleEnsure, Integer saleGo, Integer wantGo, Date sDate, Date mDate, Date fDate, Integer staues, Integer wantUid, Integer saleUid,Integer wantEnsure){
        BookOrder bookOrder=em.find(BookOrder.class, id);
        
        if (bookOrder!=null) {
            if (wantEnsure==null) {
                bookOrder.setWantEnsure(bookOrder.getWantEnsure());
            } else {
                bookOrder.setWantEnsure(wantEnsure);
            }
            if (salePrice==null) {
                bookOrder.setSalePrice(bookOrder.getSalePrice());
                
            } else {
                bookOrder.setSalePrice(salePrice);
            }
            if (needPrice==null) {
                bookOrder.setNeedPrice(bookOrder.getNeedPrice());
            } else {
                bookOrder.setNeedPrice(needPrice);
            }
            if (saleEnsure==null) {
                bookOrder.setSaleEnsure(bookOrder.getSaleEnsure());
            } else {
                bookOrder.setSaleEnsure(saleEnsure);
            }
            if (saleGo==null) {
                bookOrder.setSaleGo(bookOrder.getSaleGo());
                
                        
            } else {
                bookOrder.setSaleGo(saleGo);
                
            }
            if (wantGo==null) {
                bookOrder.setWantGo(bookOrder.getWantGo());
            } else {
                bookOrder.setWantGo(wantGo);
            }
            if (sDate==null) {
                bookOrder.setSDate(bookOrder.getSDate());
            } else {
                bookOrder.setSDate(sDate);
            }
            if (mDate==null) {
                bookOrder.setMDate(bookOrder.getMDate());
            } else {
                bookOrder.setMDate(mDate);
            }
            if (fDate==null) {
                bookOrder.setFDate(bookOrder.getFDate());
            } else {
                bookOrder.setFDate(fDate);
            }
            if (staues==null) {
                bookOrder.setStaues(bookOrder.getStaues());
            } else {
                bookOrder.setStaues(staues);
                      
            }
            if (wantUid==null) {
                bookOrder.setWantUid(bookOrder.getWantUid());
            } else {
                BookUsers bookUsers=em.find(BookUsers.class, wantUid);
                bookOrder.setWantUid(bookUsers);
            }
            if (saleUid==null) {
               bookOrder.setWantGo(bookOrder.getWantGo());
                
            } else { 
                BookUsers bookUsers=em.find(BookUsers.class,saleUid);
                bookOrder.setSaleUid(bookUsers);
            }
            em.merge(bookOrder);
            return  true;
        } else {
            return  false;
        }
    
    
    }
    public boolean  removeOrder(Integer id){
        BookOrder bookOrder=em.find(BookOrder.class, id);
        
        if (bookOrder!=null) {
            em.remove(bookOrder);
            return  true;
        } else {
            return  false;
        }
    
    
    
    }
}
