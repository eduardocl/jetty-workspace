package com.application.controller.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.application.domain.Contact;
import com.avaje.ebean.Ebean;

@ManagedBean(name="addContactMB")
@RequestScoped
public class AddContactMB {

	private Contact contact = new Contact();

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String save() {
		Ebean.save(contact);
		FacesUtil.addSuccessMessage("New contact added.");
		return "list.xhtml";
	}
}

