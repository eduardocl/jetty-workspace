package org.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.application.FacesUtil;



@Named
@SessionScoped
public class BackBean implements Serializable{

	private String name;
	private String email;
	private Long idToDelete;
	
	private List<Contact> contatos = new ArrayList<Contact>(); //Ebean.find(Contact.class).findList(); ;
	
	@Inject
	private ContactDAO contactDAO;// = new ContactDAO();

	
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
		contact.setEmail(email);
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
	
	public String delete() {
		String value = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		contactDAO.delete(Long.valueOf(value));
		FacesUtil.addSuccessMessage("Deletado!");
		return "list.xhtml";
	}

	public String remove(ActionEvent event) {
		System.out.println("DELETANDO " + idToDelete);
		contactDAO.delete(idToDelete);
		FacesUtil.addSuccessMessage("Deletado!");
		return "list.xhtml";
	}
	
	public void setContactToDelete(Long id) {
		System.out.println("----------------->" + id);
	}
	
	public void contactToDelete() {
		System.out.println("-------------------> " + idToDelete);
	}
	
	public Long getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(Long idToDelete) {
		System.out.println("idToDelete: " + idToDelete);
		this.idToDelete = idToDelete;
	}
	
}
