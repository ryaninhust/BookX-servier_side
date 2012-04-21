/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbook.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "book_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookUsers.findAll", query = "SELECT b FROM BookUsers b"),
    @NamedQuery(name = "BookUsers.findById", query = "SELECT b FROM BookUsers b WHERE b.id = :id"),
    @NamedQuery(name = "BookUsers.findByPassword", query = "SELECT b FROM BookUsers b WHERE b.password = :password"),
    @NamedQuery(name = "BookUsers.findByUsername", query = "SELECT b FROM BookUsers b WHERE b.username = :username"),
    @NamedQuery(name = "BookUsers.findByFirstLogin", query = "SELECT b FROM BookUsers b WHERE b.firstLogin = :firstLogin"),
    @NamedQuery(name = "BookUsers.findByEmail", query = "SELECT b FROM BookUsers b WHERE b.email = :email"),
    @NamedQuery(name = "BookUsers.findByQq", query = "SELECT b FROM BookUsers b WHERE b.qq = :qq"),
    @NamedQuery(name = "BookUsers.findByAccount", query = "SELECT b FROM BookUsers b WHERE b.account = :account"),
    @NamedQuery(name = "BookUsers.findByFaith", query = "SELECT b FROM BookUsers b WHERE b.faith = :faith")})
public class BookUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
 
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    @Column(name = "first_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstLogin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "qq")
    private BigInteger qq;
    @Column(name = "account")
    private Integer account;
    @Column(name = "faith")
    private Integer faith;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BookGps> bookGpsList;
    @OneToMany(mappedBy = "wantUid")
    private List<BookOrder> bookOrderList;
    @OneToMany(mappedBy = "saleUid")
    private List<BookOrder> bookOrderList1;

    public BookUsers() {
    }

    public BookUsers(Integer id) {
        this.id = id;
    }

    public BookUsers(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getQq() {
        return qq;
    }

    public void setQq(BigInteger qq) {
        this.qq = qq;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getFaith() {
        return faith;
    }

    public void setFaith(Integer faith) {
        this.faith = faith;
    }

    @XmlTransient
    public List<BookGps> getBookGpsList() {
        return bookGpsList;
    }

    public void setBookGpsList(List<BookGps> bookGpsList) {
        this.bookGpsList = bookGpsList;
    }

    @XmlTransient
    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    @XmlTransient
    public List<BookOrder> getBookOrderList1() {
        return bookOrderList1;
    }

    public void setBookOrderList1(List<BookOrder> bookOrderList1) {
        this.bookOrderList1 = bookOrderList1;
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
        if (!(object instanceof BookUsers)) {
            return false;
        }
        BookUsers other = (BookUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xbook.entities.BookUsers[ id=" + id + " ]";
    }
    
}
