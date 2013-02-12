package com.ecl.app;



public class TestBD {

	public static void main(String[] args) {
		
		ContactDAO dao = new ContactDAO();
		
		Contact c = new Contact();
//		c.setNome("eduardo");
		c.setEmail("teste@gmail.com");
		
		dao.findAll();
		
	}
	
}
