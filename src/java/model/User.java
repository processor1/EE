/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author MSEP_PROCESSOR_CODEX
 */

@Named
@RequestScoped
public class User implements java.io.Serializable{

    private String firtName;
    private String lastName;
    private String emailAddress;

    public User() {

    }

    private User user;

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void createNewUser(){
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage("User First Name  " + user.getFirtName() + "  Last Name  " + user.getLastName() + "  Email Address  " + user.getEmailAddress()));
    }
}
