/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kresna92
 */
@Entity
@Table(name = "SITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findById", query = "SELECT s FROM Site s WHERE s.id = :id")
    , @NamedQuery(name = "Site.findByName", query = "SELECT s FROM Site s WHERE s.name = :name")
    , @NamedQuery(name = "Site.findByAddress", query = "SELECT s FROM Site s WHERE s.address = :address")})

/**
 * class Site extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    /**
     * Site method is a constructor method of Site class
     * Method that was first executed when the class was executed
     */
    public Site() {
    }

    public Site(String id) {
        this.id = id;
    }

    /**
     * Site method which functions to assign values to global variables from Site class
     */
    public Site(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Site(String id, String name) {
        this.id = id;
        this.name = name;
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
     * getName method is used to retrieve values from name
     * getName method has a public access modifier
     */
    public String getName() {
        return name;
    }

    /**
     * setName method is used to assign values to the global variable name based on the name variable in the setName method parameter
     * setName method has a public access modifier
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getAddress method is used to retrieve values from address
     * getAddress method has a public access modifier
     */
    public String getAddress() {
        return address;
    }

    /**
     * setAddress method is used to assign values to the global variable address based on the address variable in the setAddress method parameter
     * setAddress method has a public access modifier
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * getEmployeeList method is used to retrieve values from employeeList
     * getEmployeeList method has a public access modifier
     * @XmlTransient annotation is useful for resolving name collisions between a JavaBean property name
     * and a field name or preventing the mapping of a field/property
     */
    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * setEmployeeList method is used to assign values to the global variable employeeList based on the employeeList variable in the setEmployeeList method parameter
     * setEmployeeList method has a public access modifier
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
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
        return "models.Site[ id=" + id + " ]";
    }

}
