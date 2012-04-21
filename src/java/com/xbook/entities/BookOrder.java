/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "book_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b"),
    @NamedQuery(name = "BookOrder.findById", query = "SELECT b FROM BookOrder b WHERE b.id = :id"),
    @NamedQuery(name = "BookOrder.findBySalePrice", query = "SELECT b FROM BookOrder b WHERE b.salePrice = :salePrice"),
    @NamedQuery(name = "BookOrder.findByNeedPrice", query = "SELECT b FROM BookOrder b WHERE b.needPrice = :needPrice"),
    @NamedQuery(name = "BookOrder.findBySaleEnsure", query = "SELECT b FROM BookOrder b WHERE b.saleEnsure = :saleEnsure"),
    @NamedQuery(name = "BookOrder.findBySaleGo", query = "SELECT b FROM BookOrder b WHERE b.saleGo = :saleGo"),
    @NamedQuery(name = "BookOrder.findByWantGo", query = "SELECT b FROM BookOrder b WHERE b.wantGo = :wantGo"),
    @NamedQuery(name = "BookOrder.findBySDate", query = "SELECT b FROM BookOrder b WHERE b.sDate = :sDate"),
    @NamedQuery(name = "BookOrder.findByMDate", query = "SELECT b FROM BookOrder b WHERE b.mDate = :mDate"),
    @NamedQuery(name = "BookOrder.findByFDate", query = "SELECT b FROM BookOrder b WHERE b.fDate = :fDate"),
    @NamedQuery(name = "BookOrder.findByStaues", query = "SELECT b FROM BookOrder b WHERE b.staues = :staues"),
    @NamedQuery(name = "BookOrder.findByWantEnsure", query = "SELECT b FROM BookOrder b WHERE b.wantEnsure = :wantEnsure")})
public class BookOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sale_price")
    private Float salePrice;
    @Column(name = "need_price")
    private Float needPrice;
    @Column(name = "sale_ensure")
    private Integer saleEnsure;
    @Column(name = "sale_go")
    private Integer saleGo;
    @Column(name = "want_go")
    private Integer wantGo;
    @Column(name = "s_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sDate;
    @Column(name = "m_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mDate;
    @Column(name = "f_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Column(name = "staues")
    private Integer staues;
    @Column(name = "want_ensure")
    private Integer wantEnsure;
    @JoinColumn(name = "want_uid", referencedColumnName = "id")
    @ManyToOne
    private BookUsers wantUid;
    @JoinColumn(name = "sale_uid", referencedColumnName = "id")
    @ManyToOne
    private BookUsers saleUid;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne
    private BookBookdetail bookId;

    public BookOrder() {
    }

    public BookOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Float getNeedPrice() {
        return needPrice;
    }

    public void setNeedPrice(Float needPrice) {
        this.needPrice = needPrice;
    }

    public Integer getSaleEnsure() {
        return saleEnsure;
    }

    public void setSaleEnsure(Integer saleEnsure) {
        this.saleEnsure = saleEnsure;
    }

    public Integer getSaleGo() {
        return saleGo;
    }

    public void setSaleGo(Integer saleGo) {
        this.saleGo = saleGo;
    }

    public Integer getWantGo() {
        return wantGo;
    }

    public void setWantGo(Integer wantGo) {
        this.wantGo = wantGo;
    }

    public Date getSDate() {
        return sDate;
    }

    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date getMDate() {
        return mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    public Integer getStaues() {
        return staues;
    }

    public void setStaues(Integer staues) {
        this.staues = staues;
    }

    public Integer getWantEnsure() {
        return wantEnsure;
    }

    public void setWantEnsure(Integer wantEnsure) {
        this.wantEnsure = wantEnsure;
    }

    public BookUsers getWantUid() {
        return wantUid;
    }

    public void setWantUid(BookUsers wantUid) {
        this.wantUid = wantUid;
    }

    public BookUsers getSaleUid() {
        return saleUid;
    }

    public void setSaleUid(BookUsers saleUid) {
        this.saleUid = saleUid;
    }

    public BookBookdetail getBookId() {
        return bookId;
    }

    public void setBookId(BookBookdetail bookId) {
        this.bookId = bookId;
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
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xbook.entities.BookOrder[ id=" + id + " ]";
    }
    
}
