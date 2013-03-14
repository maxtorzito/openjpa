/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxtorzito.jpatest.ejb;

import com.maxtorzito.jpatest.model.User;
import com.maxtorzito.jpatest.model.User_;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author maxtorzito
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UsersEJB implements IUsersLocal{

    @PersistenceContext(unitName = "maxtorzito_pu")
    private EntityManager em;
    @Resource
    private EJBContext ejbContext;
    
    @Override
    public List<User> getAllUsersUsingCriterias() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }
    
    @Override
    public User getUserUsingCriterias() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get(User_.userId), 1));
        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public User getUserUsingJPQL() {
        return em.createQuery("SELECT o FROM User o WHERE o.userId=1",User.class).getSingleResult();
    }

    @Override
    public User getUserUsingFind() {
        return em.find(User.class, 1);
    } 

    @Override
    public void editUser(User user) throws Exception{
        try{
            ejbContext.getUserTransaction().begin();
            em.merge(user);
            ejbContext.getUserTransaction().commit();
        }
        catch(Exception e){
            ejbContext.getUserTransaction().rollback();
            throw e;
        }   
    }   
}