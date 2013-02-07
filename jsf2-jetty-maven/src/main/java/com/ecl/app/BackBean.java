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
	//private ContactDAO contactDAO = new ContactDAO();
	
	//private ServerConfig config = new ServerConfig();
	//private DataSourceConfig postgresDb = new DataSourceConfig();
	//private EbeanServer server;
	
	public BackBean() {
//    	config.setName("pgtest");
//
//    	// Define DataSource parameters
//    	postgresDb.setDriver("org.postgresql.Driver");
//    	postgresDb.setUsername("postgres");
//    	postgresDb.setPassword("postgres");
//    	postgresDb.setUrl("jdbc:postgresql://127.0.0.1:5432/ebean");
//    	config.setDataSourceConfig(postgresDb);
//
//    	// specify a JNDI DataSource 
//    	// config.setDataSourceJndiName("someJndiDataSourceName");
//
//    	// set DDL options...
//    	config.setDdlGenerate(true);
//    	config.setDdlRun(true);
//    	config.setDatabasePlatform(new PostgresPlatform());
//    	config.addClass(Contact.class);
//    	
//    	config.setDefaultServer(false);
//    	config.setRegister(false);
//    	server = EbeanServerFactory.create(config);
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
		//contactDAO.persist(contact);
		//System.out.println( "----> " +  Ebean.find(Contact.class).findList().get(0).getNome());
		//getContatos();	
		return "welcome.xhtml";
	}

	public List<Contact> getContatos() {
		System.out.println("----------------------");
		//System.out.println(contactDAO.findAll());
		System.out.println("----------------------");

		//return contactDAO.findAll();
		//return contatos;
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
