/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.sessions;

import com.xbook.entities.BookBook;
import com.xbook.entities.BookBookdetail;
import com.xbook.entities.BookOrder;
import com.xbook.entities.access.BookDA;
import com.xbook.entities.access.BookDetailDA;
import com.xbook.entities.access.OrderDA;
import com.xbook.returnutil.OderInfo;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author BlueBerry
 */
@Stateless
@LocalBean
@Path("orderplus")
public class OrderPlus {
     public  OrderDA orderDA;
     public  BookDA   bookDA;
     public  BookDetailDA bookDetailDA;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    
    public void init(){
    orderDA =new OrderDA();
    bookDA=new BookDA();
    bookDetailDA =new BookDetailDA();
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public OderInfo addOrder(@QueryParam("abstract")String asString,@QueryParam("isbn")Long isbn,@QueryParam("userrate")Integer useRate,@QueryParam("saleuid") Integer saleUid,@QueryParam("wantuid")Integer wantUid,@QueryParam("saleprice")Float salePrice,@QueryParam("needprice")Float needPrice,@QueryParam("saleensure")Integer saleEnsure,@QueryParam("wantensure")Integer wantEnsure,@QueryParam("salego")Integer saleGo,@QueryParam("wantgo")Integer wantGo,@QueryParam("statues")Integer satues){
    OderInfo oderInfo =new  OderInfo();
    BookOrder bookOrder=new BookOrder();
    BookBook bookBook=bookDA.findBookByID(isbn);
        if (bookBook==null) {
        isbn=bookDA.createBook(isbn,0,0,0,0);
        Integer bookid=bookDetailDA.createBookDetail(useRate, asString, 0, isbn);
        Date sDate=new Date();
        Integer orderInteger=orderDA.createOrder(salePrice, needPrice, saleEnsure, saleGo, wantGo, sDate, null, null, satues, wantUid, saleUid, bookid, wantEnsure);
        bookOrder=orderDA.findOrderByID(orderInteger);
        }
        else{
        List<BookBookdetail> bookBookdetails=bookBook.getBookBookdetailList();
            if (bookBookdetails==null) {
                Integer bookid=bookDetailDA.createBookDetail(useRate, asString,0, isbn);
                Date sDate =new Date();
                Integer orderInteger=orderDA.createOrder(salePrice, needPrice, saleEnsure, saleGo, wantGo, sDate, null, null, satues, wantUid, saleUid, bookid, wantEnsure);
                bookOrder=orderDA.findOrderByID(orderInteger);
            } else {
//                BookBookdetail bookBookdetail;                
                for (Iterator<BookBookdetail> it = bookBookdetails.iterator(); it.hasNext();) {
                    BookBookdetail bookBookdetail11 = it.next();
                    if(bookBookdetail11.getUseRate()==0)
                    {
                     Integer bookid1=bookBookdetail11.getId();
                     Date date=new Date();
                     Integer orInteger=orderDA.createOrder(salePrice, needPrice, saleEnsure, saleGo, wantGo, date, null, null, satues, wantUid, saleUid, bookid1, wantEnsure);
                     bookOrder=orderDA.findOrderByID(orInteger);
                    }
                    
                }
                
            }
        
        
        
        
        
        }
     if (bookOrder.getBookId()!=null) {
            oderInfo.setAbstract1(bookOrder.getBookId().getAbstract1());
            oderInfo.setAmount(bookOrder.getBookId().getAmount());
            oderInfo.setIsbn(bookOrder.getBookId().getIsbn().getIsbn());
            oderInfo.setUseRate(bookOrder.getBookId().getUseRate());
            }
            if (bookOrder.getSaleUid()!=null) {
            oderInfo.setSaleName(bookOrder.getSaleUid().getUsername());                
            }
            oderInfo.setNeedPrice(bookOrder.getNeedPrice());
            oderInfo.setSaleEnsure(bookOrder.getSaleEnsure());
            oderInfo.setSaleGo(bookOrder.getSaleGo());
            oderInfo.setSalePrice(bookOrder.getSalePrice());

            oderInfo.setSatues(bookOrder.getStaues());

            oderInfo.setWantEnsure(bookOrder.getWantEnsure());
            oderInfo.setWantGo(bookOrder.getWantGo());
            oderInfo.setWantName(bookOrder.getWantUid().getUsername());
            oderInfo.setfDate(bookOrder.getFDate());
            oderInfo.setmDate(bookOrder.getMDate());
            oderInfo.setsDate(bookOrder.getSDate());
            
           
    
            
    
    return  oderInfo;
    }
    
}
