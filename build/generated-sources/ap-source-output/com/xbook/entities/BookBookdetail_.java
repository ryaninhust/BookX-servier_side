package com.xbook.entities;

import com.xbook.entities.BookBook;
import com.xbook.entities.BookOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-03T01:43:43")
@StaticMetamodel(BookBookdetail.class)
public class BookBookdetail_ { 

    public static volatile SingularAttribute<BookBookdetail, Integer> id;
    public static volatile SingularAttribute<BookBookdetail, Integer> amount;
    public static volatile SingularAttribute<BookBookdetail, Integer> useRate;
    public static volatile SingularAttribute<BookBookdetail, String> abstract1;
    public static volatile SingularAttribute<BookBookdetail, BookBook> isbn;
    public static volatile ListAttribute<BookBookdetail, BookOrder> bookOrderList;

}