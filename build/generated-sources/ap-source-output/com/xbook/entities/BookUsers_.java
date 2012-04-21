package com.xbook.entities;

import com.xbook.entities.BookGps;
import com.xbook.entities.BookOrder;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-03T01:43:43")
@StaticMetamodel(BookUsers.class)
public class BookUsers_ { 

    public static volatile SingularAttribute<BookUsers, Integer> id;
    public static volatile ListAttribute<BookUsers, BookOrder> bookOrderList1;
    public static volatile SingularAttribute<BookUsers, String> username;
    public static volatile SingularAttribute<BookUsers, String> email;
    public static volatile SingularAttribute<BookUsers, Integer> faith;
    public static volatile SingularAttribute<BookUsers, Date> firstLogin;
    public static volatile SingularAttribute<BookUsers, Integer> account;
    public static volatile ListAttribute<BookUsers, BookOrder> bookOrderList;
    public static volatile SingularAttribute<BookUsers, String> password;
    public static volatile SingularAttribute<BookUsers, BigInteger> qq;
    public static volatile ListAttribute<BookUsers, BookGps> bookGpsList;

}