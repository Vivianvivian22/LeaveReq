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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kresna92
 */
@Entity
@Table(name = "PARAMETER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p")
    , @NamedQuery(name = "Parameter.findById", query = "SELECT p FROM Parameter p WHERE p.id = :id")
    , @NamedQuery(name = "Parameter.findByName", query = "SELECT p FROM Parameter p WHERE p.name = :name")
    , @NamedQuery(name = "Parameter.findByLimit", query = "SELECT p FROM Parameter p WHERE p.limit = :limit")})

/**
 * class Parameter extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "LIMIT")
    private int limit;

    /**
     * Parameter method is a constructor method of Parameter class
     * Method that was first executed when the class was executed
     */
    public Parameter() {
    }

    public Parameter(String id) {
        this.id = id;
    }

    /**
     * Parameter method which functions to assign values to global variables from Parameter class
     */
    public Parameter(String id, String name, int limit) {
        this.id = id;
        this.name = name;
        this.limit = limit;
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
     * getLimit method is used to retrieve values from limit
     * getLimit method has a public access modifier
     */
    public int getLimit() {
        return limit;
    }

    /**
     * setLimit method is used to assign values to the global variable limit based on the limit variable in the setLimit method parameter
     * setLimit method has a public access modifier
     */
    public void setLimit(int limit) {
        this.limit = limit;
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
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
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
        return "models.Parameter[ id=" + id + " ]";
    }
    
}
