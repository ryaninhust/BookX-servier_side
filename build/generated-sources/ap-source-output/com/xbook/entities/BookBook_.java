package com.xbook.entities;

import com.xbook.entities.BookBookdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-03T01:43:43")
@StaticMetamodel(BookBook.class)
public class BookBook_ { 

    public static volatile ListAttribute<BookBook, BookBookdetail> bookBookdetailList;
    public static volatile SingularAttribute<BookBook, Integer> dealPrice;
    public static volatile SingularAttribute<BookBook, Integer> saleTotal;
    public static volatile SingularAttribute<BookBook, Long> isbn;
    public static volatile SingularAttribute<BookBook, Integer> dealTotal;
    public static volatile SingularAttribute<BookBook, Integer> salePrice;

}