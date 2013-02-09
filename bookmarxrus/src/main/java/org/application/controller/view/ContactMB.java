package org.application.controller.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.application.FacesUtil;
import org.application.model.Contact;
import org.application.persistence.ContactDAO;

@Named
//@RequestScoped
@ConversationScoped
public class ContactMB implements Serializable{

	private Contact bean = new Contact();
	private Long idToDelete;
	private List<Contact> contacts = new ArrayList<Contact>();
	
	@Inject
	private ContactDAO contactDAO;
	
	@Inject private Conversation conversation;
	
	@PostConstruct
	public void init(){
		System.out.println("PostConstruct");
	}
	
	public Contact getBean() {
		return bean;
	}

	public void setBean(Contact bean) {
		this.bean = bean;
	}

	public String save() {
		contactDAO.persist(this.bean);
		return "list.xhtml";
	}

	public String add() {
		return "add.xhtml";
	}
	
	public String edit() {
		return "edit.xhtml";
	}
	
	public String delete() {
		String value = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		contactDAO.delete(Long.valueOf(value));
		FacesUtil.addSuccessMessage("Deletado!");
		return "list.xhtml";
	}

	public void remove() {
		System.out.println("Removing: " + idToDelete);
		contactDAO.delete(idToDelete);
		FacesUtil.addSuccessMessage("Deletado!");
		//this.conversation.end();
		//return "list.xhtml";
	}
	
	public List<Contact> getContacts() {
		return contactDAO.findAll();
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Long getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(Long idToDelete) {
		//if(this.conversation.isTransient()){
		//	this.conversation.begin();
		//}
		System.out.println("======================= idToDelete: " + idToDelete);
		this.idToDelete = idToDelete;
	}
	
}
