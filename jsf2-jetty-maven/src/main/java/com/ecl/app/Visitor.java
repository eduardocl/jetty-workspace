package com.ecl.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Visitor implements Serializable {
  private String name = "nulo";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}