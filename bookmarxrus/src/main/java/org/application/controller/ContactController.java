package org.application.controller;

import javax.inject.Inject;

import org.application.bean.ContactDAO;
import org.application.qualifiers.BusinessController;


@BusinessController
public class ContactController {

	@Inject
	private ContactDAO contactDAO;
	
	public ContactController() {
		System.out.println("ContactController#constructor");
	}
	
}
