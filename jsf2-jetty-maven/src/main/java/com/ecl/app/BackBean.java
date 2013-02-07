package com.ecl.app;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.PostgresPlatform;


@ManagedBean(name="myBean")
@SessionScoped
public class BackBean {

	private String name;
	private List<Contact> contatos = Ebean.find(Contact.class).findList(); ;
	
	public BackBean() {
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String save() {
		System.out.println("-----> " + name);
		Contact contact = new Contact();
		contact.setNome(name);
		Ebean.save(contact);
		return "welcome.xhtml";
	}

	public List<Contact> getContatos() {
		return Ebean.find(Contact.class).findList();
	}

	public void setContatos(List<Contact> contatos) {
		this.contatos = contatos;
	}
	
	public String add() {
		System.out.println("retornar para addcontact");
		return "home.xhtml";
	}

	
}
