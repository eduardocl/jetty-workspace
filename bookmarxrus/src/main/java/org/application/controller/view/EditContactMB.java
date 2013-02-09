package org.application.controller.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.application.model.Contact;
import org.application.persistence.ContactDAO;

@Named
@RequestScoped
public class EditContactMB implements Serializable{
	
	@Inject
	private ContactDAO contactDAO;
	private Contact bean;
	
	@PostConstruct
	public void loadBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
		System.out.println("fetching contact id " + id);
		setBean(contactDAO.load(Long.valueOf(id)));
	}

	public Contact getBean() {
		return bean;
	}

	public void setBean(Contact bean) {
		this.bean = bean;
	}
	
	public String save() {
		System.out.println(bean);
		contactDAO.update(getBean());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Editado!", "PrimeFaces rocks!"));
		return "list.xhtml";
	}
	
}
