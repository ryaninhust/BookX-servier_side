/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "book_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookBook.findAll", query = "SELECT b FROM BookBook b"),
    @NamedQuery(name = "BookBook.findByIsbn", query = "SELECT b FROM BookBook b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "BookBook.findByDealTotal", query = "SELECT b FROM BookBook b WHERE b.dealTotal = :dealTotal"),
    @NamedQuery(name = "BookBook.findBySaleTotal", query = "SELECT b FROM BookBook b WHERE b.saleTotal = :saleTotal"),
    @NamedQuery(name = "BookBook.findBySalePrice", query = "SELECT b FROM BookBook b WHERE b.salePrice = :salePrice"),
    @NamedQuery(name = "BookBook.findByDealPrice", query = "SELECT b FROM BookBook b WHERE b.dealPrice = :dealPrice")})
public class BookBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbn")
    private Long isbn;
    @Column(name = "deal_total")
    private Integer dealTotal;
    @Column(name = "sale_total")
    private Integer saleTotal;
    @Column(name = "sale_price")
    private Integer salePrice;
    @Column(name = "deal_price")
    private Integer dealPrice;
    @OneToMany(mappedBy = "isbn")
    private List<BookBookdetail> bookBookdetailList;

    public BookBook() {
    }

    public BookBook(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getDealTotal() {
        return dealTotal;
    }

    public void setDealTotal(Integer dealTotal) {
        this.dealTotal = dealTotal;
    }

    public Integer getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Integer saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Integer dealPrice) {
        this.dealPrice = dealPrice;
    }

    @XmlTransient
    public List<BookBookdetail> getBookBookdetailList() {
        return bookBookdetailList;
    }

    public void setBookBookdetailList(List<BookBookdetail> bookBookdetailList) {
        this.bookBookdetailList = bookBookdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookBook)) {
            return false;
        }
        BookBook other = (BookBook) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xbook.entities.BookBook[ isbn=" + isbn + " ]";
    }
    
}
