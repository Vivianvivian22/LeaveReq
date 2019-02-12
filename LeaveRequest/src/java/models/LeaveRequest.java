/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kresna92
 */
@Entity
@Table(name = "LEAVE_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequest.findAll", query = "SELECT l FROM LeaveRequest l")
    , @NamedQuery(name = "LeaveRequest.findById", query = "SELECT l FROM LeaveRequest l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequest.findByStartDate", query = "SELECT l FROM LeaveRequest l WHERE l.startDate = :startDate")
    , @NamedQuery(name = "LeaveRequest.findByEndDate", query = "SELECT l FROM LeaveRequest l WHERE l.endDate = :endDate")
    , @NamedQuery(name = "LeaveRequest.findByDuration", query = "SELECT l FROM LeaveRequest l WHERE l.duration = :duration")})

/**
 * class LeaveRequest extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class LeaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "DURATION")
    private long duration;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "LEAVE_TYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveType leaveType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequest", fetch = FetchType.LAZY)
    private List<RequestStatus> requestStatusList;

    /**
     * LeaveRequest method is a constructor method of LeaveRequest class
     * Method that was first executed when the class was executed
     */
    public LeaveRequest() {
    }

    public LeaveRequest(String id) {
        this.id = id;
    }

    /**
     * LeaveRequest method which functions to assign values to global variables from LeaveRequest class
     */
    public LeaveRequest(String id, Date startDate, Date endDate, long duration, Employee employee, LeaveType leaveType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.employee = employee;
        this.leaveType = leaveType;
    }

    public LeaveRequest(String id, Date startDate, Date endDate, long duration) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
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
     * getStartDate method is used to retrieve values from startDate
     * getStartDate method has a public access modifier
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * setStartDate method is used to assign values to the global variable startDate based on the startDate variable in the setStartDate method parameter
     * setStartDate method has a public access modifier
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * getEndDate method is used to retrieve values from endDate
     * getEndDate method has a public access modifier
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * setEndDate method is used to assign values to the global variable endDate based on the endDate variable in the setEndDate method parameter
     * setEndDate method has a public access modifier
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * getDuration method is used to retrieve values from duration
     * getDuration method has a public access modifier
     */
    public long getDuration() {
        return duration;
    }

    /**
     * setDuration method is used to assign values to the global variable duration based on the duration variable in the setDuration method parameter
     * setDuration method has a public access modifier
     */
    public void setDuration(long duration) {
        this.duration = duration;
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
     * getLeaveType method is used to retrieve values from leaveType
     * getLeaveType method has a public access modifier
     */
    public LeaveType getLeaveType() {
        return leaveType;
    }

    /**
     * setLeaveType method is used to assign values to the global variable leaveType based on the leaveType variable in the setLeaveType method parameter
     * setLeaveType method has a public access modifier
     */
    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * getRequestStatusList method is used to retrieve values from requestStatusList
     * getRequestStatusList method has a public access modifier
     * @XmlTransient annotation is useful for resolving name collisions between a JavaBean property name
     * and a field name or preventing the mapping of a field/property
     */
    @XmlTransient
    public List<RequestStatus> getRequestStatusList() {
        return requestStatusList;
    }

    /**
     * setRequestStatusList method is used to assign values to the global variable requestStatusList based on the requestStatusList variable in the setRequestStatusList method parameter
     * setRequestStatusList method has a public access modifier
     */
    public void setRequestStatusList(List<RequestStatus> requestStatusList) {
        this.requestStatusList = requestStatusList;
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
        if (!(object instanceof LeaveRequest)) {
            return false;
        }
        LeaveRequest other = (LeaveRequest) object;
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
        return "models.LeaveRequest[ id=" + id + " ]";
    }
    
}
