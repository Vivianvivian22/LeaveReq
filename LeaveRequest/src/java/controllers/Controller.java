/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAO;
import daos.DAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * Declaring class controller with generic class that implements controller interface
 * @author kresna92
 */
public class Controller<E> implements ControllerInterface<E> {

    private DAOInterface<E> dao;
    /**
     * Declaring constructor of class controller
     * @param sessionFactory 
     */
    public Controller(SessionFactory sessionFactory) {
        this.dao = new DAO(sessionFactory);
    }
    /**
     * Overriding method saveoredit from controller interface 
     * to do data insertion or update if data exist
     * @param e entity variable input
     * @return true if operation succeed, false if operation fail
     */
    @Override
    public boolean saveOrEdit(E e) {
        boolean status = false;
        try {
            dao.function(e, 1,"", "",0);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    /**
     * Overriding method delete from controller interface to do data deletion
     * @param e entity variable input
     * @return true if operation succeed, false if operation fail
     */
    @Override
    public boolean delete(E e) {
        boolean status = false;
        try {
            dao.function(e, 2,"", "",0);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    /**
     * Overriding method getAll from controller interface to get all data from entity
     * @param e entity variable input
     * @return list containing all data from entity in form of entity variable
     */
    @Override
    public List<E> getAll(E e) {
        return dao.function(e, 3,"", "",0);
    }
   
   
    /**
     * Overriding method findById from controller interface to get data from entity
     * based from id
     * @param e entity variable input
     * @param id string for searching specific id
     * @return entity variable containing data from entity with specific id
     */
    @Override
    public E findById(E e, String id) {
        return (E) dao.function(e, 4,"", id,0).get(0);
    }
    
    public List<E> findByActive(E e, String id) {
        return dao.function(e, 6, id, "", 1);
    }
    /**
     * Overriding method getMaxId from controller interface to get highest id value from entity
     * @param e entity variable input
     * @return entity variable containing data with highest id value from entity
     */
    @Override
    public E getMaxId(E e) {
        return (E) dao.getMaxId(e);
    }
    
    @Override
    public List<E> search(E e, String category, String id){
        return (List<E>) dao.function(e, 5, category, id,0);
    }

}
