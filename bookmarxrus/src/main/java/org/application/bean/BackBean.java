package org.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@RequestScoped
public class BackBean implements Serializable{

	private String name;
	private String email;
	
	private List<Contact> contatos = new ArrayList<Contact>(); //Ebean.find(Contact.class).findList(); ;
	
	@Inject
	private ContactDAO contactDAO;// = new ContactDAO();
	@Inject
	private FacesContext facesCtx;
	@Inject 
	private ThemeDAO themeDAO;
	
	//private ServerConfig config = new ServerConfig();
	//private DataSourceConfig postgresDb = new DataSourceConfig();
	//private EbeanServer server;
	
	public BackBean() {
		System.out.println("Backnean sendo instanciado");
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String save() {
		System.out.println("salvando bean");
		Contact contact = new Contact();
		contact.setNome(name);
		contactDAO.persist(contact);
		return "list.xhtml";
	}

	public String add() {
		System.out.println("retornar para addcontact");
		return "addcontact.xhtml";
	}
	
	public List<Contact> getContatos() {
		return contactDAO.findAll();
		//return Ebean.find(Contact.class).findList();
	}

	public void setContatos(List<Contact> contatos) {
		this.contatos = contatos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String edit() {
		//String value = (String) facesCtx.getExternalContext().getRequestParameterMap().get("editParameter");
		return "edit.xhtml";
	}
	
}
