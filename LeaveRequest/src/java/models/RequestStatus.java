/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kresna92
 */
@Entity
@Table(name = "REQUEST_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestStatus.findAll", query = "SELECT r FROM RequestStatus r")
    , @NamedQuery(name = "RequestStatus.findById", query = "SELECT r FROM RequestStatus r WHERE r.id = :id")
    , @NamedQuery(name = "RequestStatus.findByRemark", query = "SELECT r FROM RequestStatus r WHERE r.remark = :remark")
    , @NamedQuery(name = "RequestStatus.findByStatusDate", query = "SELECT r FROM RequestStatus r WHERE r.statusDate = :statusDate")})

/**
 * class RequestStatus extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class RequestStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "REMARK")
    private String remark;
    @Basic(optional = false)
    @Column(name = "STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @JoinColumn(name = "LEAVE_REQUEST", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveRequest leaveRequest;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    /**
     * RequestStatus method is a constructor method of RequestStatus class
     * Method that was first executed when the class was executed
     */
    public RequestStatus() {
    }

    public RequestStatus(String id) {
        this.id = id;
    }

    /**
     * RequestStatus method which functions to assign values to global variables from RequestStatus class
     */
    public RequestStatus(String id, String remark, Date statusDate, LeaveRequest leaveRequest, Status status) {
        this.id = id;
        this.remark = remark;
        this.statusDate = statusDate;
        this.leaveRequest = leaveRequest;
        this.status = status;
    }

    public RequestStatus(String id, Date statusDate) {
        this.id = id;
        this.statusDate = statusDate;
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
     * getRemark method is used to retrieve values from remark
     * getRemark method has a public access modifier
     */
    public String getRemark() {
        return remark;
    }

    /**
     * setRemark method is used to assign values to the global variable remark based on the remark variable in the setRemark method parameter
     * setRemark method has a public access modifier
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * getStatusDate method is used to retrieve values from statusDate
     * getStatusDate method has a public access modifier
     */
    public Date getStatusDate() {
        return statusDate;
    }

    /**
     * setStatusDate method is used to assign values to the global variable statusDate based on the statusDate variable in the setStatusDate method parameter
     * setStatusDate method has a public access modifier
     */
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    /**
     * getLeaveRequest method is used to retrieve values from leaveRequest
     * getLeaveRequest method has a public access modifier
     */
    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    /**
     * setLeaveRequest method is used to assign values to the global variable leaveRequest based on the leaveRequest variable in the setLeaveRequest method parameter
     * setLeaveRequest method has a public access modifier
     */
    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }

    /**
     * getStatus method is used to retrieve values from status
     * getStatus method has a public access modifier
     */
    public Status getStatus() {
        return status;
    }

    /**
     * setStatus method is used to assign values to the global variable status based on the status variable in the setStatus method parameter
     * setStatus method has a public access modifier
     */
    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof RequestStatus)) {
            return false;
        }
        RequestStatus other = (RequestStatus) object;
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
        return "models.RequestStatus[ id=" + id + " ]";
    }

}
