package org.application.controller.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.application.persistence.ContactDAO;

@Named
@SessionScoped
public class DeleteContactMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactDAO contactDAO;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void remove(){
		if(id != null){
			contactDAO.delete(id);
		}
	}
	
	
	
}
