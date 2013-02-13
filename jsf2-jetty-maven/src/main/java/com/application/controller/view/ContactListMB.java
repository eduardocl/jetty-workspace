package com.application.controller.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.application.domain.Contact;
import com.avaje.ebean.Ebean;


@ManagedBean(name="contactMB")
@ViewScoped
public class ContactListMB {

	private Contact bean;
	private List<Contact> contacts;
	private Long idToDelete;
	
	public ContactListMB() {
		System.out.println("ContactListMB()");
		this.contacts = getContactList();
	}
	
	
	public String save() {
		Ebean.save(getBean());
		return "welcome.xhtml";
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public String add() {
		return "add.xhtml";
	}

	public String edit() {
		return "update.xhtml";
	}

	public void remove() {
		Ebean.delete(Contact.class, idToDelete);
		FacesUtil.addSuccessMessage("Contact deleted.");
		setContacts(getContactList());
	}
	

	public Contact getBean() {
		return bean;
	}


	public void setBean(Contact bean) {
		this.bean = bean;
	}


	public Long getIdToDelete() {
		return idToDelete;
	}


	public void setIdToDelete(Long idToDelete) {
		this.idToDelete = idToDelete;
	}
	
	private List<Contact> getContactList(){
		return Ebean.find(Contact.class).findList();
	}
	
}
