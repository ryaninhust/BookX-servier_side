/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.access;

import com.xbook.entities.BookBook;
import com.xbook.entities.BookBookdetail;

import com.xbook.entities.BookOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author BlueBerry
 */
public class BookDetailDA {
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("BookXPU");
    EntityManager em=factory.createEntityManager();
    
    public BookBookdetail findBookDetailByID(Integer id){
    BookBookdetail bookBookdetail=   em.find(BookBookdetail.class, id);
    return  bookBookdetail;
    }
    public Integer createBookDetail(Integer useRate, String abstract1, Integer amount,  long  isbn){
    BookBookdetail bookBookdetail =new BookBookdetail();
    bookBookdetail.setAbstract1(abstract1);
    bookBookdetail.setAmount(amount);
    bookBookdetail.setUseRate(useRate);
    BookBook bookBook =em.find(BookBook.class,isbn);
    bookBookdetail.setIsbn(bookBook);
    em.persist(bookBookdetail);
    em.flush();
    Integer id=bookBookdetail.getId();
    Query query =em.createQuery("SELECT b FROM BookOrder b WHERE b.bookId = :book_id");
    query.setParameter("book_id", id);
    List<BookOrder> bookOrders=new ArrayList<BookOrder>();
    List list=query.getResultList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            BookOrder order = (BookOrder)it.next();
            bookOrders.add(order);
        }
    bookBookdetail.setBookOrderList(bookOrders);
    em.merge(bookBookdetail);
    return  id;
    
    }
    public boolean editBookDetail(Integer id,Integer useRate, String abstract1, Integer amount){
    BookBookdetail bookBookdetail=em.find(BookBookdetail.class, id);
        if (bookBookdetail!=null) {
            if (useRate==null) {
                bookBookdetail.setUseRate(bookBookdetail.getUseRate());
            } else {
                bookBookdetail.setUseRate(useRate);
            }
            if (abstract1==null) {
                bookBookdetail.setAbstract1(bookBookdetail.getAbstract1());
            } else {
                bookBookdetail.setAbstract1(abstract1);
            }
            if (amount==null) {
                bookBookdetail.setAmount(bookBookdetail.getAmount());
            } else {
                bookBookdetail.setAmount(amount);
            }
            return  true;
        } else {
            return  false;
        }
    
    
    
    }
    public boolean  removeBookDetail(Integer id){
    BookBookdetail bookBookdetail=   em.find(BookBookdetail.class, id);
        if (bookBookdetail!=null) {
            em.remove(bookBookdetail);
            return  true;
        } else {
            return  false;
        }
    
    
    }
}
