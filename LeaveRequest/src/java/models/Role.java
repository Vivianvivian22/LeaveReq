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
@Table(name = "ROLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id")
    , @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")})

/**
 * class Role extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    /**
     * Role method is a constructor method of Role class
     * Method that was first executed when the class was executed
     */
    public Role() {
    }

    public Role(String id) {
        this.id = id;
    }

    /**
     * Role method which functions to assign values to global variables from Role class
     */
    public Role(String id, String name) {
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
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
        return "models.Role[ id=" + id + " ]";
    }
    
}
