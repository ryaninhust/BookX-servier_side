package com.xbook.entities;

import com.xbook.entities.BookBookdetail;
import com.xbook.entities.BookUsers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-03T01:43:43")
@StaticMetamodel(BookOrder.class)
public class BookOrder_ { 

    public static volatile SingularAttribute<BookOrder, Integer> wantEnsure;
    public static volatile SingularAttribute<BookOrder, BookBookdetail> bookId;
    public static volatile SingularAttribute<BookOrder, Integer> staues;
    public static volatile SingularAttribute<BookOrder, Date> mDate;
    public static volatile SingularAttribute<BookOrder, Date> fDate;
    public static volatile SingularAttribute<BookOrder, BookUsers> wantUid;
    public static volatile SingularAttribute<BookOrder, Integer> saleGo;
    public static volatile SingularAttribute<BookOrder, Integer> id;
    public static volatile SingularAttribute<BookOrder, Integer> wantGo;
    public static volatile SingularAttribute<BookOrder, Float> salePrice;
    public static volatile SingularAttribute<BookOrder, Float> needPrice;
    public static volatile SingularAttribute<BookOrder, BookUsers> saleUid;
    public static volatile SingularAttribute<BookOrder, Integer> saleEnsure;
    public static volatile SingularAttribute<BookOrder, Date> sDate;

}