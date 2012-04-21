package com.xbook.entities;

import com.xbook.entities.BookUsers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-03T01:43:43")
@StaticMetamodel(BookGps.class)
public class BookGps_ { 

    public static volatile SingularAttribute<BookGps, Integer> id;
    public static volatile SingularAttribute<BookGps, Float> gpsX;
    public static volatile SingularAttribute<BookGps, String> gpsName;
    public static volatile SingularAttribute<BookGps, Float> gpsY;
    public static volatile SingularAttribute<BookGps, BookUsers> userId;

}