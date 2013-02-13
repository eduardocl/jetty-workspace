package com.application.controller.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.application.domain.Contact;
import com.avaje.ebean.Ebean;

@ManagedBean(name="editContactMB")
@RequestScoped
public class EditContactMB implements Serializable{
	
	private Contact bean;
	
	public EditContactMB() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
		System.out.println("fetching contact id " + id);
		setBean(Ebean.find(Contact.class, Long.valueOf(id)));
	}

	public Contact getBean() {
		return bean;
	}

	public void setBean(Contact bean) {
		this.bean = bean;
	}
	
	public String save() {
		System.out.println("Saving " + bean);
		Ebean.update(bean);
		FacesUtil.addSuccessMessage("Contact edited");
		return "list.xhtml";
	}
	
}
