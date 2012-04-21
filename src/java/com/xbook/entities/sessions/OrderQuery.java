    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities.sessions;

import com.xbook.entities.BookOrder;
import com.xbook.entities.access.BookDetailDA;
import com.xbook.entities.access.OrderDA;
import com.xbook.returnutil.OderInfo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.GET;
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
@LocalBean
@Path("order")
public class OrderQuery {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")\
    public OrderDA orderDA;
//    public BookDetailDA bookDetailDA;
    @PostConstruct
    public void  init(){
    orderDA=new OrderDA();
    
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OderInfo> queryUsersOrder(@PathParam("id")Integer wantID,@QueryParam("statues") Integer statues ){
        
        
    List<OderInfo> oderInfos=new ArrayList<OderInfo>();
    List<BookOrder> bookOrders;
    if (statues==null) {
            bookOrders= orderDA.findOrdersByUserID(wantID);
        } else {
        bookOrders=orderDA.findUserOrderByStatues(wantID, statues);
        }
        for (Iterator<BookOrder> it = bookOrders.iterator(); it.hasNext();) {
            BookOrder bookOrder = it.next();
            OderInfo oderInfo=new OderInfo();
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
            
            oderInfos.add(oderInfo);
            
        }
    
    
    return  oderInfos;
    }
    

}
