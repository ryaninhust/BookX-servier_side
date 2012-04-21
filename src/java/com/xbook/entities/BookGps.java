/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "book_gps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookGps.findAll", query = "SELECT b FROM BookGps b"),
    @NamedQuery(name = "BookGps.findById", query = "SELECT b FROM BookGps b WHERE b.id = :id"),
    @NamedQuery(name = "BookGps.findByGpsX", query = "SELECT b FROM BookGps b WHERE b.gpsX = :gpsX"),
    @NamedQuery(name = "BookGps.findByGpsY", query = "SELECT b FROM BookGps b WHERE b.gpsY = :gpsY"),
    @NamedQuery(name = "BookGps.findByGpsName", query = "SELECT b FROM BookGps b WHERE b.gpsName = :gpsName")})
public class BookGps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gps_x")
    private float gpsX;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gps_y")
    private Float gpsY;
    @Size(max = 50)
    @Column(name = "gps_name")
    private String gpsName;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BookUsers userId;

    public BookGps() {
    }

    public BookGps(Integer id) {
        this.id = id;
    }

    public BookGps(Integer id, float gpsX) {
        this.id = id;
        this.gpsX = gpsX;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getGpsX() {
        return gpsX;
    }

    public void setGpsX(float gpsX) {
        this.gpsX = gpsX;
    }

    public Float getGpsY() {
        return gpsY;
    }

    public void setGpsY(Float gpsY) {
        this.gpsY = gpsY;
    }

    public String getGpsName() {
        return gpsName;
    }

    public void setGpsName(String gpsName) {
        this.gpsName = gpsName;
    }

    public BookUsers getUserId() {
        return userId;
    }

    public void setUserId(BookUsers userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookGps)) {
            return false;
        }
        BookGps other = (BookGps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xbook.entities.BookGps[ id=" + id + " ]";
    }
    
}
