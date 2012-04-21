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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "book_bookdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookBookdetail.findAll", query = "SELECT b FROM BookBookdetail b"),
    @NamedQuery(name = "BookBookdetail.findById", query = "SELECT b FROM BookBookdetail b WHERE b.id = :id"),
    @NamedQuery(name = "BookBookdetail.findByUseRate", query = "SELECT b FROM BookBookdetail b WHERE b.useRate = :useRate"),
    @NamedQuery(name = "BookBookdetail.findByAbstract1", query = "SELECT b FROM BookBookdetail b WHERE b.abstract1 = :abstract1"),
    @NamedQuery(name = "BookBookdetail.findByAmount", query = "SELECT b FROM BookBookdetail b WHERE b.amount = :amount")})
public class BookBookdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "use_rate")
    private Integer useRate;
    @Size(max = 50)
    @Column(name = "abstract")
    private String abstract1;
    @Column(name = "amount")
    private Integer amount;
    @OneToMany(mappedBy = "bookId")
    private List<BookOrder> bookOrderList;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne
    private BookBook isbn;

    public BookBookdetail() {
    }

    public BookBookdetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUseRate() {
        return useRate;
    }

    public void setUseRate(Integer useRate) {
        this.useRate = useRate;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @XmlTransient
    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    public BookBook getIsbn() {
        return isbn;
    }

    public void setIsbn(BookBook isbn) {
        this.isbn = isbn;
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
        if (!(object instanceof BookBookdetail)) {
            return false;
        }
        BookBookdetail other = (BookBookdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xbook.entities.BookBookdetail[ id=" + id + " ]";
    }
    
}
