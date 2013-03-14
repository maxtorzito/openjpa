/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxtorzito.jpatest.ejb;

import com.maxtorzito.jpatest.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maxtorzito
 */
@Local
public interface IUsersLocal{
    
    public List<User> getAllUsersUsingCriterias();
    public User getUserUsingJPQL();
    public User getUserUsingCriterias();
    public User getUserUsingFind();
    public void editUser(User user) throws Exception;
    
}
