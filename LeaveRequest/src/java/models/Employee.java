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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByJoinDate", query = "SELECT e FROM Employee e WHERE e.joinDate = :joinDate")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByLeaveQuota", query = "SELECT e FROM Employee e WHERE e.leaveQuota = :leaveQuota")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByIsActive", query = "SELECT e FROM Employee e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")})

/**
 * class Employee extends Object implements Serializable
 * Serializable of a class is enabled by the class implementing the java.io.Serializable interface
 */
public class Employee implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "JOIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "LEAVE_QUOTA")
    private int leaveQuota;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "IS_ACTIVE")
    private int isActive;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Employee> employeeList;
    @JoinColumn(name = "MANAGER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee manager;
    @JoinColumn(name = "ROLES", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role roles;
    @JoinColumn(name = "SITE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Site site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<History> historyList;

    /**
     * Employee method is a constructor method of Employee class
     * Method that was first executed when the class was executed
     */
    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String id) {
        this.id = id;
    }

    /**
     * Employee method which functions to assign values to global variables from Employee class
     */
    public Employee(String id, String name, String address, Date joinDate, String email, int leaveQuota, String password, int isActive, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.joinDate = joinDate;
        this.email = email;
        this.leaveQuota = leaveQuota;
        this.password = password;
        this.isActive = isActive;
        this.phone = phone;
    }

    public Employee(String id, String name, String address, Date joinDate, String email, int leaveQuota, String password, int isActive, String phone, Employee manager, Role roles, Site site) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.joinDate = joinDate;
        this.email = email;
        this.leaveQuota = leaveQuota;
        this.password = password;
        this.isActive = isActive;
        this.phone = phone;
        this.manager = manager;
        this.roles = roles;
        this.site = site;
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
     * getJoinDate method is used to retrieve values from joinDate
     * getJoinDate method has a public access modifier
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * setJoinDate method is used to assign values to the global variable joinDate based on the joinDate variable in the setJoinDate method parameter
     * setJoinDate method has a public access modifier
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * getEmail method is used to retrieve values from email
     * getEmail method has a public access modifier
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail method is used to assign values to the global variable email based on the email variable in the setEmail method parameter
     * setEmail method has a public access modifier
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getLeaveQuota method is used to retrieve values from leaveQuota
     * getLeaveQuota method has a public access modifier
     */
    public int getLeaveQuota() {
        return leaveQuota;
    }

    /**
     * setLeaveQuota method is used to assign values to the global variable leaveQuota based on the leaveQuota variable in the setLeaveQuota method parameter
     * setLeaveQuota method has a public access modifier
     */
    public void setLeaveQuota(int leaveQuota) {
        this.leaveQuota = leaveQuota;
    }

    /**
     * getPassword method is used to retrieve values from password
     * getPassword method has a public access modifier
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword method is used to assign values to the global variable password based on the password variable in the setPassword method parameter
     * setPassword method has a public access modifier
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getIsActive method is used to retrieve values from isActive
     * getIsActive method has a public access modifier
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * setIsActive method is used to assign values to the global variable isActive based on the isActive variable in the setIsActive method parameter
     * setIsActive method has a public access modifier
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * getPhone method is used to retrieve values from phone
     * getPhone method has a public access modifier
     */
    public String getPhone() {
        return phone;
    }

    /**
     * setPhone method is used to assign values to the global variable phone based on the phone variable in the setPhone method parameter
     * setPhone method has a public access modifier
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * getManager method is used to retrieve values from manager
     * getManager method has a public access modifier
     */
    public Employee getManager() {
        return manager;
    }

    /**
     * setManager method is used to assign values to the global variable manager based on the manager variable in the setManager method parameter
     * setManager method has a public access modifier
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * getRoles method is used to retrieve values from roles
     * getRoles method has a public access modifier
     */
    public Role getRoles() {
        return roles;
    }

    /**
     * setRoles method is used to assign values to the global variable roles based on the roles variable in the setRoles method parameter
     * setRoles method has a public access modifier
     */
    public void setRoles(Role roles) {
        this.roles = roles;
    }

    /**
     * getSite method is used to retrieve values from site
     * getSite method has a public access modifier
     */
    public Site getSite() {
        return site;
    }

    /**
     * setSite method is used to assign values to the global variable site based on the site variable in the setSite method parameter
     * setSite method has a public access modifier
     */
    public void setSite(Site site) {
        this.site = site;
    }

    /**
     * getLeaveRequestList method is used to retrieve values from leaveRequestList
     * getLeaveRequestList method has a public access modifier
     * @XmlTransient annotation is useful for resolving name collisions between a JavaBean property name
     * and a field name or preventing the mapping of a field/property
     */
    @XmlTransient
    public List<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    /**
     * setLeaveRequestList method is used to assign values to the global variable leaveRequestList based on the leaveRequestList variable in the setLeaveRequestList method parameter
     * setLeaveRequestList method has a public access modifier
     */
    public void setLeaveRequestList(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    /**
     * getHistoryList method is used to retrieve values from historyList
     * getHistoryList method has a public access modifier
     */
    @XmlTransient
    public List<History> getHistoryList() {
        return historyList;
    }

    /**
     * setHistoryList method is used to assign values to the global variable historyList based on the historyList variable in the setHistoryList method parameter
     * setHistoryList method has a public access modifier
     */
    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
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
        return "models.Employee[ id=" + id + " ]";
    }

}
