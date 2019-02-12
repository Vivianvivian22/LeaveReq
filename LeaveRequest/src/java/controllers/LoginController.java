/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAO;
import daos.DAOInterface;
import models.Employee;
import org.hibernate.SessionFactory;


/**
 *
 * @author FATH
 */
public class LoginController {
    
     private DAOInterface<Employee> edao;
     Employee emp = new Employee();
     
    /**
     * Declaring constructor of class controller
     * @param sessionFactory 
     */
    public LoginController(SessionFactory sessionFactory) {
        this.edao = new DAO(sessionFactory);
    }
    
    public Employee findById(Employee e, String id) {
        return (Employee) edao.function(e, 4,"", id,0).get(0);
    }
    public Employee findByActive(Employee e, String id) {
        return (Employee) edao.function(e, 4,"", id,0).get(0);
    }
    
    public boolean save(String id, String password) {
        emp =  findById(emp, id);
        boolean result = false;
        emp.setId(id);
        emp.setPassword(encrypt(password));
        try {
            edao.function(emp, 1,"", "",0);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public boolean check(String id, String password) {
        emp =  findById(emp, id);
        if (emp != null) {
            if (BCrypt.checkpw(password, emp.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
}
