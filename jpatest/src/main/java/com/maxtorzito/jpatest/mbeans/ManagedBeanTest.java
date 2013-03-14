package com.maxtorzito.jpatest.mbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.maxtorzito.jpatest.ejb.IUsersLocal;
import com.maxtorzito.jpatest.model.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author maxtorzito
 */
@ManagedBean
@ViewScoped
public class ManagedBeanTest implements Serializable {

    @EJB
    private IUsersLocal ejb;

    /**
     * This method doesnt work
     * @param event 
     */
    public void editUserUsingCriterias(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String msg = "";
        System.out.println("editUserUsingCriterias");
        User userUsingCriterias = ejb.getUserUsingCriterias();
        userUsingCriterias.setNickName("NEW NICKNAME USING CRITERIAS");
        try {
            ejb.editUser(userUsingCriterias);
            msg = "DONE editUserUsingCriterias :)";
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.toString();
        }
        context.addMessage(null, new FacesMessage(msg));
    }

    /**
     * This method doesnt work
     * @param event 
     */
    public void editUserUsingJPQL(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String msg = "";
        System.out.println("editUserUsingJPQL");
        User userUsingJPQL = ejb.getUserUsingJPQL();
        userUsingJPQL.setNickName("NEW NICKNAME USING JPQL");
        try {
            ejb.editUser(userUsingJPQL);
            msg = "DONE editUserUsingJPQL :)";
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.toString();
        }
        context.addMessage(null, new FacesMessage(msg));
    }

    /**
     * This method WORKS!!!
     * @param event 
     */
    public void editUserUsingFind(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String msg = "";
        System.out.println("editUserUsingFind");
        User userUsingFind = ejb.getUserUsingFind();
        userUsingFind.setNickName("NEW NICKNAME USING FIND");
        try {
            ejb.editUser(userUsingFind);
            msg = "DONE editUserUsingFind :)";
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.toString();
        }
        context.addMessage(null, new FacesMessage(msg));
    }
}