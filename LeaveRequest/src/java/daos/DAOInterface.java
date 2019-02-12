/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.Serializable;
import java.util.List;

/**
 * This interface is used for declaring DAO Function
 * @author kresna92
 */
public interface DAOInterface<E> {

    public List<E> function(E s, int t, String category, String search,int search1);

    public E getMaxId(E t);

}
