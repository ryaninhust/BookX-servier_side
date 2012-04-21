/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.access;


import com.xbook.entities.BookBook;
import com.xbook.entities.BookBookdetail;
import java.util.ArrayList;
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

public class BookDA {
    
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("BookXPU");
    EntityManager em=factory.createEntityManager();

   public BookBook findBookByID(Long id){
   BookBook book= em.find(BookBook.class, id);
   
   return book;
   
   }
   public long  createBook(Long isbn, Integer dealTotal, Integer saleTotal, Integer salePrice, Integer dealPrice){
   BookBook book=new BookBook();
   book.setDealTotal(dealTotal);
   book.setSalePrice(salePrice);
   book.setDealTotal(dealTotal);
   book.setDealPrice(dealPrice);
   book.setIsbn(isbn);
   List<BookBookdetail> list=new ArrayList<BookBookdetail>();
   em.persist(book);
//   em.flush();
  
   Query query =em.createQuery("SELECT b FROM BookBook b WHERE b.isbn = :isbn");
   query.setParameter("isbn",isbn );
   List list1=query.getResultList();
       for (Iterator it = list.iterator(); it.hasNext();) {
           BookBook book1 = (BookBook)it.next();
           list1.add(book1);
       }
       book.setBookBookdetailList(list);
   em.merge(book);
   return  book.getIsbn();
  
   
   
   
   
   
   }
   public boolean editBook(long isbn ,Integer dealTotal, Integer saleTotal, Integer salePrice, Integer dealPrice){
   BookBook book=em. find(BookBook.class, isbn);
       if (book!=null) {
           if (dealTotal==null) {
               book.setDealTotal(book.getDealTotal());
           } else {
               book.setDealTotal(dealTotal);
           }
           if (saleTotal==null) {
               book.setSaleTotal(book.getSaleTotal());
           } else {
               book.setSaleTotal(saleTotal);
           }
           if (salePrice==null) {
              book.setSalePrice(book.getDealPrice());
           } else {
               book.setSalePrice(salePrice);
           }
           if (dealPrice==null) {
             book.setDealPrice(book.getDealPrice());
           } 
           else {
               book.setDealPrice(dealPrice);
           }
           em.merge(book);
           
           
            return  true;
       } else {
           return  false;
       }
       
       
       
       
       
   
  
   }
   public boolean removeBook(long isbn){
   BookBook book=em.find(BookBook.class, isbn);
       if (book!=null) {
           em.remove(book);
           return  true;
       } else {
           return  false;
       }
   
   
   
   }
}
