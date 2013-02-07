package com.ecl.app;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;

import com.avaje.ebean.Ebean;

@ManagedBean
@javax.faces.bean.SessionScoped
public class ThemeSwitcherBean implements Serializable{
        
    private Map<String, String> themes;
   
    private Theme theme;
   
    private String themeSelected = "aristo";

    public ThemeSwitcherBean() {
    	System.out.println("ThemeSwitcherBean is being instanciated");
    	init();
    	List<Theme> themes = Ebean.find(Theme.class).findList();
    	if(themes == null) {
    		System.out.println("Themes is null");
    		Theme theme = new Theme();
    		theme.setTheme("bootstrap");
    		Ebean.save(theme);
    	}else {
    		setTheme(themes.get(0));
    		System.out.println("Theme in the database: " + getTheme().getTheme());
    		if(themes.size() > 1) {
    			for(int i = 1; i<themes.size(); i++) {
    				Ebean.delete(Theme.class, themes.get(i).getId());
    			}
    		}
    	}
    }
    
    public Map<String, String> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, String> themes) {
    	this.themes = themes;
    }
    

   
    public void init() {
        themes = new TreeMap<String, String>();
        themes.put("Aristo", "aristo");
        themes.put("Black-Tie", "black-tie");
        themes.put("Blitzer", "blitzer");
        themes.put("Bluesky", "bluesky");
        themes.put("Casablanca", "casablanca");
        themes.put("Bootstrap", "bootstrap");
        themes.put("Cupertino", "cupertino");
        themes.put("Dark-Hive", "dark-hive");
        themes.put("Dot-Luv", "dot-luv");
        themes.put("Eggplant", "eggplant");
        themes.put("Excite-Bike", "excite-bike");
        themes.put("Flick", "flick");
        themes.put("Glass-X", "glass-x");
        themes.put("Hot-Sneaks", "hot-sneaks");
        themes.put("Humanity", "humanity");
        themes.put("Le-Frog", "le-frog");
        themes.put("Midnight", "midnight");
        themes.put("Mint-Choc", "mint-choc");
        themes.put("Overcast", "overcast");
        themes.put("Pepper-Grinder", "pepper-grinder");
        themes.put("Redmond", "redmond");
        themes.put("Rocket", "rocket");
        themes.put("Sam", "sam");
        themes.put("Smoothness", "smoothness");
        themes.put("South-Street", "south-street");
        themes.put("Start", "start");
        themes.put("Sunny", "sunny");
        themes.put("Swanky-Purse", "swanky-purse");
        themes.put("Trontastic", "trontastic");
        themes.put("UI-Darkness", "ui-darkness");
        themes.put("UI-Lightness", "ui-lightness");
        themes.put("Vader", "vader");
    }
    
    public void saveTheme() {
        //gp.setTheme(theme);
    	System.out.println(getTheme());
    	System.out.println(this.themeSelected);
    	if(getTheme() == null) {
    		Theme theme = new Theme();
    		theme.setTheme(this.themeSelected);
    		Ebean.save(theme);
    		setTheme(theme);
    	}else {
        	getTheme().setTheme(this.themeSelected);
        	Ebean.update(getTheme());
    	}
    	System.out.println("**************************");
    	System.out.println(Ebean.find(Theme.class).findList());
    	System.out.println("**************************");
    }

	public String getThemeSelected() {
		return themeSelected;
	}

	public void setThemeSelected(String themeSelected) {
		this.themeSelected = themeSelected;
	}

	public Theme getTheme() {
    	if(Ebean.find(Theme.class).findList() == null) {
    		System.out.println("themePersisted = null");
			Theme theme = new Theme();
			theme.setTheme("aristo");
			this.themeSelected = "aristo";
			Ebean.save(theme);
			this.setTheme(theme);
		}else {
		//	this.themeSelected = Ebean.find(Theme.class).findList().get(0).getTheme();
		//	this.setTheme(Ebean.find(Theme.class).findList().get(0));
		}
				
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}


}