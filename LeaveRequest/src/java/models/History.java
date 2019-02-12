/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kresna92
 */
@Entity
@Table(name = "HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findById", query = "SELECT h FROM History h WHERE h.id = :id")
    , @NamedQuery(name = "History.findByExpiredQuota", query = "SELECT h FROM History h WHERE h.expiredQuota = :expiredQuota")})

/**
 * class History extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "EXPIRED_QUOTA")
    private int expiredQuota;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employee;

    /**
     * History method is a constructor method of History class
     * Method that was first executed when the class was executed
     */
    public History() {
    }

    public History(String id) {
        this.id = id;
    }

    /**
     * History method which functions to assign values to global variables from History class
     */
    public History(String id, int expiredQuota, Employee employee) {
        this.id = id;
        this.expiredQuota = expiredQuota;
        this.employee = employee;
    }

    public History(String id, int expiredQuota) {
        this.id = id;
        this.expiredQuota = expiredQuota;
    }

    /**
     * getId method is used to retrieve values from id
     * getId method has a public access modifier
     */
    public String getId() {
        return id;
    }

    /**
     * setId method is used to assign values to the global variable id based on the id variable in the setId method parameter
     * setId method has a public access modifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getExpiredQuota method is used to retrieve values from expiredQuota
     * getExpiredQuota method has a public access modifier
     */
    public int getExpiredQuota() {
        return expiredQuota;
    }

    /**
     * setExpiredQuota method is used to assign values to the global variable expiredQuota based on the expiredQuota variable in the setExpiredQuota method parameter
     * setExpiredQuota method has a public access modifier
     */
    public void setExpiredQuota(int expiredQuota) {
        this.expiredQuota = expiredQuota;
    }

    /**
     * getEmployee method is used to retrieve values from employee
     * getEmployee method has a public access modifier
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * setEmployee method is used to assign values to the global variable employee based on the employee variable in the setEmployee method parameter
     * setEmployee method has a public access modifier
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @Override indicated that a method declaration is intended to override a method declaration in a supertype
     * returns a hash code value for the object
     * this method is supported for the benefit of hash tables such as those provided by HashMap
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * @Override indicated that a method declaration is intended to override a method declaration in a supertype
     * equals method implements an equivalence relation on non null object references
     * @param object class objects is the root of the class hierarchy. every class has object as a superclass
     * 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * @Override indicated that a method declaration is intended to override a method declaration in a supertype
     * toString method returns a string representation of the object
     */
    @Override
    public String toString() {
        return "models.History[ id=" + id + " ]";
    }

}
