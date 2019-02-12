/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vivian
 */
public class dao2 {
       private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    /**
     * Declaring constructor from class DAO
     *
     * @param sessionFactory
     */
    public dao2() {
        this.sessionFactory = NewHibernateUtil.getSessionFactory();
    }

    /**
     * Overriding method function from DAO Interface with function to save or
     * update, delete, getAll, getById
     *
     * @param s entity variable input
     * @param t option, save or update if = 1, delete if = 2, getAll if = 3,
     * getById if = 4, search if = 5
     * @param category search category for search purpose
     * @param search input string for getById purpose
     * @return list with entity variable with content varying with option
     */

    public List<Site> function(Site s, int t, String category, String search) {
        List<Site> data = new ArrayList<Site>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (t == 1) {
                session.saveOrUpdate(s);
            } else if (t == 2) {
                session.delete(s);
            } else if (t == 3) {
                data = session.
                        createQuery("from Site order by id").list();
            } else if (t == 4) {
                data = session.createCriteria(s.getClass())
                        .add(Restrictions.eq("id", search)).addOrder(Order.asc("id")).list();

            } else if (t == 5) {
                data = session.createCriteria(s.getClass())
                        .add(Restrictions.ilike(category, search, MatchMode.ANYWHERE))
                        .addOrder(Order.asc("id")).list();
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    
}
